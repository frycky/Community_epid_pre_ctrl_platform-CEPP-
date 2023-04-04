package com.agentp.cepp.controller;


import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-04
 */
@Api(value = "用户表控制模块",tags = "用户表控制模块")
@RestController
@RequestMapping("/user-info")
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;
    @ApiOperation("列表展示")
    @GetMapping("/list")
    public List<UserInfo> list(){
        return userInfoService.list();
    }
}
