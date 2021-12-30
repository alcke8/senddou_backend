package com.deeplify.table.service;

import com.deeplify.table.domain.user.User;
import com.deeplify.table.domain.user.UserRepository;
import com.deeplify.table.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDto.SaveRequest requestDto){
        return userRepository.save(requestDto.toEntity()).getUs_id();
    }


    @Transactional
    public Long update(Long id, UserDto.UpdateRequest requestDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        user.update(requestDto.getNickname(), requestDto.getThumbnail());
        return id;
    }

    public UserDto.Response findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));

        return new UserDto.Response(entity);
    }

    public UserDto.Response findByEmail(String email) {
        User entity = userRepository.findByUsEmail(email)
                .orElseGet(()->{
                    return new User();
                });

        return new UserDto.Response(entity);
    }

    @Transactional
    public List<UserDto.Response> findAllDesc() {
        List<UserDto.Response> users = userRepository.findAll().stream()
                .map(UserDto.Response::new)
                .collect(Collectors.toList());

        System.out.println("users = " + users);
        return users;
    }

    @Transactional
    public void delete (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));

        userRepository.delete(user);
    }

}