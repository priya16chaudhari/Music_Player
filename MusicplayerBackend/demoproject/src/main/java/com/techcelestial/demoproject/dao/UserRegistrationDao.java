package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.dto.UserRegistrationDto;
import com.techcelestial.demoproject.model.UserRegistrationModel;

import java.util.List;

public interface UserRegistrationDao {
    boolean insertRegisterRecord(UserRegistrationModel userRegistrationModel);

    List<UserRegistrationModel> getCntListRecord();
}
