package com.techcelestial.demoproject.controller;

import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.dto.UserRegistrationDto;
import com.techcelestial.demoproject.service.ActorService;
import com.techcelestial.demoproject.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class UserRegistrationController {
    @Autowired
    private ActorService actorService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @RequestMapping(value = "/insertRegister",method = RequestMethod.POST)
    public ResponseVO insertRegisterRecord(@RequestBody UserRegistrationDto userRegistrationDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=userRegistrationService.insertRegisterCtrl(userRegistrationDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Register record inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Register record insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getRegistrationCnt",method = RequestMethod.GET)
    public ResponseVO<UserRegistrationDto> getRegisterCntRecord()
    {
        ResponseVO<UserRegistrationDto> responseVO=new ResponseVO();
        UserRegistrationDto userRegistrationDto1=userRegistrationService.getRegistrationCntCtrl();

        if(userRegistrationDto1!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Register count record get successfully");
            responseVO.setResult(userRegistrationDto1);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Register cnt record  failed");
            responseVO.setResult(userRegistrationDto1);
        }
        return responseVO;
    }



}
