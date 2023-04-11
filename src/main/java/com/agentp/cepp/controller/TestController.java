package com.agentp.cepp.controller;

import com.agentp.cepp.common.Result;

import com.agentp.cepp.mapper.UserInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Api(value = "测试模块",tags = "测试模块")
@RestController
public class TestController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @ApiOperation("测试统一返回类成功")
    @GetMapping("/success")
    public Result success(){
        return Result.success(userInfoMapper.selectList(null));
    }

    @ApiOperation("测试统一返回类失败")
    @GetMapping("/error")
    public Result error(){
        return Result.error("测试统一返回类失败");
    }



}
