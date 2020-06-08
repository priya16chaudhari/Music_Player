package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.UserRegistrationDto;

public interface UserRegistrationService {
    boolean insertRegisterCtrl(UserRegistrationDto userRegistrationDto);

    UserRegistrationDto getRegistrationCntCtrl();
}
