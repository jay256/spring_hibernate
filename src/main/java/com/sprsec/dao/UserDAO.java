package com.sprsec.dao;

import com.sprsec.model.User;
import java.math.BigInteger;
import java.util.List;

public interface UserDAO {

    public User getUser(String login);

    public BigInteger getPhone(int id);

    public byte[] getPicture(int id);

    public List<User> getAllUsers();

    public User getUserByID(int id);

    public void setRating(float parseFloat);

    public User getUserByNid(int id);

    public List<User> getRecentBdays();

    public void empUnderMngr(String[] mngrs, int eid);

    public void mngrsUnderBUH(String[] mngrs, int eid);

    public void newManager(int mid, int bid, String[] eids, boolean radio, boolean emptable);
}
