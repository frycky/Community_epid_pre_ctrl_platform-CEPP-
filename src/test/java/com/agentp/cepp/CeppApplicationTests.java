package com.agentp.cepp;

import com.agentp.cepp.utils.JtimeToSqltime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CeppApplicationTests {

    @Test
    void contextLoads() {
        JtimeToSqltime jtime = new JtimeToSqltime();
        System.out.println(jtime.JtoSqlTimestamp().toString());
    }

}
