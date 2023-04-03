package com.agentp.cepp.domain;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class UserInfo {
    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private Timestamp create_time;
}
