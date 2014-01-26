/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sujata
 */
public interface UpdateDAO {
 
    public void uploadPicture(MultipartFile filepath);
    public int changePassword(String newpwd,String oldpwd);
    public void changeNumber(String newnum);
}
