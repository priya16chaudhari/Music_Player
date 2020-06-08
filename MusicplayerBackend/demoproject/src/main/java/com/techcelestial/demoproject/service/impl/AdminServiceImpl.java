package com.techcelestial.demoproject.service.impl;


import com.techcelestial.demoproject.dao.AdminDao;
import com.techcelestial.demoproject.dto.AdminDto;
import com.techcelestial.demoproject.model.AdminModel;
import com.techcelestial.demoproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminDao adminDao;


    @Override
    public boolean insertAdminController(AdminDto adminDto) {


        AdminModel adminModel=new AdminModel();
//        artistModel.setArtistId(artistDto.getArtistId());


        adminModel.setAdminName(adminDto.getAdminName());
        adminModel.setAdminPassword(adminDto.getAdminPassword());


        boolean flag=adminDao.insertAdminService(adminModel);
        return flag;

    }



}
