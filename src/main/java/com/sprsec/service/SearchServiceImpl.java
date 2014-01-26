/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.SearchDAO;
import com.sprsec.model.AwardScheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sprsec.model.User;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDAO searchDAO;

    public List<User> searchResults(String random, int pid) {
        return searchDAO.searchResults(random, pid);
    }

    public List<AwardScheme> schemeResults(String name) {
        return searchDAO.schemeResults(name);
    }
}