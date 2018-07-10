package com.example.gradle_boot.utils.page;

import com.publics.util.page.QueryOrder;

import java.io.Serializable;
import java.util.List;

public class Query implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pageSize;
    private Integer pageNo;
    private List<QueryOrder> queryOrderList;
    private static final int DEAFULT_PAGESIZE = 25;
    private static final int DEAFULT_PAGENO = 1;

    public Query() {
    }

    public Integer getPageSize() {
        return Integer.valueOf(this.pageSize == null?25:this.pageSize.intValue());
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return Integer.valueOf(this.pageNo != null && this.pageNo.intValue() != 0?this.pageNo.intValue():1);
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public List<QueryOrder> getQueryOrderList() {
        return this.queryOrderList;
    }

    public void setQueryOrderList(List<QueryOrder> queryOrderList) {
        this.queryOrderList = queryOrderList;
    }
}

