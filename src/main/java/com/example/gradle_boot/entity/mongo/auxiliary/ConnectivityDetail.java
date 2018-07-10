package com.example.gradle_boot.entity.mongo.auxiliary;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by ding on 2018/4/19.
 */
@Document(collection="connectivityDetail")
public class ConnectivityDetail {
    /**
     * id	_id
     */
    private String _id;
    /**
     * 连通性类型（1首页，2栏目，3业务系统）	type
     */
    private String t;
    /**
     * 网站标识码	siteCode
     */
    private String sc;
    /**
     * 扫描时间，格式：yyyyMMdd	scanDate
     */
    private String sd;
    /**
     * 扫描时间 yyyy-MM-dd hh:mm:ss	firstScanTime
     */
    private Date fst;
    /**
     * 链接地址	url
     */
    private String url;
    /**
     * 链接地址md5	md5
     */
    private String md5;
    /**
     * 栏目/业务系统名称（首页没有名称）	name
     */
    private String nm;
    /**
     * 连通状态（不连通的都算超时）	status
     */
    private int st;
    /**
     * 首页加载时长， 单位毫秒，二次校验时长	loadTime
     */
    private int lt;
    /**
     * 二次校验节点，ip	ip
     */
    private String ip;
    /**
     * 二次校验时间yyyy-MM-dd hh:mm:ss	secondScanTime
     */
    private Date sst;
    /**
     * http第一次返回码	firstHttpCode
     */
    private int fhc;
    /**
     * http第二次返回码	secondHttpCode
     */
    private int shc;
    /**
     * 校验次数
     */
    private int num;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public Date getFst() {
        return fst;
    }

    public void setFst(Date fst) {
        this.fst = fst;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getLt() {
        return lt;
    }

    public void setLt(int lt) {
        this.lt = lt;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getSst() {
        return sst;
    }

    public void setSst(Date sst) {
        this.sst = sst;
    }

    public int getFhc() {
        return fhc;
    }

    public void setFhc(int fhc) {
        this.fhc = fhc;
    }

    public int getShc() {
        return shc;
    }

    public void setShc(int shc) {
        this.shc = shc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
