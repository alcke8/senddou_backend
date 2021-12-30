package com.deeplify.table.domain.controller;

import com.deeplify.oauth.KakaoProfile;
import com.deeplify.oauth.OauthToken;
import com.deeplify.table.domain.user.UserType;
import com.deeplify.table.service.UserService;
import com.deeplify.table.web.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Value("${cos.key}")
    private String cosKey;

    private final UserService userService;

    @GetMapping("/auth/kakao/callback")
    @ResponseBody
    public String KakaoCallback(String code) {
        /**
         * post방식 key value
         */
        RestTemplate rt = new RestTemplate();

        /**
         *  httpheader 오브젝트 생성성
         */
       HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","bb778b6314bd58c77aee20d5565a47e0");
        params.add("redirect_uri","http://localhost:8080/auth/kakao/callback");
        params.add("code",code);

        /**
         * httpheader와 httpbody를 하나의 오브젝트에 담기
         */
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest=
                new HttpEntity<>(params,headers);

        /**
         * http요청 - post방식으로 - response변수의 응답
         */
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        OauthToken oauthToken = null;

        try {
            oauthToken = objectMapper.readValue(response.getBody(),OauthToken.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("카카오 엑세스 토큰"+oauthToken.getAccess_token());

        /**
         * post방식 key value
         */
        RestTemplate rt2 = new RestTemplate();

        /**
         *  httpheader 오브젝트 생성성
         */
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization","Bearer " + oauthToken.getAccess_token());
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");


        /**
         * httpheader와 httpbody를 하나의 오브젝트에 담기
         */
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest=
                new HttpEntity<>(headers2);

        /**
         * http요청 - post방식으로 - response변수의 응답
         */
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class );

        System.out.println(response2.getBody());

        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;

        try {
            kakaoProfile = objectMapper2.readValue(response2.getBody(),KakaoProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("카카오 아이디(번호): " + kakaoProfile.getId());
        System.out.println("카카오 이메일: " + kakaoProfile.getKakao_account().getEmail());

        System.out.println("카카오 유저네임: "+  kakaoProfile.getKakao_account().getEmail()+"-"+kakaoProfile.getId());
        System.out.println("이메일: "+kakaoProfile.getKakao_account().getEmail());

        System.out.println("임시비번: "+cosKey);


        /**
         * save
         */
        UserDto.SaveRequest kakaoUser = UserDto.SaveRequest.builder()
                        .nickname(kakaoProfile.getKakao_account().getProfile().getNickname())
                                .password(cosKey)
                                        .email(kakaoProfile.getKakao_account().getEmail())
                                                .thumbnail(kakaoProfile.getKakao_account().getProfile().getThumbnail_image_url())
                                                        .role(UserType.USER)
                                                                .build();


        System.out.println("카카오 빌드: "+kakaoUser.getEmail());

        UserDto.Response origin = userService.findByEmail(kakaoProfile.getKakao_account().getEmail());

        System.out.println("origin: "+ origin);

        if(origin.getEmail() == null) {
            userService.save(kakaoUser);
        }


        return "회원가입 완료"; //redirect"/"
    }

}
