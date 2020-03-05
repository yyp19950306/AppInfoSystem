package com.team.appinfosystem.mapper;

import com.team.appinfosystem.entity.AppCategory;
import com.team.appinfosystem.entity.AppCategoryExample;
import java.util.List;

public interface AppCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    List<AppCategory> selectByExample(AppCategoryExample example);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}