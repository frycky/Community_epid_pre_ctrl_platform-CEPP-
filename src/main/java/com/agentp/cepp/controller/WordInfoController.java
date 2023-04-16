package com.agentp.cepp.controller;


import com.agentp.cepp.common.PageVO;
import com.agentp.cepp.common.Result;
import com.agentp.cepp.dto.PageInfo;
import com.agentp.cepp.dto.WordInfoDto;
import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.entity.WordInfo;
import com.agentp.cepp.service.WordInfoService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.agentp.cepp.controller.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-16
 */
@Api(value = "文章表控制模块",tags = "文章表控制模块")
@RestController
@RequestMapping("/word-info")
public class WordInfoController extends BaseController {

    @ApiOperation("列表展示")
    @GetMapping("/list")
    public Result<WordInfo> list(){
        return Result.success(wordInfoService.list());
    }

    @ApiOperation("保存")
    @PostMapping("/saveTitle")
    public Result save(@Validated @RequestBody WordInfo wordInfo){
        wordInfoService.saveOrUpdate(wordInfo);
        return Result.success();
    }

    @ApiOperation("删除")
    @PostMapping("/deleteTitle")
    public Result deleteTitle(@RequestBody List<Integer> ids){
        wordInfoService.removeByIds(ids);
        return Result.success();
    }

    @ApiOperation("分页展示")
    @PostMapping("/pageTitle")
    public Result pageTitle(@RequestBody WordInfoDto wordInfoDto){
        LambdaQueryWrapper<WordInfo> wrapper = new LambdaQueryWrapper<>();
        //模糊查询like
        if(wordInfoDto.getTitle()!=null&& !"".equals(wordInfoDto.getTitle())){
            wrapper.like(WordInfo::getTitle,wordInfoDto.getTitle());
        }

        Page<WordInfo> page = wordInfoService.page(
                new Page<>(
                        wordInfoDto.getPageNum(),
                        wordInfoDto.getPageSize()
                ),
                wrapper
        );
        return Result.success(new PageVO<>(page));
    }
}
