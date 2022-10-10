package com.lut.propertyleasing.entity;

import java.io.Serializable;

/**
 * (TAgent)实体类
 *
 * @author makejava
 * @since 2022-09-26 21:40:46
 */
public class AgentEntity implements Serializable {
    private static final long serialVersionUID = -36933939386063648L;
    /**
     * 经纪人认证id
     */
    private int id;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 工作年限
     */
    private Integer workyears;
    /**
     * 资格认证
     */
    private String certification;
    /**
     * 个人描述
     */
    private String describe;
    /**
     * 电话显示 1-显示 2不显示
     */
    private Integer showphone;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 服务区
     */
    private String servicearea;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 身份证
     */
    private String idcard;
    /**
     * 姓名
     */
    private String username;
    /**
     * 学历
     */
    private String education;
    /**
     * qq
     */
    private Integer qqNumber;
    /**
     * 类型
     */
    private Integer categoryid;
    /**
     * 头像
     */
    private String aimg;
    /**
     * 工作单位
     */
    private String workunit;
    /**
     * 昵称
     */
    private String name;
    /**
     * phone
     */
    private String phone;

    private int communityid;

    public int getCommunityid() {
        return communityid;
    }

    public void setCommunityid(int communityid) {
        this.communityid = communityid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String communityname;

    private String categoryname;

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getWorkyears() {
        return workyears;
    }

    public void setWorkyears(Integer workyears) {
        this.workyears = workyears;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getShowphone() {
        return showphone;
    }

    public void setShowphone(Integer showphone) {
        this.showphone = showphone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getServicearea() {
        return servicearea;
    }

    public void setServicearea(String servicearea) {
        this.servicearea = servicearea;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(Integer qqNumber) {
        this.qqNumber = qqNumber;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getAimg() {
        return aimg;
    }

    public void setAimg(String aimg) {
        this.aimg = aimg;
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AgentEntity{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", workyears=" + workyears +
                ", certification='" + certification + '\'' +
                ", describe='" + describe + '\'' +
                ", showphone=" + showphone +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", age=" + age +
                ", servicearea='" + servicearea + '\'' +
                ", sex=" + sex +
                ", idcard='" + idcard + '\'' +
                ", username='" + username + '\'' +
                ", education='" + education + '\'' +
                ", qqNumber=" + qqNumber +
                ", categoryid=" + categoryid +
                ", aimg='" + aimg + '\'' +
                ", workunit='" + workunit + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", communityname='" + communityname + '\'' +
                ", categoryname='" + categoryname + '\'' +
                '}';
    }
}

