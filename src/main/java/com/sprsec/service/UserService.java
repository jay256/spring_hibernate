package com.sprsec.service;

import com.sprsec.model.User;
import java.math.BigInteger;
import java.util.List;

public interface UserService {

    public User getUser(String login);

    public BigInteger getPhone(int id);

    public byte[] getPicture(int id);

    public List<User> getAllUsers();

    public User getUserByID(int id);

    public void setRating(float parseFloat);

    public List<User> getRecentBdays();

    public User getUserByNid(int id);

    public void empUnderMngr(String[] mngrs, int id);

    public void mngrsUnderBUH(String[] mngrs, int id);

    public void newManager(int mid, int parseInt, String[] eids, boolean radio, boolean emptable);
}
