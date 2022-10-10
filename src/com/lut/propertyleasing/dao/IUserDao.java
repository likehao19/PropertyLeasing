package com.lut.propertyleasing.dao;

import com.lut.propertyleasing.entity.UserEntity;

import java.util.Map;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/20 20:48
 */
public interface IUserDao {
    //登录
    UserEntity login(String username, String password);
    //注册
    boolean register(UserEntity user);
    //修改密码
    boolean updatePwd(String username, String password);
    //更新用户信息
    boolean updateUserInfo(Map<String, String[]> maps);
    //查询用户信息
    UserEntity findUserById(int userid);
    //修改头像
    boolean uploadImg(String fileName, int userid);
    //管理员注册
    boolean adminRegister(String username, String password);
}
