package com.example.gradle_boot.entity.mongo.primary;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by ding on 2018/4/9.
 */
@Document(collection="pageUpdateDetail")
public class PageUpdateDetail implements Cloneable{

    /**
     * id	_id
     */
    @Id
    @Column(name = "_id", nullable = false)
    private String id;
    /**
     * 网站标识码	siteCode
     */
    @Field("sc")
    private String siteCode;
    /**
     * 类型（1首页，2栏目）	type
     */
    @Field("t")
    private int type;
    /**
     * 栏目名称	channelName
     */
    @Field("cn")
    private String channelName;
    /**
     * 首页/栏目url	parentUrl
     */
    @Field("pu")
    private String parentUrl;
    /**
     * 栏目父类别ID	dicChanl
     */
    @Field("dc")
    private int dicChanl;
    /**
     * 栏目子类别ID	dicSonChanl
     */
    @Field("dsc")
    private int dicSonChanl;
    /**
     * 快照	imgUrl
     */
    @Field("iu")
    private String imgUrl;
    /**
     * 更新链接标题	title
     */
    @Field("tl")
    private String title;
    /**
     * 更新链接	updateUrl
     */
    @Field("uu")
    private String updateUrl;
    /**
     * 更新时间	yyyy-MM-dd
     */
    @Field("ut")
    private String updateTime;
    /**
     * 更新链接的MD5	md5
     */
    @Field("md5")
    private String md5;
    /**
     * 扫描日期 yyyy-MM-dd	scanDate
     */
    @Field("sd")
    private String scanDate;
    /**
     * 错别字校验状态	correctStatus
     */
    @Field("cs")
    private int correctStatus;
    /**
     * 用来区分业务类型	businessType
     */
    @Field("bt")
    private int businessType;
    /**
     * 最后更新时间	lastUpdated
     */
    @Field("lud")
    private Date lastUpdated;
    /**
     * 最后更新url	lastUpdateUrl
     */
    @Field("luu")
    private String lastUpdateUrl;
    /**
     * 修改时间	modifyTime
     */
    @Field("mt")
    private Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public int getDicChanl() {
        return dicChanl;
    }

    public void setDicChanl(int dicChanl) {
        this.dicChanl = dicChanl;
    }

    public int getDicSonChanl() {
        return dicSonChanl;
    }

    public void setDicSonChanl(int dicSonChanl) {
        this.dicSonChanl = dicSonChanl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getScanDate() {
        return scanDate;
    }

    public void setScanDate(String scanDate) {
        this.scanDate = scanDate;
    }

    public int getCorrectStatus() {
        return correctStatus;
    }

    public void setCorrectStatus(int correctStatus) {
        this.correctStatus = correctStatus;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdateUrl() {
        return lastUpdateUrl;
    }

    public void setLastUpdateUrl(String lastUpdateUrl) {
        this.lastUpdateUrl = lastUpdateUrl;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
