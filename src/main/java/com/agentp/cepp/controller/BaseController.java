package com.agentp.cepp.controller;

import com.agentp.cepp.service.EpidemicInfoService;
import com.agentp.cepp.service.HealthCodeService;
import com.agentp.cepp.service.ResidentInfoService;
import com.agentp.cepp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    ResidentInfoService residentInfoService;
    @Autowired
    HealthCodeService healthCodeService;
    @Autowired
    EpidemicInfoService epidemicInfoService;
}
