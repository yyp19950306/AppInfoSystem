package com.team.appinfosystem.mapper;

import com.team.appinfosystem.entity.AppVersion;
import com.team.appinfosystem.entity.AppVersionExample;
import java.util.List;

public interface AppVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    List<AppVersion> selectByExample(AppVersionExample example);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    int deleteAppVersionByAppId(Long appId);

    List<AppVersion> getAppVersionByAppId(Long appId);

    AppVersion getLastVersionByAppId(Long appId);
}