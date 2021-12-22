package com.deeplify.tutorial.oauthlogin.table.domain.resumecontent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class IntroduceDetail {

    @Id @GeneratedValue
    @Column(name = "id_id")
    private Long id_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rc_id")
    private ResumeContent resumeContent;
    private String id_title;
    private String id_content;
    private LocalDateTime id_created_at;
    private Timestamp id_updated_at;

}
