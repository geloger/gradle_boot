package com.example.gradle_boot.conf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ding on 2018/4/17.
 */
@Configuration
public class SpringConfigration {
    @Primary
    @Bean(name="priDataSource")
    @Qualifier("priDataSource")
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource dataSourcePri(){
        System.out.println(" Primary mysql datasource 初始化...");
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name="auxDataSource")
    @Qualifier("auxSource")
    @ConfigurationProperties("spring.datasource.auxiliary")
    public DataSource dataSourceAux(){
        System.out.println(" Auxiliary mysql datasource 初始化...");
        return DruidDataSourceBuilder.create().build();
    }

    //mongo 多数据源配置
    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception {
        System.out.println(" mongo primary 初始化...");
        return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
    }


    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception {

        MongoCredential credential = MongoCredential.createScramSha1Credential(mongo.getUsername(), mongo.getDatabase(), mongo.getPassword());
        List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        for(String hosts : mongo.getHost().split(",")) {
            ServerAddress address = new ServerAddress(hosts, mongo.getPort());
            addresses.add(address);
        }
        MongoClient mongoClient = new MongoClient(addresses, Arrays.asList(credential));
        return new SimpleMongoDbFactory(mongoClient,mongo.getDatabase());
    }

    @Bean
    @Qualifier(AuxiliaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate auxiliaryMongoTemplate() throws Exception {
        System.out.println(" mongo secondary 初始化...");
        return new MongoTemplate(auxiliaryFactory(this.mongoProperties.getAuxiliary()));
    }

    @Bean
    public MongoDbFactory auxiliaryFactory(MongoProperties mongo) throws Exception {

        MongoCredential credential = MongoCredential.createScramSha1Credential(mongo.getUsername(), mongo.getDatabase(), mongo.getPassword());
        List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        for(String hosts : mongo.getHost().split(",")) {
            ServerAddress address = new ServerAddress(hosts, mongo.getPort());
            addresses.add(address);
        }
        MongoClient mongoClient = new MongoClient(addresses, Arrays.asList(credential));
        return new SimpleMongoDbFactory(mongoClient,mongo.getDatabase());
    }

}
