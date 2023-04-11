package com.agentp.cepp.controller;


import com.agentp.cepp.entity.UserInfo;
import com.agentp.cepp.mapper.EpidemicInfoMapper;
import com.agentp.cepp.mapper.HealthCodeMapper;
import com.agentp.cepp.mapper.ResidentInfoMapper;
import com.agentp.cepp.mapper.UserInfoMapper;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@RestController
public class SaveDataToMysql {


}
