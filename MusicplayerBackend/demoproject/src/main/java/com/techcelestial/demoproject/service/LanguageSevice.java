package com.techcelestial.demoproject.service;

import com.techcelestial.demoproject.dto.LanguageDto;

import java.util.List;

public interface LanguageSevice {
    boolean insertLanguageController(LanguageDto languageDto);

    List getActiveLangList();

    List getLanguageWiseSongController(LanguageDto languageDto);
}
