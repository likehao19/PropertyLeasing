package com.lut.propertyleasing.dao.impl;

import com.lut.propertyleasing.dao.ICountDao;
import com.lut.propertyleasing.uitls.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/10/04 20:46
 */
public class CountDaoImpl extends JdbcUtils implements ICountDao {
    @Override
    public int countUsers() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_count";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst, rs);
        }
        return 0;
    }

    //更新人次
    @Override
    public void updateCount(Integer count) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "update t_count set count=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, count);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(pst);
        }
    }
}
