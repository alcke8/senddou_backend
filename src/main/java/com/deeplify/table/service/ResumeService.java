package com.deeplify.tutorial.oauthlogin.table.service;

import com.deeplify.tutorial.oauthlogin.table.domain.resume.Resume;
import com.deeplify.tutorial.oauthlogin.table.repository.ResumeRepository;
import com.deeplify.tutorial.oauthlogin.table.web.dto.ResumeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Transactional
    public Long join(ResumeRequestDto resumeRequestDto){

        return resumeRequestDto.getId();
    }


//    @Transactional
//    public void deleteResume(Long id){
//        Resume resume = resumeRepository.findByResumeId(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 이력서가 없습니다. id= " + id));
//        resumeRepository.deleteResume(resume);
//    }
}
