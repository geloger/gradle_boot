package com.example.gradle_boot.service;

import com.example.gradle_boot.entity.primary.DatabaseInfo;
import com.example.gradle_boot.mapper.primary.DatabaseInfoRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ding on 2018/4/18.
 */
@Service
public class DatabaseInfoService {
    @Autowired
    private DatabaseInfoRepostory databaseInfoRepostory;

    public DatabaseInfo findBySiteCode(String siteCode){
        return databaseInfoRepostory.findBySiteCode(siteCode);
    }
}
