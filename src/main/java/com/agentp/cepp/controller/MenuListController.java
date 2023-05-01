package com.agentp.cepp.controller;


import com.agentp.cepp.common.PageVO;
import com.agentp.cepp.common.Result;
import com.agentp.cepp.dto.MenuListDto;
import com.agentp.cepp.entity.TypeMenu;
import com.agentp.cepp.entity.UserType;
import com.agentp.cepp.entity.MenuList;
import com.agentp.cepp.service.TypeMenuService;
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
@Api(value = "菜单类型模块",tags = "菜单类型模块")
@RestController
@RequestMapping("/menu-list")
public class MenuListController extends BaseController {
    @ApiOperation("列表展示")
    @GetMapping("/list")
    public Result list(){
        return Result.success(menuListService.list());
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody MenuList menuList){
        menuListService.saveOrUpdate(menuList);
        return Result.success();
    }

    @ApiOperation("删除")
    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids){
        menuListService.removeByIds(ids);
        return Result.success();
    }

//    @GetMapping("/getByMenuId")
//    public Result getById(@RequestParam("menuId") Integer menuId){
//        LambdaQueryWrapper<TypeMenu> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(TypeMenu::getMenuId,menuId);
//
//        ArrayList<MenuList> arrayList = new ArrayList<>();
//        List<TypeMenu> list = typeMenuService.list(wrapper);
//        list.forEach(item->{
//            //拿到菜单id
//            MenuList byId = menuListService.getById(item.getMenuId());
//            arrayList.add(byId);
//        });
//        return Result.success(arrayList);
//    }

//    //需求，通过用户id查询出用户相关信息用于前端展示
//    @GetMapping("/getById")
//    public Result getById(@RequestParam("id") Integer id){
//        MenuList byid = menuListService.getById(id);
//        MenuListVO MenuListVO = new MenuListVO();
//        BeanUtils.copyProperties(byid,MenuListVO);
//        return Result.success(MenuListVO);
//    }

    @ApiOperation("分页展示")
    @PostMapping("/pageMenu")
    public Result pageMenu(@RequestBody MenuListDto menuListDto){
        LambdaQueryWrapper<MenuList> wrapper = new LambdaQueryWrapper<>();
        //模糊查询like
        if(menuListDto.getTitle()!=null&& !"".equals(menuListDto.getTitle())){
            wrapper.like(MenuList::getTitle,menuListDto.getTitle());
        }

        Page<MenuList> page = menuListService.page(
                new Page<>(
                        menuListDto.getPageNum(),
                        menuListDto.getPageSize()
                ),
                wrapper
        );
        return Result.success(new PageVO<>(page));
    }
}
