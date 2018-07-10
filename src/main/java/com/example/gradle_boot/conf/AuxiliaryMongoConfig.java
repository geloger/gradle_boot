package com.example.gradle_boot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by ding on 2018/4/18.
 */
@Configuration
//@EnableMongoRepositories(basePackages = "com.example.gradle_boot.entity.mongo.auxiliary",
//        mongoTemplateRef = AuxiliaryMongoConfig.MONGO_TEMPLATE)
public class AuxiliaryMongoConfig {
    protected static final String MONGO_TEMPLATE = "auxiliaryMongoTemplate";
}
