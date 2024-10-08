package com.app.ci_cd_pipeline.response;

import com.app.ci_cd_pipeline.entity.Role;
import com.app.ci_cd_pipeline.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String username;
    private String email;
    Set<Role> roles;

    public static UserResponse from(Users users) {
        UserResponse response = new UserResponse();
        response.setId(users.getId());
        response.setName(users.getName());
        response.setUsername(users.getUsername());
        response.setEmail(users.getEmail());
        response.setRoles(users.getRoles());
        return response;
    }
}
