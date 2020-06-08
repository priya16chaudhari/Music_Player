package com.techcelestial.demoproject.controller;


import com.techcelestial.demoproject.dto.AdminDto;
import com.techcelestial.demoproject.dto.ResponseVO;
import com.techcelestial.demoproject.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/insertAdminRecord",method = RequestMethod.POST)
    public ResponseVO insertAdminRecord(@RequestBody AdminDto adminDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=adminService.insertAdminController(adminDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("insert Successfully");
            responseVO.setResult(flag);

        }
        else {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(flag);
        }
        return responseVO;

    }


//    @RequestMapping(value="getCompanyRecord",method=RequestMethod.GET)
//    public List getdataList()
//    {
//        ResponseVO  responseVO=new ResponseVO();
//
//        List list=companyService.getCompanyDetails();
//        if (list!= null) {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("get Successfully");
//            responseVO.setResult(list);
//        }
//        else
//
//        {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
//            responseVO.setMessage("insert Successfully");
//            responseVO.setResult(list);
//        }
//        return list;
//    }
//
//    @RequestMapping(value = "editCompanyRecord/{companyId}",method = RequestMethod.POST)
//
//    public ResponseVO editCompanyRecord(@PathVariable Integer companyId) {
//        ResponseVO responseVO = new ResponseVO();
//        CompanyDto companyDto= companyService.editCompanyService(companyId);
//        if (companyDto!=null) {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("edited sucessfully");
//            responseVO.setResult(companyDto);
//        } else {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
//            responseVO.setMessage("failed");
//            responseVO.setResult(companyDto);
//        }
//        return responseVO;
//
//    }
//
//    @RequestMapping(value = "updateCompanyRecord", method = RequestMethod.POST)
//    public ResponseVO updateCompanyRecord(@RequestBody CompanyDto companyDto )
//    {
//        ResponseVO responseVO = new ResponseVO();
//        boolean flag = companyService.updateCompanyService(companyDto);
//        if (flag == true) {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("updated sucessfully");
//            responseVO.setResult(companyDto);
//        } else {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
//            responseVO.setMessage("failed");
//            responseVO.setResult(companyDto);
//        }
//        return responseVO;
//    }
//
//
//    @RequestMapping(value = "deleteCompanyRecord/{companyId}",method = RequestMethod.POST)
//
//    public ResponseVO deleteCompanyRecord(@PathVariable Integer companyId) {
//        ResponseVO responseVO = new ResponseVO();
//        boolean flag= companyService.deleteCompanyService(companyId);
//        if (flag==true) {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("deleted sucessfully");
//            responseVO.setResult(flag);
//        } else {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
//            responseVO.setMessage("failed");
//            responseVO.setResult(flag);
//        }
//        return responseVO;
//
//    }

}
