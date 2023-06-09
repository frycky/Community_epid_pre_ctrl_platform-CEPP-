package com.agentp.cepp.entity;

import com.agentp.cepp.enums.ArticleStatusType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-20
 */
@Data
@TableName("word_info")
@ApiModel(value = "WordInfo对象", description = "文章信息表")
public class WordInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("发布来源")
    @TableField("user_id")
    private Integer userId;

    private String username;


    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @NotBlank(message = "标题不能为空")
    @ApiModelProperty("文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("文章内容")
    @TableField("article")
    private String article;

    @ApiModelProperty("状态 /审核中/已发布/已删除/已封禁")
    @TableField("status")
    private ArticleStatusType status;

    @ApiModelProperty("浏览量")
    @TableField("views")
    private Integer views;

}
