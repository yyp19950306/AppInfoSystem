package com.team.appinfosystem.mapper;

import com.github.pagehelper.PageInfo;
import com.team.appinfosystem.entity.AppInfo;
import com.team.appinfosystem.entity.AppInfoExample;
import com.team.appinfosystem.util.AppInfoCondition;

import java.util.List;
import java.util.Map;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    List<AppInfo> selectByCondition(AppInfoCondition appInfoCondition);

    AppInfo getAppInfoById(Long id);

    List<AppInfo> getAppInfoByStatus(AppInfoCondition appInfoCondition);

}