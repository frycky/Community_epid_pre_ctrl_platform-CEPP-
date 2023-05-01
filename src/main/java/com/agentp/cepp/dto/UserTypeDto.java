package com.agentp.cepp.dto;

import com.agentp.cepp.enums.UserStatusType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserTypeDto extends PageInfo{

    @ApiModelProperty("描述")
    private String description;



}
