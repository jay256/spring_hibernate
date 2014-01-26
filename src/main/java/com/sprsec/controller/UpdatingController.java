/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdatingController {

    private UpdateService updateService;

    @Autowired
    public void setUploadService(UpdateService updateService) {
        this.updateService = updateService;
    }

    public UpdateService getUploadService() {
        return updateService;
    }

    @RequestMapping(value = "/profileupdate", method = RequestMethod.GET)
    public ModelAndView updatedet() {
        return new ModelAndView("profileupdate");
    }

    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public ModelAndView uploadpic(@RequestParam("name1") MultipartFile name) {
        if (name.isEmpty() != true && (name.getOriginalFilename().contains("jpg") || name.getOriginalFilename().contains("gif") || name.getOriginalFilename().contains("png") || name.getOriginalFilename().contains("bmp"))) {
            updateService.uploadPicture(name);
            return new ModelAndView("profileupdate");
        } else {
            return new ModelAndView("profileupdate").addObject("errorpicture", true);
        }

    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public ModelAndView newpasswrd(@RequestParam("newpassword") String name1, @RequestParam("oldpassword") String name2, @RequestParam("confirmpassword") String name3) {
        if (updateService.changePassword(name1, name2) == 1 && name1.equals(name3)) {
            return new ModelAndView("profileupdate");
        } else {
            return new ModelAndView("profileupdate").addObject("errorpassword", true);
        }
    }

    @RequestMapping(value = "/phonenumber", method = RequestMethod.POST)
    public ModelAndView newphnum(@RequestParam("namep") String name) {
        int temp = 0, i = 0;
        while ((temp == 0) && (i < 10)) {
            int num = (int) (name.charAt(i));
            if ((num < 48) || (num > 57)) {
                temp = 1;
            }
            i++;
        }
        if (name.length() == 10 && temp==0) {
            updateService.changeNumber(name);
            return new ModelAndView("profileupdate");
        } else {
            return new ModelAndView("profileupdate").addObject("errorphone", true);
        }
    }
}
