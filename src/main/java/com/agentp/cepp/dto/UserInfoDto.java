package com.agentp.cepp.dto;

import com.agentp.cepp.enums.UserStatusType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoDto extends PageInfo{
    @ApiModelProperty("注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("权限")
    private UserStatusType permission;
}
