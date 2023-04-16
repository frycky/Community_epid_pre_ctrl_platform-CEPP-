package com.agentp.cepp.vo;

import com.agentp.cepp.enums.ArticleStatusType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsernameAndWordVO {
    private Integer id;
    private String username;
    private String title;
    private LocalDateTime createTime;
    private ArticleStatusType status;
}
