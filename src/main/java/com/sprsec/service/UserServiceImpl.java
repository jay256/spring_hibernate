package com.sprsec.service;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprsec.dao.UserDAO;
import com.sprsec.model.User;
import java.math.BigInteger;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUser(String login) {
        return userDAO.getUser(login);
    }

    public BigInteger getPhone(int id) {
        return userDAO.getPhone(id);
    }

    public byte[] getPicture(int id) {
        return userDAO.getPicture(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    public void setRating(float parseFloat) {
        userDAO.setRating(parseFloat);
    }

    public User getUserByNid(int id) {
        return userDAO.getUserByNid(id);

    }

    public List<User> getRecentBdays() {
        return userDAO.getRecentBdays();
    }

    public void empUnderMngr(String[] mngrs, int eid) {
        userDAO.empUnderMngr(mngrs, eid);
    }

    public void mngrsUnderBUH(String[] mngrs, int eid) {
        userDAO.mngrsUnderBUH(mngrs, eid);
    }

    public void newManager(int mid, int bid, String[] eids, boolean radio, boolean emptable) {
        userDAO.newManager(mid, bid, eids, radio, emptable);
    }
}
