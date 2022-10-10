package com.lut.propertyleasing.service.impl;

import com.lut.propertyleasing.dao.IHorseDao;
import com.lut.propertyleasing.dao.impl.HorseDaoImpl;
import com.lut.propertyleasing.entity.HorseEntity;
import com.lut.propertyleasing.service.IHorseService;

import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/21 16:37
 */
public class HorseServiceImpl implements IHorseService {
    IHorseDao dao = new HorseDaoImpl();

    //查看房源
    @Override
    public List<HorseEntity> findHorseByCategoryId(int i) {
        return dao.findHorseByCategoryId(i);
    }

    //查看详情
    @Override
    public HorseEntity findHorseDetailById(int horseid) {
        return dao.findHorseDetailById(horseid);
    }

    //查看更多
    @Override
    public List<HorseEntity> findAllByCategoryId(int categoryid) {
        return dao.findAllByCategoryId(categoryid);
    }

    @Override
    public List<HorseEntity> findAllHorse(int categoryid) {
        return dao.findAllHorse(categoryid);
    }

    //按关键字查询
    @Override
    public List<HorseEntity> findHorseByKeyWord(String keyWord) {
        return dao.findHorseByKeyWord(keyWord);
    }
}
