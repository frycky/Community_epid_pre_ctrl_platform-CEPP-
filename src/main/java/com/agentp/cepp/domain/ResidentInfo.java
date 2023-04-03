package com.agentp.cepp.domain;

import lombok.Data;

@Data
public class ResidentInfo {
   private Integer id;
   private String name;
   private String gender;
   private Integer age;
   private String phone;
   private String address;
   private String health_code;
}
