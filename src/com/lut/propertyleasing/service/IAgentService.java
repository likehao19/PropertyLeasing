package com.lut.propertyleasing.service;

import com.lut.propertyleasing.entity.AgentEntity;

import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/26 21:23
 */
public interface IAgentService {
    //查看所有经纪人
    List<AgentEntity> findAllAgents();

    //申请自由经纪人
    boolean applyAgent(int userid, String phone, String name, String workyears, String certification, String describe, String showphone, String communityid, String sex, String age, String iDcard, String usernaem, String education, String qq_number);

}
