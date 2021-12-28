package com.deeplify.table.service;

import com.deeplify.table.domain.resumedetail.ResumeDetail;
import com.deeplify.table.domain.resumedetail.ResumeDetailRepository;
import com.deeplify.table.web.dto.ResumeDetailDto;
import com.deeplify.table.web.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ResumeDetailService {

    private final ResumeDetailRepository resumeDetailRepository;


    @Transactional
    public Long save(ResumeDetailDto.SaveRequest requestDto){
        return resumeDetailRepository.save(requestDto.toEntity()).getRd_id();
    }

    @Transactional
    public Long update(Long id, ResumeDetailDto.UpdateRequest requestDto){
        ResumeDetail resumeDetail = resumeDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        resumeDetail.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public ResumeDetailDto.Response findById(Long id) {
        ResumeDetail entity = resumeDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));

        return new ResumeDetailDto.Response(entity);
    }

    @Transactional
    public List<ResumeDetailDto.Response> findAllDesc() {
        return resumeDetailRepository.findAll().stream()
                .map(ResumeDetailDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        ResumeDetail resumeDetail = resumeDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("햐해당 유저가 없습니다. id= " + id));

        resumeDetailRepository.delete(resumeDetail);
    }
}
