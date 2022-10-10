package com.lut.propertyleasing.service.impl;

import com.lut.propertyleasing.dao.IUserDao;
import com.lut.propertyleasing.dao.impl.UserDaoImpl;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IUserService;

import java.util.Map;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/20 20:47
 */
public class UserServiceImpl implements IUserService {
    IUserDao dao = new UserDaoImpl();

    //登录
    @Override
    public UserEntity login(String username, String password) {
        return dao.login(username, password);
    }

    //注册
    @Override
    public boolean register(UserEntity user) {
        return dao.register(user);
    }

    //修改密码
    @Override
    public boolean updatePwd(String username, String password) {
        return dao.updatePwd(username, password);
    }

    //更新用户信息
    @Override
    public boolean updateUserInfo(Map<String, String[]> maps) {
        return dao.updateUserInfo(maps);
    }

    //查询用户信息
    @Override
    public UserEntity findUserById(int userid) {
        return dao.findUserById(userid);
    }

    //修改头像
    @Override
    public boolean uploadImg(String fileName, int userid) {
        return dao.uploadImg(fileName, userid);
    }

    //管理员注册
    @Override
    public boolean adminRegister(String username, String password) {
        return dao.adminRegister(username, password);
    }
}
