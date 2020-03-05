package com.team.appinfosystem.service.impl;

import com.team.appinfosystem.entity.DevUser;
import com.team.appinfosystem.entity.DevUserExample;
import com.team.appinfosystem.mapper.DevUserMapper;
import com.team.appinfosystem.service.DevloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevloginServiceImpl implements DevloginService {

    @Autowired
    private DevUserMapper devUserMapper;


    @Override
    public DevUser login(String devCode, String devPassword) {
        DevUserExample devUserExample = new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();
        criteria.andDevcodeEqualTo(devCode);
        criteria.andDevpasswordEqualTo(devPassword);
        List<DevUser> devUsers = devUserMapper.selectByExample(devUserExample);
        if (devUsers.size() > 0) {
            return devUsers.get(0);
        } else {
            return null;
        }
    }
}
