package com.lut.propertyleasing.dao;

import com.lut.propertyleasing.entity.FollowEntity;

import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/27 15:42
 */
public interface IFollowDao {
    //查询关注是否添加
    /*int findFollow(int horseid, int userid);*/
    String findFollow(int horseid, int userid);

    //关注
    boolean addFollowHorse(int horseid, int userid);

    //查询我的关注
    List<FollowEntity> findAllFollowHorse(int userid,int i);

    //取消关注
    boolean delFollowById(String id);
}
