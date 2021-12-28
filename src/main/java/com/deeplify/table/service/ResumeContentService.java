package com.deeplify.table.service;

import com.deeplify.table.domain.resumecontent.ResumeContent;
import com.deeplify.table.domain.resumecontent.ResumeContentRepository;
import com.deeplify.table.web.dto.ResumeContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeContentService {

    private final  ResumeContentRepository resumeContentRepository;

    @Transactional
    public Long save(ResumeContentDto.SaveRequest requestDto){
        return resumeContentRepository.save(requestDto.toEntity()).getRc_id();
    }

    @Transactional
    public Long update(Long id, ResumeContentDto.updateRequest requestDto){
        ResumeContent resumeContent = resumeContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        resumeContent.update(requestDto.getTitle(), requestDto.getCompany());
        return id;
    }

    public ResumeContentDto.Response findById(Long id) {
        ResumeContent entity = resumeContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));

        return new ResumeContentDto.Response(entity);
    }

    @Transactional
    public List<ResumeContentDto.Response> findAllDesc() {
        return resumeContentRepository.findAll().stream()
                .map(ResumeContentDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        ResumeContent resumeContent = resumeContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("햐해당 유저가 없습니다. id= " + id));

        resumeContentRepository.delete(resumeContent);
    }
}
