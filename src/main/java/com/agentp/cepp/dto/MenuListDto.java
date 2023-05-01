package com.agentp.cepp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MenuListDto extends PageInfo{

    @ApiModelProperty("标题")
    private String title;
}
