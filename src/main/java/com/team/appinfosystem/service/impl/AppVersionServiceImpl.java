package com.team.appinfosystem.service.impl;

import com.team.appinfosystem.entity.AppVersion;
import com.team.appinfosystem.mapper.AppInfoMapper;
import com.team.appinfosystem.mapper.AppVersionMapper;
import com.team.appinfosystem.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    AppVersionMapper appVersionMapper;

    @Override
    public List<AppVersion> getAppVersionByAppId(Long appId) {
        return appVersionMapper.getAppVersionByAppId(appId);
    }

    @Override
    public Integer addAppVersion(AppVersion appVersion) {
        return appVersionMapper.insertSelective(appVersion);
    }

    @Override
    public AppVersion getLastVersionByAppId(Long appId) {
        return appVersionMapper.getLastVersionByAppId(appId);
    }
}
