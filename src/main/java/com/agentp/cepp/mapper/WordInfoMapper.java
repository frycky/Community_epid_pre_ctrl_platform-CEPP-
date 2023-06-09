package com.agentp.cepp.mapper;

import com.agentp.cepp.entity.WordInfo;

import com.agentp.cepp.vo.UsernameAndWordVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-20
 */
@Mapper
@Repository
public interface WordInfoMapper extends BaseMapper<WordInfo> {

    Page<WordInfo> selectUW(Page<WordInfo> page, LambdaQueryWrapper<WordInfo> wrapper,@Param("getTitle")Boolean getTitle,@Param("title")String title);

}
