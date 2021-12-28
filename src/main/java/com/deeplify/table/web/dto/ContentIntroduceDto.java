package com.deeplify.table.web.dto;

import com.deeplify.table.domain.contenttype.ContentIntroduce;
import com.deeplify.table.domain.resumecontent.ResumeContent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ContentIntroduceDto {

    @Getter
    public static class Response {
        private Long id;
        private String title;
        private ResumeContent resumeContent;
        private String contentType;

        public Response(ContentIntroduce contentIntroduce) {
            this.id = contentIntroduce.getCi_id();
            this.title = contentIntroduce.getCi_title();
            this.resumeContent = contentIntroduce.getResumeContent();
            this.contentType = contentIntroduce.getContentType();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SaveRequest {
        private String title;
        private ResumeContent resumeContent;
        private String contentType;

        @Builder
        public SaveRequest(String title, ResumeContent resumeContent,String contentType) {
            this.title = title;
            this.resumeContent = resumeContent;
            this.contentType = contentType;
        }


        public ContentIntroduce toEntity() {
            return ContentIntroduce.builder()
                    .title(title)
                    .resumeContent(resumeContent)
                    .contentType(contentType)
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class UpdateRequest {
        private String title;

        @Builder
        public UpdateRequest(String title) {
            this.title = title;
        }
    }
}
