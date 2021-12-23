package com.deeplify.tutorial.oauthlogin.table.web.dto;

import com.deeplify.tutorial.oauthlogin.table.domain.resume.Resume;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResumeRequestDto {

    private Long id;
    private String title;
    private String company;
    private int share_count;

    public ResumeRequestDto(Resume resume) {
        this.id = resume.getRe_id();
        this.title = resume.getRe_title();
        this.company = resume.getRe_company();
        this.share_count = resume.getRe_share_count();
    }

    public Resume toEntity()
    {
        return Resume.builder()
                .title(title)
                .company(company)
                .shareCount(share_count)
                .build();
    }
}
