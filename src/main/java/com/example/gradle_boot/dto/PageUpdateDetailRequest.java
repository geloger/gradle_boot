package com.example.gradle_boot.dto;

import com.example.gradle_boot.utils.page.Query;

import java.util.List;

/**
 * Created by ding on 2018/4/18.
 */
public class PageUpdateDetailRequest extends Query {

    private String siteCode;
    private String scanDate;
    private Integer type;
    private Integer updateNum;
    private List<String> codeList;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getScanDate() {
        return scanDate;
    }

    public void setScanDate(String scanDate) {
        this.scanDate = scanDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(Integer updateNum) {
        this.updateNum = updateNum;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }
}
