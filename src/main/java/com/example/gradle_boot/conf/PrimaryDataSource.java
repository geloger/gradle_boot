package com.example.gradle_boot.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by ding on 2018/4/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPri",
        transactionManagerRef="priTransactionManager",
        basePackages= { "com.example.gradle_boot.mapper.primary" }) //设置Repository所在位置 //fixme
public class PrimaryDataSource {

    @Autowired
    @Qualifier("priDataSource")
    private DataSource priDataSource;
    @Primary
    @Bean(name = "entityManagerPri")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPri(builder).getObject().createEntityManager();
    }
    @Primary
    @Bean(name = "entityManagerFactoryPri")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPri (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(priDataSource)
                .properties(getVendorProperties())
                .packages("com.example.gradle_boot.entity.primary") //设置实体类所在位置
                .persistenceUnit("priPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    /**
     * 配置事物管理器
     * @return
     */
    @Bean(name = "priTransactionManager")
    @Primary
    public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPri(builder).getObject());
    }
}
