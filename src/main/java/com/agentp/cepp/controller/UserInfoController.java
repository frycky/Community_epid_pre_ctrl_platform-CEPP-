package com.agentp.cepp.controller;


import com.agentp.cepp.common.PageVO;
import com.agentp.cepp.common.Result;
import com.agentp.cepp.dto.PageInfo;
import com.agentp.cepp.dto.UserLoginDto;
import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.exception.CustomException;
import com.agentp.cepp.utils.JwtUtils;
import com.agentp.cepp.vo.UserInfoVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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


    @ApiOperation("列表展示")
    @GetMapping("/list")
    public List<UserInfo> list(){
        return userInfoService.list();
    }

    @PostMapping("/page1")
    public Result findPage1(@RequestBody PageInfo pageInfo){
        Page<UserInfo> page = userInfoService.page(
                new Page<>(
                        pageInfo.getPageNum(),
                        pageInfo.getPageSize()
                )
        );
        return Result.success(page);
    }
    @PostMapping("/page2")
    public Result findPage2(@RequestBody PageInfo pageInfo){
        Page<UserInfo> page = userInfoService.page(
                new Page<>(
                        pageInfo.getPageNum(),
                        pageInfo.getPageSize()
                )
        );
        return new Result().success1(new PageVO(page));
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody UserInfo userInfo){
        userInfoService.saveOrUpdate(userInfo);
        return Result.success();
    }

    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids){
        userInfoService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping("/getlogin")
    public Result getLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUsername,username)
                .eq(UserInfo::getPassword,password)
                .last("limit 1");
        UserInfo userone = userInfoService.getOne(wrapper);

        if(userone!=null){
            //生成jwt
            String token = JwtUtils.generateToken(userone);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("token",token);
            map.put("username",userone.getUsername());
            map.put("email",userone.getEmail());
            map.put("create_time",userone.getCreateTime());
            return Result.success(map);

        }else {
            throw new CustomException("请检查用户名密码是否正确");
        }

    }
    //TODO todo功能测试
    @PostMapping("/postlogin")
    public Result postLogin(@Validated @RequestBody UserLoginDto userLoginDto){
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUsername,userLoginDto.getUsername())
                .eq(UserInfo::getPassword,userLoginDto.getPassword())
                .last("limit 1");
        UserInfo userone = userInfoService.getOne(wrapper);

        if(userone!=null){
            //生成jwt
            String token = JwtUtils.generateToken(userone);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("token",token);
            map.put("username",userone.getUsername());
            map.put("email",userone.getEmail());
            map.put("create_time",userone.getCreateTime());
            return Result.success(map);

        }else {
            throw new CustomException("请检查用户名密码是否正确");
        }
    }


    //需求，通过用户id查询出用户相关信息用于前端展示
    @GetMapping("/getById")
    public Result getById(@RequestParam("id") Integer id){
        UserInfo byid = userInfoService.getById(id);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(byid,userInfoVO);
        return Result.success(userInfoVO);
    }


}
