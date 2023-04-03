package com.agentp.cepp.utils;

import lombok.Data;
import org.springframework.stereotype.Component;


import java.sql.Timestamp;
@Component
public class JtimeToSqltime {
    /**
     * Sql与Java时间戳映射
     * @return
     */
    public Timestamp JtoSqlTimestamp(){
        long l = System.currentTimeMillis();
        Timestamp date = new Timestamp(l);
        return date;
    }
}
