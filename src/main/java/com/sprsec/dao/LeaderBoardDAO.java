/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.User;
import java.util.List;

/**
 *
 * @author sujata
 */
public interface LeaderBoardDAO {

    public List<User> getSortedMNGRList();

    public List<User> getSortedEMPList();

    public List<User> getSortedBUHList();
}
