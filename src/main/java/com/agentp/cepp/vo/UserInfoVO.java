package com.agentp.cepp.vo;

import com.agentp.cepp.dto.PageInfo;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class UserInfoVO{
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("权限")
    private Boolean permission;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

}
