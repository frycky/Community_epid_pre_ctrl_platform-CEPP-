package com.agentp.cepp.controller;


import com.agentp.cepp.common.PageVO;
import com.agentp.cepp.common.Result;
import com.agentp.cepp.dto.TypeMenuDto;
import com.agentp.cepp.dto.UserTypeDto;
import com.agentp.cepp.entity.MenuList;
import com.agentp.cepp.entity.TypeMenu;
import com.agentp.cepp.entity.UserType;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-28
 */
@Api(value = "用户类型模块",tags = "用户类型模块")
@RestController
@RequestMapping("/user_type")
public class UserTypeController extends BaseController {

    @ApiOperation("列表展示")
    @GetMapping("/list")
    public Result list(){
        return Result.success(userTypeService.list());
    }
//
    @PostMapping("/save")
    public Result save(@Validated @RequestBody UserType userType){
        userTypeService.saveOrUpdate(userType);
        return Result.success();
    }
//
    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids){
        userTypeService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping("/getByTypeId")
    public Result getById(@RequestParam("typeId") Integer typeId){
        LambdaQueryWrapper<TypeMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TypeMenu::getTypeId,typeId);

        ArrayList<MenuList> arrayList = new ArrayList<>();
        List<TypeMenu> list = typeMenuService.list(wrapper);
        list.forEach(item->{
            //拿到菜单id
            MenuList byId = menuListService.getById(item.getMenuId());
            arrayList.add(byId);
        });
        return Result.success(arrayList);
    }

    //绑定权限与左侧菜单
    @ApiOperation("绑定权限与菜单")
    @PostMapping("/saveTypeAndMenu")
    public Result saveTypeAndMenu(@RequestBody TypeMenuDto typeMenuDto){
        //插入数据前先删除
        LambdaQueryWrapper<TypeMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TypeMenu::getTypeId,typeMenuDto.getTypeId());
        List<TypeMenu> list=typeMenuService.list(wrapper);
        list.forEach(item->{
            typeMenuService.removeById(item.getId());
        });

        typeMenuDto.getMenuIdList().forEach(item->{
            TypeMenu typeMenu = new TypeMenu();
            typeMenu.setTypeId(typeMenuDto.getTypeId());
            typeMenu.setMenuId(item);
            typeMenuService.saveOrUpdate(typeMenu);
        });
        return Result.success();

    }

    @ApiOperation("分页展示")
    @PostMapping("/pageType")
    public Result pageType(@RequestBody UserTypeDto userTypeDto){
        LambdaQueryWrapper<UserType> wrapper = new LambdaQueryWrapper<>();
        //模糊查询like
        if(userTypeDto.getDescription()!=null&& !"".equals(userTypeDto.getDescription())){
            wrapper.like(UserType::getDescription,userTypeDto.getDescription());
        }

        Page<UserType> page = userTypeService.page(
                new Page<>(
                        userTypeDto.getPageNum(),
                        userTypeDto.getPageSize()
                ),
                wrapper
        );
        return Result.success(new PageVO<>(page));
    }


}
