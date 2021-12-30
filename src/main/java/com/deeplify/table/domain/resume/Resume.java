package com.deeplify.table.domain.resume;

import com.deeplify.table.domain.BaseTimeEntity;
import com.deeplify.table.domain.ResumeComponent.ResumeComponent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Resume extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "re_id")
    private Long re_id;



    @JoinColumn(name = "rp_id")
    @OneToOne
    private ResumeComponent resumeComponent;

    @Column(name = "re_title")
    private String re_title;

    private String re_company;

    private int re_share_count;


    @Builder
    public Resume(String title, String company, int shareCount) {
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
    public void addShare() {
       int re_share_count = 0;
        this.re_share_count += 1;
    }

    public void delShare() {
        this.re_share_count -= 1;
    }

}