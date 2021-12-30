package com.deeplify.table.web;

import com.deeplify.table.service.ResumeService;
import com.deeplify.table.web.dto.ResumeContentDto;
import com.deeplify.table.web.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResumeAPiController {

    private final ResumeService resumeService;

    @PostMapping("/api/v1/re")
    public Long save(@RequestBody ResumeDto.SaveRequest requestDto){
        return resumeService.save(requestDto);
    }

    @PostMapping("/api/v1/re/{id}")
    public Long update(@PathVariable Long id, @RequestBody ResumeDto.UpdateRequest requestDto){
        return resumeService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/re/{id}")
    public Long delete(@PathVariable Long id) {
        resumeService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/re/{id}")
    public ResumeDto.Response findById (@PathVariable Long id) {
        return resumeService.findById(id);
    }

    @GetMapping("/api/v1/re")
    public List<ResumeDto.Response> findAll() {
        return resumeService.findAllDesc();
    };
}
