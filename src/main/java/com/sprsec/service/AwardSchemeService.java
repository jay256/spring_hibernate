/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.AwardScheme;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface AwardSchemeService {
    public List<AwardScheme> getAllAwardSchemes();

    public Integer getValueByAname(String aname);
}
