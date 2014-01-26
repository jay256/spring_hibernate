/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.User;
import java.util.List;

/**
 *
 * @author sujata
 */
public interface LeaderBoardService {
    
    public List<User> getSortedEMPList();
    public List<User> getSortedMNGRList();
    public List<User> getSortedBUHList();
}
