package com.lut.propertyleasing.entity;

import java.sql.Timestamp;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/27 19:22
 */
public class FollowEntity {
    private int id;
    private int userid;
    private int horseid;
    private String username;
    private String horsename;
    private Timestamp time;
    private String communityname;
    private String housetype;
    private String area;
    private String orientation;
    private String img;
    private double price;
    private String rent;

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getHorseid() {
        return horseid;
    }

    public void setHorseid(int horseid) {
        this.horseid = horseid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHorsename() {
        return horsename;
    }

    public void setHorsename(String horsename) {
        this.horsename = horsename;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FollowEntity{" +
                "id=" + id +
                ", userid=" + userid +
                ", horseid=" + horseid +
                ", username='" + username + '\'' +
                ", horsename='" + horsename + '\'' +
                ", time=" + time +
                ", communityname='" + communityname + '\'' +
                ", housetype='" + housetype + '\'' +
                ", area='" + area + '\'' +
                ", orientation='" + orientation + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", rent='" + rent + '\'' +
                '}';
    }
}
