/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.LeaderBoardDAO;
import com.sprsec.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sujata
 */
@Service
@Transactional
public class LeaderBoardServiceImpl implements LeaderBoardService {

    @Autowired
    private LeaderBoardDAO leaderBoardDAO;

    public List<User> getSortedBUHList() {
        return leaderBoardDAO.getSortedBUHList();
    }

    public List<User> getSortedEMPList() {
        return leaderBoardDAO.getSortedEMPList();
    }

    public List<User> getSortedMNGRList() {
        return leaderBoardDAO.getSortedMNGRList();
    }
}
