package com.team.appinfosystem.mapper;

import com.team.appinfosystem.entity.BackendUser;
import com.team.appinfosystem.entity.BackendUserExample;
import java.util.List;

public interface BackendUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    List<BackendUser> selectByExample(BackendUserExample example);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
}