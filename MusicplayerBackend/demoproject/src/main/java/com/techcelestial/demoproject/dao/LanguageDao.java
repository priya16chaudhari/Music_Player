package com.techcelestial.demoproject.dao;

import com.techcelestial.demoproject.model.LanguageModel;

import java.util.List;

public interface LanguageDao {
    boolean insertLanguageService(LanguageModel languageModel);

    List getActiveLangDao();

    List getActiveLangDao(Integer languageId);
}
