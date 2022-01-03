package com.deeplify.table.web;

import com.deeplify.table.domain.user.User;
import com.deeplify.table.service.UserService;
import com.deeplify.table.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserApiController {

    @Autowired
    private final UserService userService;

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UserDto.SaveRequest requestDto){
        return userService.save(requestDto);
    }

    @PostMapping("/api/v1/users/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserDto.UpdateRequest requestDto){
        return userService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public Long delete(@PathVariable Long id) {
        userService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/users/{id}")
    public UserDto.Response findById (@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/api/v1/users")
    public List<UserDto.Response> findAll() {
        return userService.findAllDesc();
    }


    @GetMapping("/api/v1/users/new")
    public String createUser(Model model){
        model.addAttribute("userDto", new UserDto());
        return "";
    }

    @PostMapping("/api/v1/users/new")
    public String create(@Valid BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "";
        }

        User user = new User();
        user.setUsEmail(user.getUsEmail());
        user.setUs_id(user.getUs_id());
        user.setUs_nickname(user.getUs_nickname());
        user.setUs_password(user.getUs_password());
        user.setUs_thumbnail(user.getUs_thumbnail());
        user.setUs_role(user.getUs_role());

        userService.join(user);

        return "redirect:/";
    }
}
