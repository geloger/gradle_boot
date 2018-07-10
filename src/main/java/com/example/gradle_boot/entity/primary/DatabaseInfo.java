package com.example.gradle_boot.entity.primary;

import javax.persistence.*;

/**
 * Created by ding on 2018/4/18.
 */
@Entity
@Table(name = "database_info")
public class DatabaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    // 网站标识码
    @Column(name = "site_code")
    private String siteCode;

    // 网站名称
    @Column(name = "name")
    private String name;

    // 网站校验码
    @Column(name = "vcode")
    private String vcode;

    // 省
    @Column(name = "province")
    private String province;

    // 市
    @Column(name = "city")
    private String city;

    // 县
    @Column(name = "county")
    private String county;

    // 级别，1省份，2市，3县
    @Column(name = "level")
    private String level;

    //0非门户，1门户
    @Column(name = "isorganizational")
    private Integer isorganizational;

    //url地址
    @Column(name = "url")
    private String url;

    //跳转url
    @Column(name = "jump_url")
    private String jumpUrl;

    //md5加密url(先jump_url后url)
    @Column(name = "encode_url")
    private String encodeUrl;

    //网站主办单位
    @Column(name = "director")
    private String director;

    //1正常，2例外，3关停
    @Column(name = "isexp")
    private Integer isexp;

    //办公地址
    @Column(name = "address")
    private String address;

    //联系人
    @Column(name = "linkman_name")
    private String linkmanName;

    //负责人
    @Column(name = "principal_name")
    private String principalName;

    //负责人职务
    @Column(name = "principal_post")
    private String principalPost;

    //负责人办公电话
    @Column(name = "mobile")
    private String mobile;

    //联系人办公电话
    @Column(name = "mobile_2")
    private String mobile2;

    //负责人手机
    @Column(name = "telephone")
    private String telephone;

    //联系人手机
    @Column(name = "telephone_2")
    private String telephone2;

    //登录验证邮箱--负责人
    @Column(name = "email")
    private String email;

    //邮箱--联系人
    @Column(name = "email_2")
    private String email2;

    //是否收费（0免费，1收费）
    @Column(name = "iscost")
    private Integer iscost;

    //是否扫描（0：否，1：是）
    @Column(name = "is_scan")
    private Integer isScan;

    //联系人姓名2
    @Column(name = "linkman_name_two")
    private String  linkmanNameTwo;

    //联系人手机2
    @Column(name = "linkman_phone_two")
    private String linkmanPhoneTwo;

    //联系人邮箱2
    @Column(name = "linkman_email_two")
    private String linkmanEmailTwo;

    //联系人姓名3
    @Column(name = "linkman_name_three")
    private String  linkmanNameThree;

    //联系人手机3
    @Column(name = "linkman_phone_three")
    private String linkmanPhoneThree;

    //联系人邮箱3
    @Column(name = "linkman_email_three")
    private String linkmanEmailThree;

    //联系人邮箱3
    @Column(name = "queue")
    private Integer queue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getIsorganizational() {
        return isorganizational;
    }

    public void setIsorganizational(Integer isorganizational) {
        this.isorganizational = isorganizational;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getEncodeUrl() {
        return encodeUrl;
    }

    public void setEncodeUrl(String encodeUrl) {
        this.encodeUrl = encodeUrl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getIsexp() {
        return isexp;
    }

    public void setIsexp(Integer isexp) {
        this.isexp = isexp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalPost() {
        return principalPost;
    }

    public void setPrincipalPost(String principalPost) {
        this.principalPost = principalPost;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public Integer getIscost() {
        return iscost;
    }

    public void setIscost(Integer iscost) {
        this.iscost = iscost;
    }

    public Integer getIsScan() {
        return isScan;
    }

    public void setIsScan(Integer isScan) {
        this.isScan = isScan;
    }

    public String getLinkmanNameTwo() {
        return linkmanNameTwo;
    }

    public void setLinkmanNameTwo(String linkmanNameTwo) {
        this.linkmanNameTwo = linkmanNameTwo;
    }

    public String getLinkmanPhoneTwo() {
        return linkmanPhoneTwo;
    }

    public void setLinkmanPhoneTwo(String linkmanPhoneTwo) {
        this.linkmanPhoneTwo = linkmanPhoneTwo;
    }

    public String getLinkmanEmailTwo() {
        return linkmanEmailTwo;
    }

    public void setLinkmanEmailTwo(String linkmanEmailTwo) {
        this.linkmanEmailTwo = linkmanEmailTwo;
    }

    public String getLinkmanNameThree() {
        return linkmanNameThree;
    }

    public void setLinkmanNameThree(String linkmanNameThree) {
        this.linkmanNameThree = linkmanNameThree;
    }

    public String getLinkmanPhoneThree() {
        return linkmanPhoneThree;
    }

    public void setLinkmanPhoneThree(String linkmanPhoneThree) {
        this.linkmanPhoneThree = linkmanPhoneThree;
    }

    public String getLinkmanEmailThree() {
        return linkmanEmailThree;
    }

    public void setLinkmanEmailThree(String linkmanEmailThree) {
        this.linkmanEmailThree = linkmanEmailThree;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }
}
