package com.agentp.cepp.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;

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
@ApiModel(value = "ResidentInfo对象", description = "")
public class ResidentInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("gender")
    private String gender;

    @TableField("age")
    private Integer age;

    @TableField("phone")
    private String phone;

    @TableField("address")
    private String address;

    @TableField("health_code")
    private String healthCode;


}
