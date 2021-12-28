package com.deeplify.table.service;

import com.deeplify.table.domain.ResumeComponent.ResumeComponent;
import com.deeplify.table.domain.ResumeComponent.ResumeComponentRepository;
import com.deeplify.table.web.dto.ResumeComponentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeComponentService {

    private final ResumeComponentRepository resumeComponentRepository;

    @Transactional
    public Long save(ResumeComponentDto.SaveRequest requestDto){
        return resumeComponentRepository.save(requestDto.toEntity()).getRp_id();
    }

    @Transactional
    public Long update(Long id, ResumeComponentDto.UpdateRequest requestDto){
        ResumeComponent resumeComponent = resumeComponentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        resumeComponent.update(requestDto.getX(),requestDto.getY(),requestDto.getW(),requestDto.getH());
        return id;
    }

    public ResumeComponentDto.Response findById(Long id) {
        ResumeComponent entity = resumeComponentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));

        return new ResumeComponentDto.Response(entity);
    }

    @Transactional
    public List<ResumeComponentDto.Response> findAllDesc() {
        return resumeComponentRepository.findAll().stream()
                .map(ResumeComponentDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        ResumeComponent resumeComponent = resumeComponentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("햐해당 유저가 없습니다. id= " + id));

        resumeComponentRepository.delete(resumeComponent);
    }
}
