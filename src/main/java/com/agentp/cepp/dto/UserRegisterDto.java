package com.agentp.cepp.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterDto extends PageInfo{
    @NotBlank(message = "用户名不能为空")
    @Length(min = 1,max = 20,message = "用户名在1-20位之间")
    @ApiModelProperty("用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 8,max = 100,message = "密码在8-20位之间")
    @ApiModelProperty("密码")
    private String password;

    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty("邮箱")
    private String email;

}
