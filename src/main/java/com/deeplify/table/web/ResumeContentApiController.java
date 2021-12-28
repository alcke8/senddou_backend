package com.deeplify.table.web;

import com.deeplify.table.service.ResumeContentService;
import com.deeplify.table.web.dto.ResumeContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ResumeContentApiController {

    private final ResumeContentService resumeContentService;

    @PostMapping("/api/v1/rc")
    public Long save(@RequestBody ResumeContentDto.SaveRequest requestDto){
        return resumeContentService.save(requestDto);
    }

    @PostMapping("/api/v1/rc/{id}")
    public Long update(@PathVariable Long id, @RequestBody ResumeContentDto.updateRequest requestDto){
        return resumeContentService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/rc/{id}")
    public Long delete(@PathVariable Long id) {
        resumeContentService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/rc/{id}")
    public ResumeContentDto.Response findById (@PathVariable Long id) {
        return resumeContentService.findById(id);
    }

    @GetMapping("/api/v1/rc")
    public List<ResumeContentDto.Response> findAll() {
        return resumeContentService.findAllDesc();
    };
}
