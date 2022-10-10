package com.lut.propertyleasing.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * (THorse)实体类
 *
 * @author makejava
 * @since 2022-09-21 19:04:39
 */
public class HorseEntity implements Serializable {
    private static final long serialVersionUID = -12836165916922179L;
    /**
     * 编号
     */
    private Integer horseid;
    /**
     * 售价
     */
    private String horsename;
    /**
     * 户型
     */
    private String housetype;
    /**
     * 房屋名称
     */
    private Double price;
    /**
     * 面积
     */
    private double area;
    /**
     * 朝向
     */
    private String orientation;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 装修
     */
    private String renovation;
    /**
     * 月租
     */
    private double rent;
    /**
     * 图片
     */
    private String img;
    /**
     * 详情描述
     */
    private String describe;
    /**
     * 房源类型
     */
    private Integer categoryid;
    /**
     * 房源区域
     */
    private Integer communityid;
    /**
     * 房源名称
     */
    private String communityname;

    private int typeid;

    private String typename;

    /*@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8");*/
    private Timestamp createtime;

    public String getCreatetime() {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = myFmt.format(this.createtime);
        return format;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getTypename() {
        return typename;
    }

    @Override
    public String toString() {
        return "HorseEntity{" +
                "horseid=" + horseid +
                ", horsename='" + horsename + '\'' +
                ", housetype='" + housetype + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", orientation='" + orientation + '\'' +
                ", floor='" + floor + '\'' +
                ", renovation='" + renovation + '\'' +
                ", rent=" + rent +
                ", img='" + img + '\'' +
                ", describe='" + describe + '\'' +
                ", categoryid=" + categoryid +
                ", communityid=" + communityid +
                ", communityname='" + communityname + '\'' +
                ", typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Integer getHorseid() {
        return horseid;
    }

    public void setHorseid(Integer horseid) {
        this.horseid = horseid;
    }

    public String getHorsename() {
        return horsename;
    }

    public void setHorsename(String horsename) {
        this.horsename = horsename;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public Double getPrice() {
        return price;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getRenovation() {
        return renovation;
    }

    public void setRenovation(String renovation) {
        this.renovation = renovation;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Integer communityid) {
        this.communityid = communityid;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname;
    }

}

