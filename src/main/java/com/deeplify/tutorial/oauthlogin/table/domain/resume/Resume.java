package com.deeplify.tutorial.oauthlogin.table.domain.resume;

import com.deeplify.tutorial.oauthlogin.table.domain.BaseTimeEntity;
import com.deeplify.tutorial.oauthlogin.table.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
public class Resume extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "re_id")
    private Long re_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "re_user_us_id")
    private User user;

    @Column(name = "re_title")
    private String re_title;

    private String re_company;

    private int re_share_count;

    private LocalDateTime re_created_at;
    private Timestamp re_updated_at;

    @Builder
    public Resume(User user, String title, String company, int shareCount) {
        this.user = user;
        this.re_title = title;
        this.re_company = company;
        this.re_share_count = shareCount;
    }

    public void update(String title, String company, int shareCount) {
        this.re_title = title;
        this.re_company = company;
        this.re_share_count = shareCount;
    }



    /**
     * share 증가
     */
    public void addShare(int share) {
        this.re_share_count += share;
    }

}