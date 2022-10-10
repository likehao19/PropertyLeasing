package com.lut.propertyleasing.service.impl;

import com.lut.propertyleasing.dao.ICountDao;
import com.lut.propertyleasing.dao.impl.CountDaoImpl;
import com.lut.propertyleasing.service.ICountService;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/10/04 20:46
 */
public class CountServiceImpl implements ICountService {
    ICountDao dao = new CountDaoImpl();

    //统计人次
    @Override
    public int countUsers() {
        return dao.countUsers();
    }

    //更新人次
    @Override
    public void updateCount(Integer count) {
        dao.updateCount(count);
    }
}
