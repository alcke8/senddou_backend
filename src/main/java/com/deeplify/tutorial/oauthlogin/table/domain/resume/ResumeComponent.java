package com.deeplify.tutorial.oauthlogin.table.domain.resume;

import com.deeplify.tutorial.oauthlogin.table.domain.resumecontent.ResumeContent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ResumeComponent {

    @Id @GeneratedValue
    @Column(name = "rp_id")
    private Long rp_id;

    private String rp_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rp_fk_id")
    private Resume resume;

    private String rp_name;
    private int rp_x;
    private int rp_y;
    private int rp_w;
    private int rp_n;
    private LocalDateTime rp_created_at;
    private Timestamp rp_updated_at;
}