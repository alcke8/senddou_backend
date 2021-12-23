package com.deeplify.tutorial.oauthlogin.table.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name = "us_id")
    private Long us_id;

    private String us_nickname;

    private String us_password;
    private String us_email;

    @Enumerated(EnumType.STRING)
    private UserType us_role;

    private String us_thumbnail;
    private LocalDateTime us_created_at;
    private Timestamp us_updated_at;

    @Builder
    public User(String nickname, String password, String email, UserType role, String thumbnail) {
        this.us_nickname = nickname;
        this.us_password = password;
        this.us_email = email;
        this.us_role = role;
        this.us_thumbnail = thumbnail;
    }

    public  void UserUpdate(String nickname,String thumbnail){
        this.us_nickname = nickname;
        this.us_thumbnail = thumbnail;
    }

}