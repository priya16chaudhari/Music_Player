package com.techcelestial.demoproject.dto;

public class ForgotDto
{
    private Integer forgotId;
    private String forgotContactNo;
    private String forgotPassword;
    private String forgotConpassword;

    public Integer getForgotId() {
        return forgotId;
    }

    public void setForgotId(Integer forgotId) {
        this.forgotId = forgotId;
    }

    public String getForgotContactNo() {
        return forgotContactNo;
    }

    public void setForgotContactNo(String forgotContactNo) {
        this.forgotContactNo = forgotContactNo;
    }

    public String getForgotPassword() {
        return forgotPassword;
    }

    public void setForgotPassword(String forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    public String getForgotConpassword() {
        return forgotConpassword;
    }

    public void setForgotConpassword(String forgotConpassword) {
        this.forgotConpassword = forgotConpassword;
    }
}
