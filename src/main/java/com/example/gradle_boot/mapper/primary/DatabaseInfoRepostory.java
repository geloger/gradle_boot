package com.example.gradle_boot.mapper.primary;

import com.example.gradle_boot.entity.primary.DatabaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ding on 2018/4/18.
 */
@Repository
public interface DatabaseInfoRepostory extends JpaRepository<DatabaseInfo, Long> {

    @Query(value = "SELECT ci FROM DatabaseInfo ci where ci.siteCode = :sc")
    DatabaseInfo findBySiteCode(@Param("sc")String clientId);
}
