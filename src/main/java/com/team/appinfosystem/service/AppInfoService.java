package com.team.appinfosystem.service;

import com.github.pagehelper.PageInfo;
import com.team.appinfosystem.entity.AppInfo;
import com.team.appinfosystem.util.AppInfoCondition;

public interface AppInfoService {

    PageInfo<AppInfo> getAppInfoByCondition(AppInfoCondition appInfoCondition);

    Integer addAppInfo(AppInfo appInfo);

    AppInfo getAppInfoById(Long id);

    Integer updateAppInfo(AppInfo appInfo);

    Integer deleteAppInfoById(Long id);

    PageInfo<AppInfo> getAppInfoByStatus(AppInfoCondition appInfoCondition);

    Integer updateVersionIdWhenAdd(Long appId, Long versionId);

    Integer updateStatusByAppId(Long appId, Long status);
}
