package com.agentp.cepp.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
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
@TableName("epidemic_info")
@ApiModel(value = "EpidemicInfo对象", description = "")
public class EpidemicInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("location")
    private String location;

    @TableField("date")
    private LocalDate date;

    @TableField("description")
    private String description;

    @TableField("status")
    private Integer status;


}
