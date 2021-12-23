package com.deeplify.tutorial.oauthlogin.table.web.controller;

import com.deeplify.tutorial.oauthlogin.table.service.UserResumeService;
import com.deeplify.tutorial.oauthlogin.table.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users",method = RequestMethod.POST)
public class UserController {

    private final UserResumeService userResumeService;

    @GetMapping("/")
    public String createUser(){
        return "createUserForm";
    }

    @PostMapping("/new")
    public String create(@Valid UserSaveRequestDto dto,
                         @RequestBody UserSaveRequestDto udto,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "createUserForm";
        }

         userResumeService.join(udto);
        return "redirect:/";
    }

}
