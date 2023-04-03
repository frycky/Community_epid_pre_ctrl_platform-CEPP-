package com.agentp.cepp.dao;

import com.agentp.cepp.domain.UserInfo;
import com.agentp.cepp.utils.JtimeToSqltime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataDaoTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JtimeToSqltime jtime;

    @Test
    void UserSave(){
        UserInfo user = new UserInfo();
        user.setUsername("张三");
        user.setPassword("czmhhxx.");
        user.setEmail("zhangsan@gmail.com");
        user.setCreate_time(jtime.JtoSqlTimestamp());
        userDao.insert(user);
        System.out.println(jtime.JtoSqlTimestamp());
    }


}
