package com.deeplify.table.web.dto;

import com.deeplify.table.domain.resume.Resume;
import com.deeplify.table.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResumeDto {

    @Getter
    public static class Response {
        private Long id;
        private String title;
        private String company;
        private int shareCount;

        public Response(Resume resume) {
            this.id = resume.getRe_id();
            this.title = resume.getRe_title();
            this.company = resume.getRe_company();
            this.shareCount = resume.getRe_share_count();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SaveRequest {
        private String title;
        private String company;
        private int shareCount;

        @Builder
        public SaveRequest(String title, String company, int shareCount) {
            this.title = title;
            this.company = company;
            this.shareCount = shareCount;
        }

        public Resume toEntity() {
            return Resume.builder()
                    .title(title)
                    .company(company)
                    .shareCount(shareCount)
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class UpdateRequest {
        private String title;
        private String company;
        private int shareCount;

        @Builder
        public UpdateRequest(String title, String company, int shareCount) {
            this.title = title;
            this.company = company;
            this.shareCount = shareCount;
        }
    }
}
