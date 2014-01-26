/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.AwardSchemeDAO;
import com.sprsec.model.AwardScheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Service
@Transactional
public class AwardSchemeServiceImpl implements AwardSchemeService{

    @Autowired
    private AwardSchemeDAO awardSchemeDAO;

    public List<AwardScheme> getAllAwardSchemes() {
        return awardSchemeDAO.getAllAwardSchemes();
    }

    public Integer getValueByAname(String aname) {
       return awardSchemeDAO.getValueByAname(aname);
    }
    
}
