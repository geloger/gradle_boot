package com.example.gradle_boot.service.mongo;

import com.example.gradle_boot.dto.PageUpdateDetailRequest;
import com.example.gradle_boot.entity.mongo.auxiliary.ConnectivityDetail;
import com.example.gradle_boot.entity.mongo.primary.PageUpdateDetail;
import com.publics.util.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ding on 2018/4/19.
 */
@Service
public class ConnectivityDetailService extends BaseService{
    @Autowired
    @Qualifier("auxiliaryMongoTemplate")
    private MongoTemplate auxiliaryMongoTemplate;

    public List<ConnectivityDetail> findList(String siteCode){
        Query query = new Query();
        Criteria criteria = whereFunction(siteCode);
//        Pageable pageable = getPageable(detailRequest.getPageNo(),detailRequest.getPageSize(),detailRequest.getQueryOrderList());
        return auxiliaryMongoTemplate.find(query.addCriteria(criteria),ConnectivityDetail.class);
    }

    private Criteria whereFunction(String siteCode) {

        //条件拼接
        Criteria criteria = new Criteria();
        criteria.and("sc").is(siteCode);
        return criteria;
    }
}
