package com.agentp.cepp.serviceImpl;

import com.agentp.cepp.common.Result;
import com.agentp.cepp.dto.UserRegisterDto;
import com.agentp.cepp.entity.UserInfo;

import com.agentp.cepp.mapper.UserInfoMapper;
import com.agentp.cepp.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Random;
import java.util.UUID;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Fry_code
 * @since 2023-04-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
//    @Autowired
//    private UserInfoMapper userInfoMapper;

//    public void change() {
//        String str = RandomString.make(10);
//
//        String uuid = UUID.randomUUID().toString();
//        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
//
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername(str);
//        userInfo.setPassword(uuid);
//        userInfo.setEmail(numSize() + "@qq.com");
//        userInfo.setCreateTime(dateTime);
//        userInfoMapper.insert(userInfo);
//    }
//
//    public String numSize() {
//        Random random = new Random();
//        int n = 0;
//        int i = 0;
//        int numlength = 10;
//        Integer[] values = new Integer[10];
//        String num = "";
//        while (n < numlength) {
//            int onenum = random.nextInt(9);
//            values[n] = onenum;
//            n++;
//        }
//        for (Integer j : values) {
//            num = num + values[j];
//        }
//
//        return num;
//    }
//
//    public Result saveToSql(UserInfo userInfo){
//        userInfoMapper.insert(userInfo);
//        return Result.success(userInfoMapper);
//    }

}
