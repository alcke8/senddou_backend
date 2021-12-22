package com.deeplify.tutorial.oauthlogin.table.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class UserResume {

    @Id @GeneratedValue
    @Column(name = "us_id")
    private Long us_id;

    private String us_name;

    private String us_password;
    private String us_email;
    private String us_role;
    private String us_thumbnail;
    private LocalDateTime us_created_at;
    private Timestamp us_updated_at;
}