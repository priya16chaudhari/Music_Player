package com.techcelestial.demoproject.service;


import com.techcelestial.demoproject.dto.ForgotDto;
import com.techcelestial.demoproject.dto.UserDto;

public interface UserService {
    UserDto insertLoginCtrl(UserDto userDto);

    Integer insertNewPass(ForgotDto forgotDto);


//    boolean insertUserController(UserDto userDto);
}
