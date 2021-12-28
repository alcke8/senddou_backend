package com.deeplify.table.web;

import com.deeplify.table.service.ContentIntroService;
import com.deeplify.table.web.dto.ContentIntroduceDto;
import com.deeplify.table.web.dto.ResumeContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentIntroApiController {

    private final ContentIntroService contentIntroService;

    @PostMapping("/api/v1/ci")
    public Long save(@RequestBody ContentIntroduceDto.SaveRequest requestDto){
        return contentIntroService.save(requestDto);
    }

    @PostMapping("/api/v1/ci/{id}")
    public Long update(@PathVariable Long id, @RequestBody ContentIntroduceDto.UpdateRequest requestDto){
        return contentIntroService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/ci/{id}")
    public Long delete(@PathVariable Long id) {
        contentIntroService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/ci/{id}")
    public ContentIntroduceDto.Response findById (@PathVariable Long id) {
        return contentIntroService.findById(id);
    }

    @GetMapping("/api/v1/ci")
    public List<ContentIntroduceDto.Response> findAll() {
        return contentIntroService.findAllDesc();
    };
}
