package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.UserDao;
import com.techcelestial.demoproject.dto.ForgotDto;
import com.techcelestial.demoproject.dto.UserDto;
import com.techcelestial.demoproject.model.UserRegistrationModel;
import com.techcelestial.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    public UserDto insertLoginCtrl(UserDto userDto)
    {
        String username=userDao.getUsername(userDto.getUsername());
        System.out.println("query username:"+username);

        UserDto userDto1=new UserDto();
        // login2Dto1.setUsername("priya");
        // login2Dto1.setPassword("priya");
        if(username==null)
        {
            userDto1.setUsername("inactiveUser");
            return userDto1;
        }
        String password1=userDao.getPass(userDto.getPassword());
        System.out.println("query passw:"+password1);

        if(password1==null)
        {
            userDto1.setPassword("inactivePass");
            return userDto1;
        }
        if (username != null && password1!=null ) {
            if (userDto.getUsername() != null && userDto.getPassword()!=null) {
                if (userDto.getUsername().equals(username) && userDto.getPassword().equals(password1)) {

                    userDto.setUsername(username);
                    userDto.setPassword(password1);

                    System.out.println("username:"+username);

                    System.out.println("password1:"+password1);
                    return userDto;
                }
            }
        }

        return userDto1;

    }

    @Override
    public Integer insertNewPass(ForgotDto forgotDto)
    {
        List<UserRegistrationModel> userRegistrationModelList = userDao.getRegistrationRecord();
        System.out.println("Registration List=" + userRegistrationModelList.size());

        for (UserRegistrationModel userRegistrationModel : userRegistrationModelList) //registration list
        {

            if(forgotDto.getForgotContactNo().equals(userRegistrationModel.getContactNo()))
            {

                userRegistrationModel.setRegistrationId(userRegistrationModel.getRegistrationId());
                userRegistrationModel.setContactNo(forgotDto.getForgotContactNo());
                userRegistrationModel.setPassword(forgotDto.getForgotPassword());
                userRegistrationModel.setRepeatPassword(forgotDto.getForgotConpassword());

                Integer res=userDao.getUpdateInfo(userRegistrationModel);
                return res;

            }
            else
            {
                System.out.println("data not updated");
            }
        }
        return 5;
    }
}
