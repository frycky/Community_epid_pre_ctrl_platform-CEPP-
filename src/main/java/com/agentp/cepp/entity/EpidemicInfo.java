package com.agentp.cepp.entity;


import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDate;
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
 * @since 2023-04-04
 */
@Getter
@Setter
@TableName("epidemic_info")
@ApiModel(value = "EpidemicInfo对象", description = "疫情信息表")
public class EpidemicInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("地点")
    @TableField("location")
    private String location;

    @ApiModelProperty("日期")
    @TableField(value = "date",fill = FieldFill.INSERT)
    private LocalDateTime date;

    @ApiModelProperty("详细信息")
    @TableField("description")
    private String description;

    @ApiModelProperty("状态")
    @TableField("status")
    private Integer status;


}
