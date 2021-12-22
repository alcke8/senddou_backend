package com.deeplify.tutorial.oauthlogin.table.domain.controller;

import com.deeplify.tutorial.oauthlogin.table.domain.user.UserResume;
import com.deeplify.tutorial.oauthlogin.table.service.UserResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserResumeController {

    private final UserResumeService userResumeService;

    @GetMapping("/users/new")
    public String createUser(Model model){
        model.addAttribute("userForm",new UserForm());
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String create(@Valid UserForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "users/createUserForm";
        }

        UserResume userResume = new UserResume();
        userResume.setUs_name(form.getName());
        userResume.setUs_email(form.getEmail());

        userResumeService.join(userResume);
        return "redirect:/";
    }

}
