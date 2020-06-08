package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.ForgotDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.dto.SongDto;
import com.techcelestial.demoproject.dto.UserDto;
import com.techcelestial.demoproject.service.SongService;
import com.techcelestial.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insertLogin",method = RequestMethod.POST)
    public ResponseVO<UserDto> insertLoginRecord(@RequestBody UserDto userDto)
    {
        ResponseVO<UserDto> responseVO=new ResponseVO();
//// Integer result=loginService.insertLoginCtrl(login2Dto);

        System.out.println("userrrr"+userDto.getUsername());
        UserDto userDto1=userService.insertLoginCtrl(userDto);

        if(userDto1!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("username return");
            responseVO.setResult(userDto1);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("username incorrect");
            responseVO.setResult(userDto1);
        }
        return responseVO;

    }

    @RequestMapping(value = "/forgotPassword",method = RequestMethod.POST)
    public ResponseVO insertNewPassword(@RequestBody ForgotDto forgotDto)
    {
        ResponseVO responseVO=new ResponseVO();
        Integer res=userService.insertNewPass(forgotDto);

        if(res==1)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Password changed successfully");
            responseVO.setResult(res);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Password change failed");
            responseVO.setResult(res);
        }
        return responseVO;
    }

//    @RequestMapping(value = "/insertUserRecord",method = RequestMethod.POST)
//    public ResponseVO insertSongRecord(@RequestBody UserDto userDto)
//    {
//        ResponseVO responseVO=new ResponseVO();
//        boolean flag=userService.insertUserController(userDto);
//
//        if(flag==true)
//        {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("insert Successfully");
//            responseVO.setResult(flag);
//
//        }
//        else {
//            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
//            responseVO.setMessage("failed");
//            responseVO.setResult(flag);
//        }
//        return responseVO;
//
//    }

}
