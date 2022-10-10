package com.lut.propertyleasing.dao;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/10/04 20:46
 */
public interface ICountDao {
    //统计人次
    int countUsers();
    //更新人次
    void updateCount(Integer count);
}
