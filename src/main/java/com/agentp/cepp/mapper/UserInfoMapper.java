package com.agentp.cepp.mapper;

import com.agentp.cepp.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-04
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 批量插入，仅适用于mysql
     */
//    Integer insertBatchSomeColum(Collection<UserInfo> entityList);


}
