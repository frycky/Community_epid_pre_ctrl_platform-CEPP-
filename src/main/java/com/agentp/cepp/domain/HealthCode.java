package com.agentp.cepp.domain;

import lombok.Data;

@Data
public class HealthCode {
    private Integer id;
    private String name;
    private String health_certificate;
    private String status;
}
