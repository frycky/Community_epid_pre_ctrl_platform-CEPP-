package com.agentp.cepp.entity;

import com.agentp.cepp.entity.BaseEntity;
import com.agentp.cepp.enums.UserStatusType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("menu_list")
@ApiModel(value = "MenuList对象", description = "菜单信息表")
public class MenuList extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("title")
    private String title;

    @TableField("path")
    private String path;

    @TableField("permission")
    private UserStatusType permission;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
