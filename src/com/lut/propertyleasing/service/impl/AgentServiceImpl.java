package com.lut.propertyleasing.service.impl;

import com.lut.propertyleasing.dao.IAgentDao;
import com.lut.propertyleasing.dao.impl.AgentDaoImpl;
import com.lut.propertyleasing.entity.AgentEntity;
import com.lut.propertyleasing.service.IAgentService;

import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/26 21:23
 */
public class AgentServiceImpl implements IAgentService {

    IAgentDao dao = new AgentDaoImpl();

    //查看所有经纪人
    @Override
    public List<AgentEntity> findAllAgents() {
        return dao.findAllAgents();
    }

    //申请自由经纪人
    @Override
    public boolean applyAgent(int userid, String phone, String name, String workyears, String certification, String describe, String showphone, String communityid, String sex, String age, String iDcard, String usernaem, String education, String qq_number) {
        return dao.applyAgent(userid, phone, name, workyears, certification, describe, showphone, communityid, sex
                , age, iDcard, usernaem, education, qq_number);
    }

    //上传图片
    @Override
    public boolean imgUpload(int userid, String aimg) {
        return dao.imgUpload(userid,aimg);
    }

}
