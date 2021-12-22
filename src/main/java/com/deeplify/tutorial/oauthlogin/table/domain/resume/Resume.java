package com.deeplify.tutorial.oauthlogin.table.domain.resume;

import com.deeplify.tutorial.oauthlogin.table.domain.user.UserResume;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Resume {

    @Id @GeneratedValue
    @Column(name = "re_id")
    private Long re_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "re_user_us_id")
    private UserResume userResume;

    @Column(name = "re_title")
    private String re_title;

    private String re_company;

    private int re_share_count;

    private LocalDateTime re_created_at;
    private Timestamp re_updated_at;

    /**
     * share 증가
     */
    public void addShare(int share) {
        this.re_share_count += share;
    }

}