package com.team.appinfosystem.service.impl;

import com.team.appinfosystem.entity.AppCategory;
import com.team.appinfosystem.entity.AppCategoryExample;
import com.team.appinfosystem.mapper.AppCategoryMapper;
import com.team.appinfosystem.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Autowired
    AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> getAppCategoryByParentId(Long parentid) {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        if (parentid == null) {
            criteria.andParentidIsNull();
        } else {
            criteria.andParentidEqualTo(parentid);
        }
        return appCategoryMapper.selectByExample(appCategoryExample);
    }
}
