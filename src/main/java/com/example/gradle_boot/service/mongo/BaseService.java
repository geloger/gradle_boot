package com.example.gradle_boot.service.mongo;

import com.publics.util.page.QueryOrder;
import com.publics.util.page.QueryOrderType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ding on 2018/4/18.
 */
public class BaseService {
    /**
     * 分页和排序
     * @author :dingchao@ucap.com.cn
     * @date: 2018-04-10
     */
    public Pageable getPageable(int page, int size, List<QueryOrder> list){
        List<Sort.Order> orders=new ArrayList<Sort.Order>();
        if(list != null && list.size() > 0){
            for(int i = 0 ; i < list.size() ; i++){
                QueryOrder queryOrder = list.get(i);
                if(QueryOrderType.ASC.equals(queryOrder.getQueryOrderType())){
                    orders.add(new Sort.Order(Sort.Direction.ASC,queryOrder.getName()));
                } else{
                    orders.add(new Sort.Order(Sort.Direction.DESC,queryOrder.getName()));
                }
            }
        }
        return new PageRequest(page-1,size,new Sort(orders));
    }

    /**
     * 封装返回字段
     * @author :dingchao@ucap.com.cn
     * @date: 2018-04-10
     */
    public Query insertFiled(List<String> fileds, Query query){
        if(fileds != null){
            Field fileld = query.fields();
            for(String fil : fileds){
                fileld.include(fil);
            }
        }
        return query;
    }
}
