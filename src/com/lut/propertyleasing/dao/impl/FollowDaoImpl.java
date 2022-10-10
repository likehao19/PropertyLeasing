package com.lut.propertyleasing.dao.impl;

import com.lut.propertyleasing.dao.IFollowDao;
import com.lut.propertyleasing.entity.FollowEntity;
import com.lut.propertyleasing.uitls.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/27 15:43
 */
public class FollowDaoImpl extends JdbcUtils implements IFollowDao {
   /* @Override
    public int findFollow(int horseid, int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_follow where horseid=? and userid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, horseid);
            pst.setInt(2, userid);
            rs = pst.executeQuery();
            return rs.next() == true ? rs.getInt(1) : 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
        return 0;
    }*/

    @Override
    public String findFollow(int horseid, int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select id from t_follow where horseid=? and userid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, horseid);
            pst.setInt(2, userid);
            rs = pst.executeQuery();
            String id = null;
            while (rs.next()) {
                id = rs.getString("id");
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
        return null;
    }

    //添加关注
    @Override
    public boolean addFollowHorse(int horseid, int userid) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "insert into t_follow value(null,?,?,now())";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, horseid);
            pst.setInt(2, userid);
            int res = pst.executeUpdate();
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
        return false;
    }

    //查询我的关注
    @Override
    public List<FollowEntity> findAllFollowHorse(int userid, int i) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_follow a right join t_user b on a.userid=b.userid inner join t_horse c on a.horseid=c.horseid where a.userid=? and c.categoryid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, userid);
            pst.setInt(2, i);
            rs = pst.executeQuery();
            List<FollowEntity> lists = new ArrayList<>();
            FollowEntity follow = null;
            while (rs.next()) {
                follow = new FollowEntity();
                follow.setId(rs.getInt("id"));
                follow.setUserid(rs.getInt("userid"));
                follow.setHorseid(rs.getInt("horseid"));
                follow.setHorsename(rs.getString("horsename"));
                follow.setUsername(rs.getString("username"));
                follow.setHousetype(rs.getString("housetype"));
                follow.setArea(rs.getString("area"));
                follow.setRent(rs.getString("rent"));
                follow.setPrice(rs.getDouble("price"));
                follow.setImg(rs.getString("img"));
                follow.setOrientation(rs.getString("orientation"));
                follow.setTime(rs.getTimestamp("time"));
                lists.add(follow);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //取消关注
    @Override
    public boolean delFollowById(String id) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "delete from t_follow where id=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            int res = pst.executeUpdate();
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return false;
    }
}
