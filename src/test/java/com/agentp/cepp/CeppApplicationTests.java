package com.agentp.cepp;


import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.serviceImpl.UserInfoServiceImpl;
import com.agentp.cepp.utils.JtimeToSqltime;
import com.agentp.cepp.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CeppApplicationTests {

    @Test
    void contextLoads() {
        JtimeToSqltime jtime = new JtimeToSqltime();
        System.out.println(jtime.JtoSqlTimestamp().toString());
    }

    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;

    @Test
    void testInsert() {
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 400; i++) {
            userInfoServiceImpl.change();
        }
        long endtime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endtime-starttime)+"ms");

    }
    @Test
    void testJwt() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("李四");
        userInfo.setPassword("czmhhxx0");
        userInfo.setEmail("231245892@gmail.com");
        System.out.println(JwtUtils.generateToken(userInfo));
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6ImN6bWhoeHgwIiwiZXhwIjoxNjgwNzgzNzU2LCJ1c2VySWQiOm51bGwsImlhdCI6MTY4MDc4MTE2NCwiZW1haWwiOiIyMzEyNDU4OTJAZ21haWwuY29tIiwianRpIjoidG9rZW5JZCIsInVzZXJuYW1lIjoi5p2O5ZubIn0.WwXHYLEfJG1owKR8-XKnHO5_cS4McLqObiKYYlVtmxA";
        Claims verifyJwt = JwtUtils.verifyJwt(token);
    }

}
