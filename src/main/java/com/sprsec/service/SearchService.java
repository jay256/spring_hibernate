/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.AwardScheme;
import com.sprsec.model.User;
import java.util.List;

/**
 *
 * @author SaiPramila
 */
public interface SearchService {
     public List<User> searchResults(String random,int pid);

    public List<AwardScheme> schemeResults(String name);
    
}
