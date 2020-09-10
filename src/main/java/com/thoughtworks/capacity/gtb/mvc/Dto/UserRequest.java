package com.thoughtworks.capacity.gtb.mvc.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @NotEmpty(message = "用户名不为空")
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message= "用户名不合法,只能由字母、数字或下划线组成")
    @Size(min=3, max=10, message= "用户名不合法,长度为3到10位")
    private String username;

    @NotEmpty(message = "密码不为空")
    @Size(min=5, max=12, message= "密码不合法,长度为5到12位")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;
}
