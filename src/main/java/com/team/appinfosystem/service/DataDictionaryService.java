package com.team.appinfosystem.service;

import com.team.appinfosystem.entity.DataDictionary;

import java.util.List;

public interface DataDictionaryService {

    List<DataDictionary> getDataDictionaryByTypeName(String typename);
}
