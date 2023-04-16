package com.agentp.cepp.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ArticleStatusType {

    REVIEWING(0,"审核中"),
    NORMAL(1,"已发布"),
    DELETED(2,"已删除"),
    BANNED(3,"已封禁");

    /**
     * 存到数据库的值
     */
    @EnumValue
    private Integer key;

    /**
     * 前端显示的值
     */
    @JsonValue
    private String name;


    ArticleStatusType(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
