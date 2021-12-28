package com.deeplify.table.web.dto;

import com.deeplify.table.domain.resumecontent.ResumeContent;
import com.deeplify.table.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResumeContentDto {

    @Getter
    public static class Response {
        private Long id;
        private String company;
        private User user;
        private String title;

        public Response(ResumeContent content) {
            this.id = content.getRc_id();
            this.company = content.getRc_company();
            this.user = content.getUser();
            this.title = content.getRc_title();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SaveRequest {
        private String company;
        private User user;
        private String title;

        @Builder
        public SaveRequest(String company, User user, String title) {
            this.company = company;
            this.user = user;
            this.title = title;
        }

        public ResumeContent toEntity() {
            return ResumeContent.builder()
                    .company(company)
                    .user(user)
                    .title(title)
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class updateRequest {
        private String company;
        private String title;

        @Builder
        public updateRequest(String company, String title) {
            this.company = company;
            this.title = title;
        }
    }
}
