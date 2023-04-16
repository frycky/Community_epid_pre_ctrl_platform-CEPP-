package com.agentp.cepp.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum UserStatusType {
    ADMIN(0, "普通用户"),
    REGULAR_USER(1, "管理员");

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


    UserStatusType(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
