package com.deeplify.tutorial.oauthlogin.table.web.dto;

import com.deeplify.tutorial.oauthlogin.table.domain.user.User;
import com.deeplify.tutorial.oauthlogin.table.domain.user.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSaveRequestDto {

    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String thumbnail;
    private UserType role;


    public UserSaveRequestDto(User user) {
        this.id = user.getUs_id();
        this.nickname = user.getUs_nickname();
        this.password = user.getUs_password();
        this.email = user.getUs_email();
        this.thumbnail = user.getUs_thumbnail();
        this.role = UserType.USER;
    }

    public User toEntity()
    {
        return User.builder()
                .nickname(nickname)
                .password(password)
                .email(email)
                .thumbnail(thumbnail)
                .role(UserType.USER)
                .build();
    }
}
