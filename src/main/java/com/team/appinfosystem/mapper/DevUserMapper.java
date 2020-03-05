package com.team.appinfosystem.mapper;

import com.team.appinfosystem.entity.DevUser;
import com.team.appinfosystem.entity.DevUserExample;
import java.util.List;

public interface DevUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    List<DevUser> selectByExample(DevUserExample example);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}