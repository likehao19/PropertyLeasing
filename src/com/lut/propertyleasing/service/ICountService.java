package com.lut.propertyleasing.service;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/10/04 20:45
 */
public interface ICountService {
    //统计人次
    int countUsers();

    //更新人次
    void updateCount(Integer count);
}
