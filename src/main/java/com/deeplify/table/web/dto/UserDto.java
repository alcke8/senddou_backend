package com.deeplify.table.web.dto;

import com.deeplify.table.domain.user.User;
import com.deeplify.table.domain.user.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class UserDto {

    @Getter
    public static class Response {
        private Long id;
        private String nickname;
        private String password;
        private String email;
        private String thumbnail;
        private UserType role;

        public Response(User user) {
            this.id = user.getUs_id();
            this.nickname = user.getUs_nickname();
            this.password = user.getUs_password();
            this.email = user.getUs_email();
            this.thumbnail = user.getUs_thumbnail();
            this.role = user.getUs_role();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SaveRequest {
        private String nickname;
        private String password;
        private String email;
        private String thumbnail;
        private UserType role;

        @Builder
        public SaveRequest(String nickname, String password, String email, String thumbnail, UserType role) {
            this.nickname = nickname;
            this.password = password;
            this.email = email;
            this.thumbnail = thumbnail;
            this.role = role;
        }


        public User toEntity() {
            return User.builder()
                    .nickname(nickname)
                    .password(password)
                    .email(email)
                    .thumbnail(thumbnail)
                    .role(UserType.USER)
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class UpdateRequest {
        private String nickname;
        private String thumbnail;

        @Builder

        public UpdateRequest(String nickname, String thumbnail) {
            this.nickname = nickname;
            this.thumbnail = thumbnail;
        }
    }
}
