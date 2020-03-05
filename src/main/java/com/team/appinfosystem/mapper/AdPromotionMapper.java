package com.team.appinfosystem.mapper;

import com.team.appinfosystem.entity.AdPromotion;
import com.team.appinfosystem.entity.AdPromotionExample;
import java.util.List;

public interface AdPromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);

    List<AdPromotion> selectByExample(AdPromotionExample example);

    AdPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}