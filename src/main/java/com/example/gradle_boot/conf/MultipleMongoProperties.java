package com.example.gradle_boot.conf;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ding on 2018/4/18.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongo")
public class MultipleMongoProperties {
    private MongoProperties primary = new MongoProperties();
    private MongoProperties auxiliary = new MongoProperties();

    public MongoProperties getPrimary() {
        return primary;
    }

    public void setPrimary(MongoProperties primary) {
        this.primary = primary;
    }

    public MongoProperties getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(MongoProperties auxiliary) {
        this.auxiliary = auxiliary;
    }
}
