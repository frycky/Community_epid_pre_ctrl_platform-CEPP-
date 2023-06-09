package com.agentp.cepp.controller;

import com.agentp.cepp.mapper.WordInfoMapper;
import com.agentp.cepp.service.*;
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
    @Autowired
    WordInfoService wordInfoService;
    @Autowired
    CategoryInfoService categoryInfoService;

    @Autowired
    UserTypeService userTypeService;

    @Autowired
    MenuListService menuListService;
    @Autowired
    TypeMenuService typeMenuService;

    @Autowired
    WordInfoMapper wordInfoMapper;

}
