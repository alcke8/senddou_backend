package com.deeplify.table.web;

import com.deeplify.table.service.ResumeDetailService;
import com.deeplify.table.web.dto.ResumeContentDto;
import com.deeplify.table.web.dto.ResumeDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ResumeDetailApiController {

    private final ResumeDetailService resumeDetailService;

    @PostMapping("/api/v1/rd")
    public Long save(@RequestBody ResumeDetailDto.SaveRequest requestDto) {
        return resumeDetailService.save(requestDto);
    }

    @PostMapping("/api/v1/rd/{id}")
    public Long update(@PathVariable Long id, @RequestBody ResumeDetailDto.UpdateRequest requestDto) {
        return resumeDetailService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/rd/{id}")
    public Long delete(@PathVariable Long id) {
        resumeDetailService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/rd/{id}")
    public ResumeDetailDto.Response findById(@PathVariable Long id) {
        return resumeDetailService.findById(id);
    }

    @GetMapping("/api/v1/rd")
    public List<ResumeDetailDto.Response> findAll() {
        return resumeDetailService.findAllDesc();
    };
}