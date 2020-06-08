package com.techcelestial.demoproject.model;

import javax.persistence.*;

@Entity
@Table(name = "userregistration")
public class UserRegistrationModel {

    @Id
    @GeneratedValue
    @Column(name = "registration_id")
    private Integer registrationId;

    @Column(name = "registration_username")
    private String username;

    @Column(name = "registration_password")
    private String password;

    @Column(name = "registration_repeatPasssword")
    private String repeatPassword;

    @Column(name = "registration_contactNo")
    private String contactNo;

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
