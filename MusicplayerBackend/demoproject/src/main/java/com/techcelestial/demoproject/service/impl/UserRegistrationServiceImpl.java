package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.UserRegistrationDao;
import com.techcelestial.demoproject.dto.UserRegistrationDto;
import com.techcelestial.demoproject.model.UserRegistrationModel;
import com.techcelestial.demoproject.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationDao userRegistrationDao;

    @Override
    public boolean insertRegisterCtrl(UserRegistrationDto userRegistrationDto)
    {
        UserRegistrationModel userRegistrationModel=new UserRegistrationModel();

        userRegistrationModel.setUsername(userRegistrationDto.getUsername());
        userRegistrationModel.setPassword(userRegistrationDto.getPassword());
        userRegistrationModel.setRepeatPassword(userRegistrationDto.getRepeatPassword());
        userRegistrationModel.setContactNo(userRegistrationDto.getContactNo());

        boolean flag=userRegistrationDao.insertRegisterRecord(userRegistrationModel);

        return flag;
    }

    @Override
    public UserRegistrationDto getRegistrationCntCtrl() {
        List<UserRegistrationModel> userRegistrationModelList=userRegistrationDao.getCntListRecord();

        UserRegistrationDto userRegistrationDto=new UserRegistrationDto();
        userRegistrationDto.setRegistrationUserCnt(userRegistrationModelList.size());
        userRegistrationDto.setRegistrationList(userRegistrationModelList);
        return userRegistrationDto;
    }
}
