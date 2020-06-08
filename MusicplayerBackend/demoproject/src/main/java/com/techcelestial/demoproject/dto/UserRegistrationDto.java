package com.techcelestial.demoproject.dto;

import com.techcelestial.demoproject.model.UserRegistrationModel;

import java.util.List;

public class UserRegistrationDto {
    private Integer registrationId;
    private String username;
    private String password;
    private String repeatPassword;
    private String contactNo;
    private Integer registrationUserCnt;

    private List<UserRegistrationModel> registrationList;

    public List<UserRegistrationModel> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<UserRegistrationModel> registrationList) {
        this.registrationList = registrationList;
    }

    public Integer getRegistrationUserCnt() {
        return registrationUserCnt;
    }

    public void setRegistrationUserCnt(Integer registrationUserCnt) {
        this.registrationUserCnt = registrationUserCnt;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
