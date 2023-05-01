package com.agentp.cepp.entity;

import com.agentp.cepp.enums.UserStatusType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-28
 */
@Getter
@Setter
@TableName("user_type")
@ApiModel(value = "UserType", description = "用户权限类型表")
public class UserType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户权限")
    @TableField("permission")
    private UserStatusType permission;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
