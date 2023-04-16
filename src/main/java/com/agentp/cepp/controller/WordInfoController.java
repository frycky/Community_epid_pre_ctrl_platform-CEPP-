package com.agentp.cepp.controller;


import com.agentp.cepp.common.PageVO;
import com.agentp.cepp.common.Result;
import com.agentp.cepp.dto.WordInfoDto;

import com.agentp.cepp.entity.CategoryInfo;
import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.entity.WordInfo;

import com.agentp.cepp.mapper.WordInfoMapper;
import com.agentp.cepp.vo.UsernameAndWordVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-20
 */
@Api(value = "文章表控制模块", tags = "文章表控制模块")
@RestController
@RequestMapping("/word-info")
public class WordInfoController extends BaseController {
    @ApiOperation("列表展示")
    @GetMapping("/list")
    public Result<WordInfo> list() {
        return Result.success(wordInfoService.list());
    }

    @ApiOperation("保存")
    @PostMapping("/saveTitle")
    public Result save(@Validated @RequestBody WordInfo wordInfo) {
        wordInfoService.saveOrUpdate(wordInfo);
        return Result.success();
    }

    @ApiOperation("删除")
    @PostMapping("/deleteTitle")
    public Result deleteTitle(@RequestBody List<Integer> ids) {
        wordInfoService.removeByIds(ids);
        return Result.success();
    }

    @ApiOperation("分页展示")
    @PostMapping("/pageTitle")
    public Result pageTitle(@RequestBody WordInfoDto wordInfoDto) {
        LambdaQueryWrapper<CategoryInfo> wrapper = new LambdaQueryWrapper<>();
        //模糊查询like
        if (wordInfoDto.getTitle() != null && !"".equals(wordInfoDto.getTitle())) {
            wrapper.like(CategoryInfo::getTitle, wordInfoDto.getTitle());
        }

        Page<CategoryInfo> page = categoryInfoService.page(
                new Page<>(
                        wordInfoDto.getPageNum(),
                        wordInfoDto.getPageSize()
                ),
                wrapper
        );
        return Result.success(new PageVO<>(page));
    }

    @ApiOperation("文章分页")
    @PostMapping("/pageArticle")
    public Result pageArticle(@RequestBody WordInfoDto wordInfoDto) {
        LambdaQueryWrapper<WordInfo> wrapper = new LambdaQueryWrapper<>();
        Boolean getTitle = false;
        //模糊查询like
        if (wordInfoDto.getTitle() != null && !"".equals(wordInfoDto.getTitle())) {

            Page<WordInfo> page = wordInfoMapper.selectUW(
                    new Page<>(
                            wordInfoDto.getPageNum(),
                            wordInfoDto.getPageSize()
                    ),
                    wrapper,
                    true,
                    "%" + wordInfoDto.getTitle() + "%"
            );
            return Result.success(new PageVO<>(page));
        }
        Page<WordInfo> page = wordInfoMapper.selectUW(
                new Page<>(
                        wordInfoDto.getPageNum(),
                        wordInfoDto.getPageSize()
                ),
                wrapper,
                false,
                null
        );
        return Result.success(new PageVO<>(page));
    }
}
