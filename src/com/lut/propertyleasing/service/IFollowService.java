package com.lut.propertyleasing.service;

import com.lut.propertyleasing.entity.FollowEntity;

import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/27 15:36
 */
public interface IFollowService {
    //关注
    boolean addFollowHorse(int horseid, int userid);
    //查询我的关注
    List<FollowEntity> findAllFollowHorse(int userid,int i);
    //取消关注
    boolean delFollowById(String id);
}
