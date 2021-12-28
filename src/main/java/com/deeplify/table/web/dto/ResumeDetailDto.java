package com.deeplify.table.web.dto;

import com.deeplify.table.domain.contenttype.ContentIntroduce;
import com.deeplify.table.domain.resumedetail.ResumeDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResumeDetailDto {

    @Getter
    public static class Response {
        private Long id;
        private ContentIntroduce contentIntroduce;
        private String title;
        private String content;

        public Response(ResumeDetail detail) {
            this.id = detail.getRd_id();
            this.contentIntroduce = detail.getContentIntroduce();
            this.title = detail.getRd_title();
            this.content = detail.getRd_content();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SaveRequest {
        private ContentIntroduce contentIntroduce;
        private String title;
        private String content;

        @Builder
        public SaveRequest(ContentIntroduce contentIntroduce, String title, String content) {
            this.contentIntroduce = contentIntroduce;
            this.title = title;
            this.content = content;
        }

        public ResumeDetail toEntity() {
            return ResumeDetail.builder()
                    .contentIntroduce(contentIntroduce)
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class UpdateRequest {
        private String title;
        private String content;

        @Builder
        public UpdateRequest(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }
}
