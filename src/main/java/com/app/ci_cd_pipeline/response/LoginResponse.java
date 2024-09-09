package com.app.ci_cd_pipeline.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {

    private Long expiresIn;

    private String accessToken;

    private String refreshToken;

    private UserResponse user;
}
