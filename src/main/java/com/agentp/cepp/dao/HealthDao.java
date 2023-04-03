package com.agentp.cepp.dao;


import com.agentp.cepp.domain.HealthCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthDao extends BaseMapper<HealthCode> {
}
