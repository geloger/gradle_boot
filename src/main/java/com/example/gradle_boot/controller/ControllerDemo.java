package com.example.gradle_boot.controller;

import com.alibaba.fastjson.JSON;
import com.example.gradle_boot.dto.PageUpdateDetailRequest;
import com.example.gradle_boot.entity.mongo.auxiliary.ConnectivityDetail;
import com.example.gradle_boot.entity.mongo.primary.PageUpdateDetail;
import com.example.gradle_boot.entity.primary.DatabaseInfo;
import com.example.gradle_boot.service.DatabaseInfoService;
import com.example.gradle_boot.service.mongo.ConnectivityDetailService;
import com.example.gradle_boot.service.mongo.PageUpdateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ding on 2018/4/18.
 */
@RestController
@RequestMapping("/cont")
public class ControllerDemo {
    @Autowired
    private DatabaseInfoService databaseInfoService;
    @Autowired
    private PageUpdateDetailService pageUpdateDetailService;
    @Autowired
    private ConnectivityDetailService connectivityDetailService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/demo/a")
    public String demoCont(){
        DatabaseInfo info = databaseInfoService.findBySiteCode("4400000001");
        return JSON.toJSON(info).toString();
    }

    @RequestMapping("/demo/m")
    public String demoMongo(){
        PageUpdateDetailRequest detailRequest = new PageUpdateDetailRequest();
        detailRequest.setSiteCode("3605210001");
        List<PageUpdateDetail> details = pageUpdateDetailService.findList(detailRequest);
        return JSON.toJSON(details).toString();
    }

    @RequestMapping("/demo/c")
    public String demoMongoC(){
        List<ConnectivityDetail> details = connectivityDetailService.findList("4101030005");
        return JSON.toJSON(details).toString();
    }

    @RequestMapping("/demo/R")
    public String demoMongoR(){
//        redisTemplate.
//        return JSON.toJSON(details).toString();
        return null;
    }

}
