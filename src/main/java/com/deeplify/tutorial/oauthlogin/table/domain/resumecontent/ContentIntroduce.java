package com.deeplify.tutorial.oauthlogin.table.domain.resumecontent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ContentIntroduce {

    @Id @GeneratedValue
    @Column(name = "ci_id")
    private Long ci_id;

    private String ci_title;

    @ManyToOne
    @JoinColumn(name = "rc_id")
    private ResumeContent resumeContent;

    private LocalDateTime ci_created_at;
    private Timestamp ci_updated_at;
}