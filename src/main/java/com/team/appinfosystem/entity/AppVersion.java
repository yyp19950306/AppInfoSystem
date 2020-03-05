package com.team.appinfosystem.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class AppVersion {
    private Long id;

    private Long appid;

    private String versionno;

    private String versioninfo;

    private Long publishstatus;

    private String downloadlink;

    private BigDecimal versionsize;

    private Long createdby;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationdate;

    private Long modifyby;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifydate;

    private String apklocpath;

    private String apkfilename;

    private String appName;

    private String publishStatusName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno == null ? null : versionno.trim();
    }

    public String getVersioninfo() {
        return versioninfo;
    }

    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo == null ? null : versioninfo.trim();
    }

    public Long getPublishstatus() {
        return publishstatus;
    }

    public void setPublishstatus(Long publishstatus) {
        this.publishstatus = publishstatus;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink == null ? null : downloadlink.trim();
    }

    public BigDecimal getVersionsize() {
        return versionsize;
    }

    public void setVersionsize(BigDecimal versionsize) {
        this.versionsize = versionsize;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getApklocpath() {
        return apklocpath;
    }

    public void setApklocpath(String apklocpath) {
        this.apklocpath = apklocpath == null ? null : apklocpath.trim();
    }

    public String getApkfilename() {
        return apkfilename;
    }

    public void setApkfilename(String apkfilename) {
        this.apkfilename = apkfilename == null ? null : apkfilename.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPublishStatusName() {
        return publishStatusName;
    }

    public void setPublishStatusName(String publishStatusName) {
        this.publishStatusName = publishStatusName;
    }
}