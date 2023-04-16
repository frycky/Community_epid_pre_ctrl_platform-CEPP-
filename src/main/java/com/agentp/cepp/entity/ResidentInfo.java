package com.agentp.cepp.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("resident_info")
@ApiModel(value = "ResidentInfo对象", description = "居民信息表")
public class ResidentInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("健康码")
    @TableField("health_code")
    private String healthCode;


}
