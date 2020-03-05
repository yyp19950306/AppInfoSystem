package com.team.appinfosystem.mapper;

import com.github.pagehelper.PageInfo;
import com.team.appinfosystem.entity.AppInfo;
import com.team.appinfosystem.entity.DataDictionary;
import com.team.appinfosystem.entity.DataDictionaryExample;
import java.util.List;

public interface DataDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    List<DataDictionary> selectByExample(DataDictionaryExample example);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);

}