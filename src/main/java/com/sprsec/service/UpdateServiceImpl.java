/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.UpdateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateDAO updateDAO;

    public void uploadPicture(MultipartFile filepath) {
        updateDAO.uploadPicture(filepath);
    }

    public int changePassword(String newpwd, String oldpwd) {
        if (updateDAO.changePassword(newpwd, oldpwd) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void changeNumber(String newnum) {
        updateDAO.changeNumber(newnum);
    }
}
