package com.team.appinfosystem.service;

import com.team.appinfosystem.entity.AppVersion;

import java.util.List;

public interface AppVersionService {

    List<AppVersion> getAppVersionByAppId(Long appId);

    Integer addAppVersion(AppVersion appVersion);

    AppVersion getLastVersionByAppId(Long appId);
}
