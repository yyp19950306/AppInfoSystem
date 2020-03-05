package com.team.appinfosystem.service.impl;

import com.team.appinfosystem.entity.DataDictionary;
import com.team.appinfosystem.entity.DataDictionaryExample;
import com.team.appinfosystem.mapper.DataDictionaryMapper;
import com.team.appinfosystem.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getDataDictionaryByTypeName(String typename) {
        DataDictionaryExample dataDictionaryExample = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypenameEqualTo(typename);
        return dataDictionaryMapper.selectByExample(dataDictionaryExample);
    }


}
