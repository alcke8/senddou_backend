package com.deeplify.tutorial.oauthlogin.table.domain.resumecontent;

import com.deeplify.tutorial.oauthlogin.table.domain.user.UserResume;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ResumeContent {

    @Id @GeneratedValue
    @Column(name = "rc_id")
    private Long rc_id;

    private String rc_company;

    @ManyToOne
    @JoinColumn(name = "rc_user_us_id")
    private UserResume userResume;

    private String rc_title;
    private LocalDateTime rc_created_at;
    private Timestamp rc_updated_at;
}