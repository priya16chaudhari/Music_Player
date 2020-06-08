package com.techcelestial.demoproject.dao;


import com.techcelestial.demoproject.model.UserRegistrationModel;

import java.util.List;

public interface UserDao {



    String getUsername(String username);

    String getPass(String password);

    List<UserRegistrationModel> getRegistrationRecord();

    Integer getUpdateInfo(UserRegistrationModel userRegistrationModel);
}
