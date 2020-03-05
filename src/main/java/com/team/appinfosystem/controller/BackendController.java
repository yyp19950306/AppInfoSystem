package com.team.appinfosystem.controller;

import com.github.pagehelper.PageInfo;
import com.team.appinfosystem.entity.AppInfo;
import com.team.appinfosystem.entity.AppVersion;
import com.team.appinfosystem.service.AppInfoService;
import com.team.appinfosystem.service.AppVersionService;
import com.team.appinfosystem.util.AppInfoCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BackendController {

    @Autowired
    AppInfoService appInfoService;
    @Autowired
    AppVersionService appVersionService;

    @RequestMapping("/getAppInfoByStatus")
    public String getAppInfoByStatus(AppInfoCondition appInfoCondition, Model model) {
        if (appInfoCondition.getPageNum() == null || appInfoCondition.getPageNum() < 1) {
            appInfoCondition.setPageNum(1);
        }
        PageInfo<AppInfo> pageInfo = appInfoService.getAppInfoByStatus(appInfoCondition);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("appInfoCondition", appInfoCondition);
        return "/jsp/backend/applist";
    }

    @RequestMapping("/getAppInfoAndVersionByAppId")
    public String getAppInfoAndVersionByAppId(Long appId, Model model) {
        AppInfo appInfo = appInfoService.getAppInfoById(appId);
        model.addAttribute("appInfo", appInfo);
        AppVersion appVersion = appVersionService.getLastVersionByAppId(appId);
        model.addAttribute("appVersion", appVersion);
        return "/jsp/backend/appcheck";
    }

    @RequestMapping("/check")
    public String  check(Long appId, Long status) {
        Integer temp = appInfoService.updateStatusByAppId(appId, status);
        if (temp > 0) {
            return "redirect:/getAppInfoByStatus";
        } else {
            return "redirect:/getAppInfoAndVersionByAppId?appId=" + appId;
        }
    }

}
