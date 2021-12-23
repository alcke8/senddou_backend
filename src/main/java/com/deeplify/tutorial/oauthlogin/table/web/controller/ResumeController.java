package com.deeplify.tutorial.oauthlogin.table.web.controller;

import com.deeplify.tutorial.oauthlogin.table.service.ResumeService;
import com.deeplify.tutorial.oauthlogin.table.web.dto.ResumeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/resume", method = RequestMethod.POST)
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/")
    public String createResume(){
        return "createResume";
    }

    @PostMapping("/new")
    public String create(@Valid ResumeRequestDto dto,
                         @RequestBody ResumeRequestDto rdto,
                         BindingResult result){
        if(result.hasErrors()){
            return "createResume";
        }

        resumeService.join(rdto);
        return "redirect:/";
    }

}
