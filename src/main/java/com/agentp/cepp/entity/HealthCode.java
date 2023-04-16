package com.agentp.cepp.entity;


import com.agentp.cepp.enums.ArticleStatusType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("health_code")
@ApiModel(value = "HealthCode对象", description = "健康码表")
public class HealthCode extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("申请人姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("图片")
    @TableField("health_certificate")
    private String healthCertificate;

    @ApiModelProperty("状态")
    @TableField("status")
    private ArticleStatusType status;


}
