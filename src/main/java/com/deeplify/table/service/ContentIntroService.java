package com.deeplify.table.service;

import com.deeplify.table.domain.contenttype.ContentIntroduce;
import com.deeplify.table.domain.contenttype.ContentIntroduceRepository;
import com.deeplify.table.web.dto.ContentIntroduceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ContentIntroService {

    private final ContentIntroduceRepository contentIntroduceRepository;

    @Transactional
    public Long save(ContentIntroduceDto.SaveRequest requestDto){
        return contentIntroduceRepository.save(requestDto.toEntity()).getCi_id();
    }

    @Transactional
    public Long update(Long id, ContentIntroduceDto.UpdateRequest requestDto){
        ContentIntroduce contentIntroduce = contentIntroduceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        contentIntroduce.update(requestDto.getTitle());
        return id;
    }

    public ContentIntroduceDto.Response findById(Long id) {
        ContentIntroduce entity = contentIntroduceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));

        return new ContentIntroduceDto.Response(entity);
    }

    @Transactional
    public List<ContentIntroduceDto.Response> findAllDesc() {
        return contentIntroduceRepository.findAll().stream()
                .map(ContentIntroduceDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        ContentIntroduce contentIntroduce = contentIntroduceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("햐해당 유저가 없습니다. id= " + id));

        contentIntroduceRepository.delete(contentIntroduce);
    }
}
