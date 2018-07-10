package com.example.gradle_boot.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by ding on 2018/4/18.
 */

@Configuration
//@ComponentScan({"com.example.gradle_boot.*"})
//@EnableMongoRepositories(basePackages = "com.example.gradle_boot.entity.mongo.primary",
//        mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {
    protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}

