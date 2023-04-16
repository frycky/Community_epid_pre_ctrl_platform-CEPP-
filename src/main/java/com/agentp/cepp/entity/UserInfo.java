package com.agentp.cepp.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-04
 */
@Getter
@Setter
@TableName("user_info")
@ApiModel(value = "UserInfo对象", description = "用户信息表")
public class UserInfo extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 1,max = 20,message = "用户名为1-20位")
    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 8,max = 100,message = "密码为8-20位")
    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

//    @ApiModelProperty("创建时间")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//    @TableField(value = "create_time",fill = FieldFill.INSERT)
//    private LocalDateTime createTime;

}
