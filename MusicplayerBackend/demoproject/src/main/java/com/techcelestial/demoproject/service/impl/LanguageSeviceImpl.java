package com.techcelestial.demoproject.service.impl;

import com.techcelestial.demoproject.dao.GenerDao;
import com.techcelestial.demoproject.dao.LanguageDao;
import com.techcelestial.demoproject.dto.GenerDto;
import com.techcelestial.demoproject.dto.LanguageDto;
import com.techcelestial.demoproject.model.GenerModel;
import com.techcelestial.demoproject.model.LanguageModel;
import com.techcelestial.demoproject.service.LanguageSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageSeviceImpl  implements LanguageSevice{
    @Autowired
    private LanguageDao languageDao;




    @Override
    public boolean insertLanguageController(LanguageDto languageDto) {

        LanguageModel languageModel=new LanguageModel();

        languageModel.setLanguageName(languageDto.getLanguageName());
        languageModel.setLanguageStatus(languageDto.getLanguageStatus());


        boolean flag=languageDao.insertLanguageService(languageModel);
        return flag;
    }

    @Override
    public List getActiveLangList() {
        List list=languageDao.getActiveLangDao();
        return list;
    }

    @Override
    public List getLanguageWiseSongController(LanguageDto languageDto) {
        List list=languageDao.getActiveLangDao(languageDto.getLanguageId());
        return list;

    }
}
