package com.team.appinfosystem.service;

import com.team.appinfosystem.entity.AppCategory;

import java.util.List;

public interface AppCategoryService {

    List<AppCategory> getAppCategoryByParentId(Long parentid);
}
