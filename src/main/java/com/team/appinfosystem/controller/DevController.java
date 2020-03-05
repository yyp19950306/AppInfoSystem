package com.team.appinfosystem.controller;

import com.github.pagehelper.PageInfo;
import com.team.appinfosystem.entity.*;
import com.team.appinfosystem.service.*;
import com.team.appinfosystem.util.AppInfoCondition;
import com.team.appinfosystem.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class DevController {

    @Autowired
    private DevloginService devloginService;
    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping("/devlogin")
    public String devLogin(String devCode, String devPassword, HttpSession session,Model model) {
        DevUser devUser = devloginService.login(devCode, devPassword);
        if (devUser != null) {
            session.setAttribute("devUser", devUser);
            session.setMaxInactiveInterval(10*60);
            return "/jsp/developer/main";
        } else {
            model.addAttribute("error", "用户名或密码有误！");
            return "/jsp/devlogin";
        }
    }

    @RequestMapping("/devlogout")
    public String devLogout(HttpSession session) {
        session.removeAttribute("devUser");
        return "/jsp/devlogin";
    }

    @RequestMapping("/showApp")
    public String showApp(AppInfoCondition appInfoCondition, Model model,HttpSession session) {
        if (appInfoCondition.getPageNum() == null || appInfoCondition.getPageNum() < 1) {
            appInfoCondition.setPageNum(1);
        }
        DevUser devUser = (DevUser) session.getAttribute("devUser");
        appInfoCondition.setDevId(devUser.getId());
        PageInfo<AppInfo> pageInfo = appInfoService.getAppInfoByCondition(appInfoCondition);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("appInfoCondition", appInfoCondition);
        return "/jsp/developer/appinfo";
    }

    @RequestMapping("/getDataDictionaryByTypeName")
    @ResponseBody
    public List<DataDictionary> getDataDictionaryByTypeName(String typename) {
        return dataDictionaryService.getDataDictionaryByTypeName(typename);
    }

    @RequestMapping("/getAppCategoryByParentId")
    @ResponseBody
    public List<AppCategory> getAppCategoryByParentId(Long parentid) {
        return appCategoryService.getAppCategoryByParentId(parentid);
    }

    @RequestMapping("/appInfoAdd")
    public String appInfoAdd() {
        return "/jsp/developer/appinfoadd";
    }

    @RequestMapping("/addAppInfo")
    public void addAppInfo(AppInfo appInfo, @RequestParam(name = "a_logoPicPath", required = false) CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        try {
            response.setContentType("text/html;charset=utf-8");
            String path = request.getSession().getServletContext().getRealPath("upload/logo");
            String fileName = FileUploadUtil.upload(file,path);
            appInfo.setLogopicpath("upload/logo/" + fileName);
            DevUser devUser = (DevUser) session.getAttribute("devUser");
            appInfo.setDevid(devUser.getId());
            Integer temp = appInfoService.addAppInfo(appInfo);
            if (temp > 0) {
                response.getWriter().print("<script>alert('添加成功');location.href='/showApp';</script>");
            } else {
                response.getWriter().print("<script>alert('添加失败');location.href='/showApp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/appInfoModify")
    public String appInfoModify(Long id, Model model) {
        AppInfo appInfo = appInfoService.getAppInfoById(id);
        model.addAttribute("appInfo", appInfo);
        return "/jsp/developer/appinfomodify";
    }

    @RequestMapping("/updateAppInfo")
    public void updateAppInfo(AppInfo appInfo, @RequestParam(name = "a_logoPicPath", required = false) CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response,String oldPicPath) {
        try {
            response.setContentType("text/html;charset=utf-8");
            String fileName = file.getOriginalFilename();
            if (!fileName.equals("")) {
                String path = request.getSession().getServletContext().getRealPath("upload/logo");
                String uploadFileName = fileName;
                String expname = uploadFileName.substring(uploadFileName.lastIndexOf("."));
                String newFileName = System.currentTimeMillis() + expname;
                String savePos = path + "/" + newFileName;
                File saveFile = new File(savePos);
                file.transferTo(saveFile);
                appInfo.setLogopicpath("upload/logo/" + newFileName);
                File fdel = new File(request.getSession().getServletContext().getRealPath("/") + oldPicPath);
                fdel.delete();
            }
            Integer temp = appInfoService.updateAppInfo(appInfo);
            if (temp > 0) {
                response.getWriter().print("<script>alert('修改成功');location.href='/showApp';</script>");
            } else {
                response.getWriter().print("<script>alert('修改失败');location.href='/showApp';</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/deleteAppInfo")
    public void deleteAppInfo(Long id, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            Integer temp = appInfoService.deleteAppInfoById(id);
            if (temp > 0) {
                response.getWriter().print("<script>alert('删除成功');location.href='/showApp';</script>");
            } else {
                response.getWriter().print("<script>alert('删除失败');location.href='/showApp';</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/appVersionAdd")
    public String appVersionAdd(Long id,Model model) {
        List<AppVersion> appVersions = appVersionService.getAppVersionByAppId(id);
        model.addAttribute("appVersions", appVersions);
        model.addAttribute("appId", id);
        return "/jsp/developer/appversionadd";
    }

    @RequestMapping("/addAppVersion")
    @Transactional
    public void   addAppVersion(AppVersion appVersion, @RequestParam(name = "a_downloadLink", required = false) CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            response.setContentType("text/html;charset=utf-8");
            String path = request.getSession().getServletContext().getRealPath("upload/apkfile");
            String fileName = FileUploadUtil.upload(file,path);
            appVersion.setApkfilename(fileName);
            appVersion.setDownloadlink("upload/apkfile/" + fileName);
            DevUser devUser = (DevUser) session.getAttribute("devUser");
            appVersion.setCreatedby(devUser.getId());
            Integer temp = appVersionService.addAppVersion(appVersion);
            appInfoService.updateVersionIdWhenAdd(appVersion.getAppid(), appVersionService.getLastVersionByAppId(appVersion.getAppid()).getId());
            if (temp > 0) {
                response.getWriter().print("<script>alert('添加成功');location.href='/appVersionAdd?appId="+appVersion.getAppid()+"';</script>");
            } else {
                response.getWriter().print("<script>alert('添加失败');location.href='/showApp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/showAppInfoByAppId")
    public String showAppInfoByAppId(Long id, Model model) {
        AppInfo appInfo = appInfoService.getAppInfoById(id);
        model.addAttribute("appInfo", appInfo);
        List<AppVersion> appVersions = appVersionService.getAppVersionByAppId(id);
        model.addAttribute("appVersions", appVersions);
        return "/jsp/developer/appinfoview";
    }

    @RequestMapping("/change")
    public void change(Long appId, Long status, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            Integer temp = appInfoService.updateStatusByAppId(appId, status);
            if (temp > 0) {
                if (status == 4) {
                    response.getWriter().print("<script>alert('上架成功');location.href='/showApp';</script>");
                }
                if (status == 5) {
                    response.getWriter().print("<script>alert('下架成功');location.href='/showApp';</script>");
                }
            } else {
                if (status == 4) {
                    response.getWriter().print("<script>alert('上架失败');location.history.back(-1);</script>");
                }
                if (status == 5) {
                    response.getWriter().print("<script>alert('下架失败');location.history.back(-1);</script>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
