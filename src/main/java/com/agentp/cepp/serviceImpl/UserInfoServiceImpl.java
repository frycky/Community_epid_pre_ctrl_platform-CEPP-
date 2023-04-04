package com.agentp.cepp.serviceImpl;

import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.mapper.UserInfoMapper;
import com.agentp.cepp.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
