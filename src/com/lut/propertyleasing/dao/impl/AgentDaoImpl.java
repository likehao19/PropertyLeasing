package com.lut.propertyleasing.dao.impl;

import com.lut.propertyleasing.dao.IAgentDao;
import com.lut.propertyleasing.entity.AgentEntity;
import com.lut.propertyleasing.uitls.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/26 21:24
 */
public class AgentDaoImpl extends JdbcUtils implements IAgentDao {
    //查看所有经纪人
    @Override
    public List<AgentEntity> findAllAgents() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "select * from t_agent a,t_community c where a.communityid=c.communityid";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            AgentEntity agent = null;
            List<AgentEntity> agents = new ArrayList<>();
            while (rs.next()) {
                agent = new AgentEntity();
                agent.setId(rs.getInt("id"));
                agent.setWorkunit(rs.getString("workunit"));
                agent.setName(rs.getString("name"));
                agent.setCity(rs.getString("city"));
                agent.setPhone(rs.getString("phone"));
                agent.setCommunityname(rs.getString("communityname"));
                agent.setCategoryname(rs.getString("categoryname"));
                agent.setAimg(rs.getString("aimg"));
                agents.add(agent);
            }
            return agents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //申请自由经纪人
    @Override
    public boolean applyAgent(int userid, String phone, String name, String workyears, String certification, String describe, String showphone, String communityid, String sex, String age, String iDcard, String username, String education, String qq_number) {
        PreparedStatement pst = null;
        try {
            openConnection();
            String sql = "insert into t_agent(id,userid,phone,name,workyears,certification,describe1,showphone,communityid,sex,age,IDcard,username,education,qq_number) values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, userid);
            pst.setString(2, phone);
            pst.setString(3, name);
            pst.setInt(4, Integer.parseInt(workyears));
            pst.setString(5, certification);
            pst.setString(6, describe);
            pst.setInt(7, Integer.parseInt(showphone));
            pst.setInt(8, Integer.parseInt(communityid));
            pst.setInt(9, Integer.parseInt(sex));
            pst.setInt(10, Integer.parseInt(age));
            pst.setString(11, iDcard);
            pst.setString(12, username);
            pst.setString(13, education);
            pst.setInt(14, Integer.parseInt(qq_number));
            int res = pst.executeUpdate();
            return res > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //上传图片
    @Override
    public boolean imgUpload(int userid, String aimg) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "insert into t_agent where aimg=? userid=userid";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            AgentEntity agent = null;
            List<AgentEntity> agents = new ArrayList<>();
            while (rs.next()) {
                agent = new AgentEntity();
                agent.setId(rs.getInt("id"));
                agent.setWorkunit(rs.getString("workunit"));
                agent.setName(rs.getString("name"));
                agent.setCity(rs.getString("city"));
                agent.setPhone(rs.getString("phone"));
                agent.setCommunityname(rs.getString("communityname"));
                agent.setCategoryname(rs.getString("categoryname"));
                agent.setAimg(rs.getString("aimg"));
                agents.add(agent);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
