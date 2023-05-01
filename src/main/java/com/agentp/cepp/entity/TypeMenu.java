package com.agentp.cepp.entity;

import com.agentp.cepp.entity.BaseEntity;
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
 * @since 2023-04-29
 */
@Getter
@Setter
@TableName("type_menu")
@ApiModel(value = "TypeMenu对象", description = "")
public class TypeMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("type_id")
    private Integer typeId;

    @TableField("menu_id")
    private Integer menuId;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
