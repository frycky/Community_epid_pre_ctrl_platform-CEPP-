package com.agentp.cepp.dto;

import com.agentp.cepp.enums.ArticleStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WordInfoDto extends PageInfo{

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("用户")
    private String username;

    @ApiModelProperty("浏览量")
    private String views;

    @ApiModelProperty("状态 /审核中/已发布/已删除/已封禁")
    private ArticleStatusType status;

    @ApiModelProperty("文章内容")
    private String article;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

}
