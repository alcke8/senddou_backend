package com.deeplify.table.service;

import com.deeplify.table.domain.resume.Resume;
import com.deeplify.table.domain.resume.ResumeRepository;
import com.deeplify.table.web.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeService {

   private final ResumeRepository resumeRepository;

    @Transactional
    public Long save(ResumeDto.SaveRequest requestDto){
        return resumeRepository.save(requestDto.toEntity()).getRe_id();
    }

    @Transactional
    public Long update(Long id, ResumeDto.UpdateRequest requestDto){
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이력서가 없습니다. id = " + id));
        resume.update(requestDto.getTitle(),requestDto.getTitle(), requestDto.getShareCount());
        return id;
    }

    public ResumeDto.Response findById(Long id) {
        Resume entity = resumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이력서가 없습니다. id = " + id));

        return new ResumeDto.Response(entity);
    }

    @Transactional
    public List<ResumeDto.Response> findAllDesc() {
        return resumeRepository.findAll().stream()
                .map(ResumeDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이력서가 없습니다. id= " + id));

        resumeRepository.delete(resume);
    }
}
