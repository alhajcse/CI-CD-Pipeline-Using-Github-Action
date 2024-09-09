package com.app.ci_cd_pipeline.service;

import com.app.ci_cd_pipeline.dto.LoginDto;
import com.app.ci_cd_pipeline.dto.UserDto;
import com.app.ci_cd_pipeline.entity.Users;
import com.app.ci_cd_pipeline.response.LoginResponse;

public interface UserService {
     Users saveUser(UserDto dto);

    LoginResponse login(LoginDto dto);


}
