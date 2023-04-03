package com.agentp.cepp.domain;

import lombok.Data;

import java.util.Date;

@Data
public class EpidemicInfo {
    private Integer id;
    private String location;
    private Date date;
    private String description;
    private Boolean status;
}
