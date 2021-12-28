package com.deeplify.table.web.dto;

import com.deeplify.table.domain.ResumeComponent.ResumeComponent;
import com.deeplify.table.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResumeComponentDto {

    @Getter
    public static class Response {
        private Long id;
        private Resume resume;
        private int x;
        private int y;
        private int w;
        private int h;

        public Response(ResumeComponent component) {
            this.id = component.getRp_id();
            this.resume = component.getResume();
            this.x = component.getRp_x();
            this.y = component.getRp_y();
            this.w = component.getRp_w();
            this.h = component.getRp_h();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SaveRequest {
        private Resume resume;
        private int x;
        private int y;
        private int w;
        private int h;

        @Builder
        public SaveRequest(Resume resume, int x, int y, int w, int h) {
            this.resume = resume;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public ResumeComponent toEntity() {
            return ResumeComponent.builder()
                    .resume(resume)
                    .x(x)
                    .y(y)
                    .w(w)
                    .h(h)
                    .build();
        }
    }


    @NoArgsConstructor
    @Getter
    public static class UpdateRequest {
        private int x;
        private int y;
        private int w;
        private int h;

        @Builder
        public UpdateRequest(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }
}
