package com.lut.propertyleasing.dao.impl;

import com.lut.propertyleasing.dao.IUserDao;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.uitls.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/20 20:48
 */
public class UserDaoImpl extends JdbcUtils implements IUserDao {
    //登录
    @Override
    public UserEntity login(String username, String password) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_user where username=? and password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            UserEntity user = null;
            while (rs.next()) {
                user = new UserEntity();
                user.setUserId(rs.getInt("userid"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setSex(rs.getInt("sex"));
                user.setAge(rs.getInt("age"));
                user.setPhone(rs.getString("phone"));
                user.setQq_number(rs.getString("qq_number"));
                user.setSignature(rs.getString("signature"));
                user.setUimg(rs.getString("uimg"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst, rs);
        }
        return null;
    }

    //注册
    @Override
    public boolean register(UserEntity user) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "insert into t_user(username,password) values(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            int res = pst.executeUpdate();
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
        return false;
    }

    //修改密码
    @Override
    public boolean updatePwd(String username, String password) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "update t_user set password=? where username=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, password);
            pst.setString(2, username);
            int res = pst.executeUpdate();
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
        return false;
    }

    //更新用户信息
    @Override
    public boolean updateUserInfo(Map<String, String[]> maps) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "update t_user set name=?,phone=?,sex=?,age=?,qq_number=?,signature=? where userid=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, maps.get("name")[0]);
            pst.setString(2, maps.get("phone")[0]);
            pst.setInt(3, Integer.parseInt(maps.get("sex")[0]));
            pst.setInt(4, Integer.parseInt(maps.get("age")[0]));
            pst.setString(5, maps.get("qq_number")[0]);
            pst.setString(6, maps.get("signature")[0]);
            pst.setInt(7, Integer.parseInt(maps.get("userid")[0]));
            int res = pst.executeUpdate();
            System.out.println("res=" + res);
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
        return false;
    }

    //查询用户信息
    @Override
    public UserEntity findUserById(int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_user where userid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, userid);
            rs = pst.executeQuery();
            UserEntity user = new UserEntity();
            while (rs.next()) {
                user.setUserId(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setSex(rs.getInt("sex"));
                user.setAge(rs.getInt("age"));
                user.setQq_number(rs.getString("qq_number"));
                user.setSignature(rs.getString("signature"));
                user.setUimg(rs.getString("uimg"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst, rs);
        }
        return null;
    }

    //修改头像
    @Override
    public boolean uploadImg(String fileName, int userid) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "update t_user set uimg=? where userid=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, fileName);
            pst.setInt(2, userid);
            int res = pst.executeUpdate();
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //管理员注册
    @Override
    public boolean adminRegister(String username, String password) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "insert into t_user(username,password,role) values(?,?,2)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            int res = pst.executeUpdate();
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
        return false;
    }
}
