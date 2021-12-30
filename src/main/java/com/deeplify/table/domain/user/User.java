package com.deeplify.table.domain.user;

import com.deeplify.table.domain.BaseTimeEntity;
import com.deeplify.table.domain.resumecontent.ResumeContent;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private Long us_id;

    @OneToMany(mappedBy = "user")
    private List<ResumeContent> resumeContents = new ArrayList<>();

    private String us_nickname;

    private String us_password;
    private String usEmail;

    @Enumerated(EnumType.STRING)
    private UserType us_role;

    private String us_thumbnail;

    @Builder
    public User(String nickname, String password, String email, UserType role, String thumbnail) {
        this.us_nickname = nickname;
        this.us_password = password;
        this.usEmail = email;
        this.us_role = role;
        this.us_thumbnail = thumbnail;
    }

    public void update(String nickname,String thumbnail){
        this.us_nickname = nickname;
        this.us_thumbnail = thumbnail;
    }

}