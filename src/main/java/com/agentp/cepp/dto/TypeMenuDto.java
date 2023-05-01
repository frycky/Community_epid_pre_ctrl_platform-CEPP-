package com.agentp.cepp.dto;

import com.agentp.cepp.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-29
 */
@Data
public class TypeMenuDto {

//    @NotBlank(message = "用户权限不能为空")
    @ApiModelProperty("用户权限")
    private Integer typeId;

//    @NotBlank(message = "可视菜单不能为空")
    @ApiModelProperty("可视菜单")
    private List<Integer> menuIdList;



}
