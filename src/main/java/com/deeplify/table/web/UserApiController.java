package com.deeplify.table.web;

import com.deeplify.table.service.UserService;
import com.deeplify.table.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    };
}
