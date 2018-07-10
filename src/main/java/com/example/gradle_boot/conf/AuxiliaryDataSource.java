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
 * Created by ding on 2018/4/18.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryAux",
        transactionManagerRef="auxTransactionManager",
        basePackages= { "com.example.gradle_boot.mapper.auxiliary" })
public class AuxiliaryDataSource {
    @Autowired
    @Qualifier("auxDataSource")
    private DataSource auxDataSource;

    @Bean(name = "entityManagerAux")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryAux(builder).getObject().createEntityManager();
    }

    /**
     * 我们通过LocalContainerEntityManagerFactoryBean来获取EntityManagerFactory实例
     * @return
     */
    @Bean(name = "entityManagerFactoryAux")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryAux(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(auxDataSource)
                .properties(getVendorProperties())
                .packages("com.example.gradle_boot.entity.auxiliary") //设置实体类所在位置
                .persistenceUnit("auxPersistenceUnit")
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
    @Bean(name = "auxTransactionManager")
    @Primary
    public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryAux(builder).getObject());
    }
}
