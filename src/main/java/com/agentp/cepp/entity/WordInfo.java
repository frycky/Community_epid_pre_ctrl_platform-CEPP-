package com.agentp.cepp.entity;

import com.agentp.cepp.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-16
 */
@Getter
@Setter
@TableName("word_info")
@ApiModel(value = "WordInfo对象", description = "文章管理表")
public class WordInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "标题不能为空")
    @ApiModelProperty("文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("文章内容")
    @TableField("article")
    private String article;

    @ApiModelProperty("浏览量")
    @TableField("views")
    private String views;


}
