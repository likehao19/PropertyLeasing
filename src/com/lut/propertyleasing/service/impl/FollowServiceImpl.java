package com.lut.propertyleasing.service.impl;

import com.lut.propertyleasing.dao.IFollowDao;
import com.lut.propertyleasing.dao.impl.FollowDaoImpl;
import com.lut.propertyleasing.entity.FollowEntity;
import com.lut.propertyleasing.service.IFollowService;

import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/27 15:42
 */
public class FollowServiceImpl implements IFollowService {
    IFollowDao dao = new FollowDaoImpl();

    //关注
    @Override
    public boolean addFollowHorse(int horseid, int userid) {
        /* int id = dao.findFollow(horseid, userid);*/
        String id = dao.findFollow(horseid, userid);
        if (id != null) {
            return false;
        } else {
            return dao.addFollowHorse(horseid, userid);
        }
    }

    //查询我的关注
    @Override
    public List<FollowEntity> findAllFollowHorse(int userid, int i) {
        return dao.findAllFollowHorse(userid, i);
    }

    //取消关注
    @Override
    public boolean delFollowById(String id) {
        return dao.delFollowById(id);
    }
}
