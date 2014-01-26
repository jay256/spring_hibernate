/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.AwardScheme;
import com.sprsec.model.User;
import java.util.List;



public interface SearchDAO {
    public List<User> searchResults(String random,int pid);

    public List<AwardScheme> schemeResults(String name);
        
 }