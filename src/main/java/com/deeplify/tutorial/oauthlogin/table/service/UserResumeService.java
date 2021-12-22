package com.deeplify.tutorial.oauthlogin.table.service;

import com.deeplify.tutorial.oauthlogin.table.domain.user.User;
import com.deeplify.tutorial.oauthlogin.table.repository.UserResumeRepository;
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
    public Long join(User userResume){

        validateDuplicateUser(userResume);
        userResumeRepository.save(userResume);
        return userResume.getUs_id();
    }

    private void validateDuplicateUser(User userResume) {
        List<User> findUserResumes = userResumeRepository.findByName(userResume.getUs_name());
        if (!findUserResumes.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}