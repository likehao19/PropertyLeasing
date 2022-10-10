package com.lut.propertyleasing.service;

import com.lut.propertyleasing.entity.HorseEntity;

import java.util.List;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/09/21 16:37
 */
public interface IHorseService {
    //查看房源
    List<HorseEntity> findHorseByCategoryId(int i);

    //查看详情
    HorseEntity findHorseDetailById(int horseid);

    //查看更多
    List<HorseEntity> findAllByCategoryId(int categotyid);

    //查看全部房源
    List<HorseEntity> findAllHorse(int categoryid);

    //按关键字查询
    List<HorseEntity> findHorseByKeyWord(String keyWord);
}
