package com.agentp.cepp.mapper;

import com.agentp.cepp.entity.CategoryInfo;
import com.agentp.cepp.entity.WordInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
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
public interface CategoryInfoMapper extends BaseMapper<CategoryInfo> {

}
