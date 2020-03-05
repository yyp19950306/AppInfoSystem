package com.team.appinfosystem.service;

import com.team.appinfosystem.entity.DevUser;

public interface DevloginService {
    DevUser login(String devCode,String devPassword);

}
