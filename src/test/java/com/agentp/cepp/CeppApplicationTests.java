package com.agentp.cepp;


import com.agentp.cepp.common.PageVO;
import com.agentp.cepp.common.Result;
import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.entity.WordInfo;
import com.agentp.cepp.mapper.WordInfoMapper;
import com.agentp.cepp.serviceImpl.UserInfoServiceImpl;
import com.agentp.cepp.utils.JtimeToSqltime;
import com.agentp.cepp.utils.JwtUtils;
import com.agentp.cepp.vo.UsernameAndWordVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@SpringBootTest
class CeppApplicationTests {

    @Test
    void contextLoads() {
        JtimeToSqltime jtime = new JtimeToSqltime();
        System.out.println(jtime.JtoSqlTimestamp().toString());
    }

    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;

//    @Test
//    void testInsert() {
//        long starttime = System.currentTimeMillis();
//        for (int i = 0; i < 400; i++) {
//            userInfoServiceImpl.change();
//        }
//        long endtime = System.currentTimeMillis();
//        System.out.println("程序运行时间："+(endtime-starttime)+"ms");
//
//    }
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

    @Autowired
    private WordInfoMapper wordInfoMapper;
//    @Test
//    void testSql(){
//        Page<WordInfo> page = new Page<>(1,4);
//        page.setOptimizeCountSql(false);
//        LambdaQueryWrapper<WordInfo> wrapper = new LambdaQueryWrapper<>();
//        Page<WordInfo> VO = wordInfoMapper.selectUW(page,wrapper);
//        System.out.println("数据："+VO.getRecords());
//
//    }
}

//    @Test
//    void testSelectOrdersPage() {
//        // 查询第一页，每页显示 10 条
//        // Page<OrderVO> page = new Page<>(1, 10);
//        // 注意：一定要手动关闭 SQL 优化，不然查询总数的时候只会查询主表
//        // page.setOptimizeCountSql(false);
//        // 组装查询条件 where age = 20
//        // QueryWrapper<OrderVO> queryWrapper = new QueryWrapper<>();
//        // queryWrapper.ge("age", 20);
//        // IPage<OrderVO> page1 = userMapper.selectOrderPage(page, queryWrapper);
//        // System.out.println("总记录数：" + page1.getTotal());
//        // System.out.println("总共多少页：" + page1.getPages());
//        // System.out.println("当前页码：" + page1.getCurrent());
//        // System.out.println("查询数据：" + page1.getRecords());
//    }