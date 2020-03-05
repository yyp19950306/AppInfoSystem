package com.team.appinfosystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.appinfosystem.entity.AppInfo;
import com.team.appinfosystem.mapper.AppInfoMapper;
import com.team.appinfosystem.mapper.AppVersionMapper;
import com.team.appinfosystem.service.AppInfoService;
import com.team.appinfosystem.util.AppInfoCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public PageInfo<AppInfo> getAppInfoByCondition(AppInfoCondition appInfoCondition) {
        PageHelper.startPage(appInfoCondition.getPageNum(), appInfoCondition.getPageSize());
        List<AppInfo> list = appInfoMapper.selectByCondition(appInfoCondition);
        return new PageInfo<>(list);
    }

    @Override
    public Integer addAppInfo(AppInfo appInfo) {
        return appInfoMapper.insertSelective(appInfo);
    }

    @Override
    public AppInfo getAppInfoById(Long id) {
        return appInfoMapper.getAppInfoById(id);
    }

    @Override
    public Integer updateAppInfo(AppInfo appInfo) {
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }

    @Override
    @Transactional
    public Integer deleteAppInfoById(Long id) {
        appVersionMapper.deleteAppVersionByAppId(id);
        Integer temp = appInfoMapper.deleteByPrimaryKey(id);
        if (temp>0) {
            return temp;
        } else {
            return 0;
        }
    }

    @Override
    public PageInfo<AppInfo> getAppInfoByStatus(AppInfoCondition appInfoCondition) {
        List<AppInfo> list = appInfoMapper.getAppInfoByStatus(appInfoCondition);
        PageHelper.startPage(appInfoCondition.getPageNum(), appInfoCondition.getPageSize());
        return new PageInfo<>(list);
    }

    @Override
    public Integer updateVersionIdWhenAdd(Long appId, Long versionId) {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(appId);
        appInfo.setVersionid(versionId);
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }

    @Override
    public Integer updateStatusByAppId(Long appId, Long status) {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(appId);
        appInfo.setStatus(status);
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }

}
