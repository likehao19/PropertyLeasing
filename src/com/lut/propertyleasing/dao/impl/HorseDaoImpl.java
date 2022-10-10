package com.lut.propertyleasing.dao.impl;

import com.lut.propertyleasing.dao.IHorseDao;
import com.lut.propertyleasing.entity.HorseEntity;
import com.lut.propertyleasing.uitls.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/21 16:38
 */
public class HorseDaoImpl extends JdbcUtils implements IHorseDao {
    //查看房源
    @Override
    public List<HorseEntity> findHorseByCategoryId(int i) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_horse h,t_community c where h.communityid=c.communityid and h.categoryid=? limit 4";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, i);
            rs = pst.executeQuery();
            List<HorseEntity> lists = new ArrayList<>();
            HorseEntity horse = null;
            while (rs.next()) {
                horse = new HorseEntity();
                horse.setHorseid(rs.getInt("horseid"));
                horse.setHorsename(rs.getString("horsename"));
                horse.setHousetype(rs.getString("housetype"));
                horse.setPrice(rs.getDouble("price"));
                horse.setArea(rs.getDouble("area"));
                horse.setOrientation(rs.getString("orientation"));
                horse.setFloor(rs.getString("floor"));
                horse.setRenovation(rs.getString("renovation"));
                horse.setCategoryid(rs.getInt("categoryid"));
                horse.setRent(rs.getDouble("rent"));
                horse.setImg(rs.getString("img"));
                horse.setDescribe(rs.getString("describe"));
                horse.setCommunityid(rs.getInt("communityid"));
                horse.setCommunityname(rs.getString("communityname"));
                lists.add(horse);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //查看房源详情
    @Override
    public HorseEntity findHorseDetailById(int horseid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_horse h,t_community c where h.communityid=c.communityid and h.horseid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, horseid);
            rs = pst.executeQuery();
            HorseEntity horse = null;
            while (rs.next()) {
                horse = new HorseEntity();
                horse.setHorseid(rs.getInt("horseid"));
                horse.setHorsename(rs.getString("horsename"));
                horse.setHousetype(rs.getString("housetype"));
                horse.setPrice(rs.getDouble("price"));
                horse.setArea(rs.getDouble("area"));
                horse.setOrientation(rs.getString("orientation"));
                horse.setFloor(rs.getString("floor"));
                horse.setRenovation(rs.getString("renovation"));
                horse.setCategoryid(rs.getInt("categoryid"));
                horse.setRent(rs.getDouble("rent"));
                horse.setImg(rs.getString("img"));
                horse.setDescribe(rs.getString("describe"));
                horse.setCommunityid(rs.getInt("communityid"));
                horse.setCommunityname(rs.getString("communityname"));
                horse.setCreatetime(rs.getTimestamp("createtime"));
            }
            return horse;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst, rs);
        }
        return null;
    }

    //查看更多
    @Override
    public List<HorseEntity> findAllByCategoryId(int categoryid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_horse h,t_community c where h.communityid=c.communityid and h.categoryid=?";
            /*  String sql = "select * from t_horse h,t_category c where h.categoryid=c.categoryid and h.categoryid=?";*/
            pst = conn.prepareStatement(sql);
            pst.setInt(1, categoryid);
            rs = pst.executeQuery();
            List<HorseEntity> lists = new ArrayList<>();
            HorseEntity horse = null;
            while (rs.next()) {
                horse = new HorseEntity();
                horse.setHorseid(rs.getInt("horseid"));
                horse.setHorsename(rs.getString("horsename"));
                horse.setHousetype(rs.getString("housetype"));
                horse.setPrice(rs.getDouble("price"));
                horse.setArea(rs.getDouble("area"));
                horse.setOrientation(rs.getString("orientation"));
                horse.setFloor(rs.getString("floor"));
                horse.setRenovation(rs.getString("renovation"));
                horse.setCategoryid(rs.getInt("categoryid"));
                horse.setRent(rs.getDouble("rent"));
                horse.setImg(rs.getString("img"));
                horse.setDescribe(rs.getString("describe"));
                horse.setCommunityid(rs.getInt("communityid"));
                horse.setCommunityname(rs.getString("communityname"));
                lists.add(horse);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst, rs);
        }
        return null;
    }

    @Override
    public List<HorseEntity> findAllHorse(int categoryid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            /* String sql = "select * from t_horse h,t_community c where h.communityid=c.communityid ";*/
            String sql = "select * from t_horse a right join t_community b on a.communityid=b.communityid inner join t_horsetype c on c.typeid=a.typeid where a.categoryid=?";
            /*  String sql = "select * from t_horse h,t_category c where h.categoryid=c.categoryid and h.categoryid=?";*/
            pst = conn.prepareStatement(sql);
            pst.setInt(1, categoryid);
            rs = pst.executeQuery();
            List<HorseEntity> lists = new ArrayList<>();
            HorseEntity horse = null;
            while (rs.next()) {
                horse = new HorseEntity();
                horse.setHorseid(rs.getInt("horseid"));
                horse.setHorsename(rs.getString("horsename"));
                horse.setHousetype(rs.getString("housetype"));
                horse.setPrice(rs.getDouble("price"));
                horse.setArea(rs.getDouble("area"));
                horse.setOrientation(rs.getString("orientation"));
                horse.setFloor(rs.getString("floor"));
                horse.setRenovation(rs.getString("renovation"));
                horse.setCategoryid(rs.getInt("categoryid"));
                horse.setRent(rs.getDouble("rent"));
                horse.setImg(rs.getString("img"));
                horse.setDescribe(rs.getString("describe"));
                horse.setCommunityid(rs.getInt("communityid"));
                horse.setCommunityname(rs.getString("communityname"));
                horse.setTypeid(rs.getInt("typeid"));
                horse.setTypename(rs.getString("typename"));
                horse.setCreatetime(rs.getTimestamp("createtime"));
                lists.add(horse);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst, rs);
        }
        return null;
    }

    //按关键字查询
    @Override
    public List<HorseEntity> findHorseByKeyWord(String keyWord) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_horse a right join t_community b on a.communityid=b.communityid inner join t_horsetype c on c.typeid=a.typeid where communityname like '%" + keyWord + "%' or communityname like '" + keyWord + "%' or communityname like '%" + keyWord + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            List<HorseEntity> lists = new ArrayList<>();
            HorseEntity horse = null;
            while (rs.next()) {
                horse = new HorseEntity();
                horse.setHorseid(rs.getInt("horseid"));
                horse.setHorsename(rs.getString("horsename"));
                horse.setHousetype(rs.getString("housetype"));
                horse.setPrice(rs.getDouble("price"));
                horse.setArea(rs.getDouble("area"));
                horse.setOrientation(rs.getString("orientation"));
                horse.setFloor(rs.getString("floor"));
                horse.setRenovation(rs.getString("renovation"));
                horse.setCategoryid(rs.getInt("categoryid"));
                horse.setRent(rs.getDouble("rent"));
                horse.setImg(rs.getString("img"));
                horse.setDescribe(rs.getString("describe"));
                horse.setCommunityid(rs.getInt("communityid"));
                horse.setCommunityname(rs.getString("communityname"));
                horse.setTypeid(rs.getInt("typeid"));
                horse.setTypename(rs.getString("typename"));
                horse.setCreatetime(rs.getTimestamp("createtime"));
                lists.add(horse);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst, rs);
        }
        return null;
    }
}
