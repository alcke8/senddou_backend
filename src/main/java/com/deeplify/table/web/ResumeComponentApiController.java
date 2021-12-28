package com.deeplify.table.web;

import com.deeplify.table.service.ResumeComponentService;
import com.deeplify.table.web.dto.ResumeComponentDto;
import com.deeplify.table.web.dto.ResumeContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class
ResumeComponentApiController {

    private final ResumeComponentService resumeComponentService;

    @PostMapping("/api/v1/rp")
    public Long save(@RequestBody ResumeComponentDto.SaveRequest requestDto){
        return resumeComponentService.save(requestDto);
    }

    @PostMapping("/api/v1/rp/{id}")
    public Long update(@PathVariable Long id, @RequestBody ResumeComponentDto.UpdateRequest requestDto){
        return resumeComponentService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/rp/{id}")
    public Long delete(@PathVariable Long id) {
        resumeComponentService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/rp/{id}")
    public ResumeComponentDto.Response findById (@PathVariable Long id) {
        return resumeComponentService.findById(id);
    }

    @GetMapping("/api/v1/rp")
    public List<ResumeComponentDto.Response> findAll() {
        return resumeComponentService.findAllDesc();
    };

}
