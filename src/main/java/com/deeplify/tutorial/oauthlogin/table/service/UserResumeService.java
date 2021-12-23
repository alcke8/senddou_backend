package com.deeplify.tutorial.oauthlogin.table.service;

import com.deeplify.tutorial.oauthlogin.table.domain.user.User;
import com.deeplify.tutorial.oauthlogin.table.repository.UserResumeRepository;
import com.deeplify.tutorial.oauthlogin.table.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserResumeService {

    private final UserResumeRepository userResumeRepository;

    @Transactional
    public Long join(UserSaveRequestDto userSaveRequestDto){

        validateDuplicateUser(userSaveRequestDto);
        userResumeRepository.save(userSaveRequestDto);
        return userSaveRequestDto.getId();
    }

    private void validateDuplicateUser(UserSaveRequestDto user) {
        List<User> findEmail = userResumeRepository.findByName(user.getEmail());
        if (!findEmail.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}