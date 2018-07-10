package com.example.gradle_boot.service.mongo;


import com.example.gradle_boot.dto.PageUpdateDetailRequest;
import com.example.gradle_boot.entity.mongo.primary.PageUpdateDetail;
import com.publics.util.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ding on 2018/4/18.
 */
@Service
public class PageUpdateDetailService extends BaseService{
    @Autowired
    private MongoTemplate primaryMongoTemplate;


    /**
     * @desc: 分页查询
     * @Author: dingchao@ucap.com.cn
     * @Date: 2018/4/11 9:13
     */
    public List<PageUpdateDetail> findList(PageUpdateDetailRequest detailRequest){
        Query query = new Query();
        Criteria criteria = whereFunction(detailRequest);
        Pageable pageable = getPageable(detailRequest.getPageNo(),detailRequest.getPageSize(),detailRequest.getQueryOrderList());
        return primaryMongoTemplate.find(query.addCriteria(criteria).with(pageable),PageUpdateDetail.class);
    }
    /**
     * @desc: 汇总查询
     * @Author: dingchao@ucap.com.cn
     * @Date: 2018/4/11 9:13
     */
    public List<PageUpdateDetailRequest> groupFunction(PageUpdateDetailRequest detailRequest) {
        Criteria criteria = whereFunction(detailRequest);
        Aggregation aggregation = Aggregation.newAggregation(
                //查询条件
                Aggregation.match(criteria),
                //需要根据分组的字段
                Aggregation.group("siteCode").count().as("updateNum").
                        first("sd").as("scanDate").
                        first("sc").as("siteCode")
                //需要聚合的字段            起别名
//                        .sum("ud8").as("updateNum")

        );
        AggregationResults<PageUpdateDetailRequest> aggRes = primaryMongoTemplate.aggregate(aggregation,
                //需要查询的表名
                "pageUpdateDetail",
                //输出到dtoResponse 这个类不能是映射的mongo实例
                PageUpdateDetailRequest.class);
        List<PageUpdateDetailRequest> listRes = aggRes.getMappedResults();
        for (PageUpdateDetailRequest orgbean : listRes) {
            System.out.println(orgbean.getUpdateNum());
        }
        return listRes;
    }

    /**
     * @desc: 查询条件封装
     * @Author: dingchao@ucap.com.cn
     * @Date: 2018/4/11 9:13
     */
    private Criteria whereFunction(PageUpdateDetailRequest detailRequest) {

        //条件拼接
        Criteria criteria = new Criteria();
        if(detailRequest != null ){
            if(StringUtils.isNotEmpty(detailRequest.getSiteCode())){
                criteria.and("sc").is(detailRequest.getSiteCode());
            }
            if(StringUtils.isNotEmpty(detailRequest.getScanDate())){
                criteria.and("sd").is(detailRequest.getScanDate());
            }
            if(detailRequest.getType() != null){
                criteria.and("t").is(detailRequest.getType());
            }
        }
        return criteria;
    }
}
