/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.AwardScheme;
import com.sprsec.model.Comment;
import com.sprsec.model.User;
import com.sprsec.service.AdminService;
import com.sprsec.service.CommentService;
import com.sprsec.service.CustomUser;
import com.sprsec.service.UserService;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
@Controller
public class AdminController {

    private UserService userService;
    private CommentService commentService;
    private AdminService adminService;

    public AdminService getAdminService() {
        return adminService;
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public ModelAndView getModelAndView(String viewName) {
        ModelAndView mv = new ModelAndView(viewName);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BigInteger phone;
        String username;
        Integer id;
        String dob;
        float rating;
        String emp_role;
        List<Comment> commentstring;
        if (principal instanceof CustomUser) {
            username = ((CustomUser) principal).getName();
            id = ((CustomUser) principal).getId();
            dob = ((CustomUser) principal).getDOB();
            rating = ((CustomUser) principal).getRating();
            emp_role = ((CustomUser) principal).getEmp_role();
            phone = userService.getPhone(id);
            commentstring = commentService.getComment(id);
        } else {
            username = null;
            id = null;
            dob = null;
            rating = 0;
            emp_role = null;
            phone = null;
            commentstring = null;
        }
        mv.addObject("aname", username);
        mv.addObject("emp_id", id);
        mv.addObject("dob", dob);
        mv.addObject("rating", rating);
        mv.addObject("role", emp_role);
        mv.addObject("phone", phone);
        mv.addObject("comments", commentstring);
        return mv;
    }

    @RequestMapping(value = "/admin/adminpage", method = RequestMethod.GET)
    public ModelAndView firstAdminPage(String login) {
        ModelAndView mav = new ModelAndView("adminpage");
        List<AwardScheme> awardlist = new ArrayList<AwardScheme>();
        awardlist = adminService.getAllSchemes();

        mav.addObject("allschemes", awardlist);
        return mav;
    }
    
    @RequestMapping(value = "/admin/employeedb", method = RequestMethod.GET)
    public ModelAndView employeeDB(String login) {
        ModelAndView mav = new ModelAndView("employeedb");
        return mav;
    }

    @RequestMapping(value = "/admin/addnewemp", method = RequestMethod.POST)
    public ModelAndView empMaster(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mav = new ModelAndView("updatesuccessemp");
        ModelAndView mav1 = new ModelAndView("updatesuccessmngr");
        ModelAndView mav2 = new ModelAndView("updatesuccessbuh");
        ModelAndView mv = new ModelAndView("employeedb");
        int temp1 = 0;
        String name = request.getParameter("name1");
        int len = name.length();
        if (len == 0) {
            mv.addObject("error", true);
            return mv;

        }
        int temp = 0;
        int i = 0;
        while (temp == 0 && i < len) {
            int num = (int) (name.charAt(i));
            if ((num == 32) || (num == 46) || ((num >= 65) && (num <= 90)) || ((num >= 97) && (num <= 122))) {
                temp = 0;
            } else {
                temp = 1;
            }
            i++;
        }
        if (temp == 1) {
            mv.addObject("error", true);
            temp1 = 1;
        }


        String dob = request.getParameter("dob1");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date lowDate = sdf.parse(dob);
        } catch (ParseException ex) {
            mv.addObject("errordob", true);
            temp1 = 1;
        }

        String doj = request.getParameter("doj1");
        SimpleDateFormat pdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date lDate = pdf.parse(dob);
        } catch (ParseException tx) {
            mv.addObject("errordoj", true);
            temp1 = 1;
        }


        String phonenums = request.getParameter("phonenum1");
        int temp3 = 0;
        while ((temp3 == 0) && (i < 10)) {
            int num = (int) (phonenums.charAt(i));
            if ((num < 48) || (num > 57)) {
                temp3 = 1;
            }
            i++;

        }
        if ((phonenums.length() != 10) || temp3 == 1) {
            temp1 = 1;
            mv.addObject("errorph", true);
        }


        String role = request.getParameter("role1");
        if ("BUSINESS UNIT HEAD".equals(role)) {
            role = "BUH";
        } else if ("MANAGER".equals(role)) {
            role = "MNGR";
        } else {
            role = "EMP";
        }

        if (temp1 == 0) {
            BigInteger phonenum = new BigInteger(phonenums);
            String newuser = adminService.addNewEmp(name, dob, doj, phonenum, role);

            if ("EMP".equals(role)) {
                Map<User, Boolean> managersmap = new HashMap<User, Boolean>();
                List<User> managerslist = new ArrayList<User>();
                managerslist = adminService.getManagersList();
                for (User rand : managerslist) {
                    managersmap.put(rand, false);
                }
                mav.addObject("mngrslist", managersmap);
                mav.addObject("empid", newuser);
                return mav;
            } else if ("MNGR".equals(role)) {
                List<User> buhlist = new ArrayList<User>();
                buhlist = adminService.getBuhList();
                Map<User, Boolean> buhmap = new HashMap<User, Boolean>();
                for (User u : buhlist) {
                    buhmap.put(u, false);
                }
                mav1.addObject("buhlist", buhmap);
                List<User> emplis = new ArrayList<User>();
                emplis = adminService.getAllEmps();
                Map<User, Boolean> empmap = new HashMap<User, Boolean>();
                for (User u : emplis) {
                    empmap.put(u, false);
                }
                mav1.addObject("allemps", empmap);
                mav1.addObject("empid", newuser);
                mav1.addObject("radio", true);
                mav1.addObject("emptable", true);
                return mav1;
            } else {
                Map<User, User> mngrbuh = new HashMap<User, User>();

                List<User> managerslist = new ArrayList<User>();
                managerslist = adminService.getManagersList();
                for (User u : managerslist) {
                    mngrbuh.put(u, adminService.getBuhByMngr(u.getId()));
                }

                mav2.addObject("mngrslist", mngrbuh);
                mav2.addObject("empid", newuser);
                return mav2;
            }
        } else {
            return mv;
        }

    }

    @RequestMapping(value = "/admin/addnewscheme", method = RequestMethod.POST)
    public ModelAndView newScheme(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mav = new ModelAndView("adminpage");
        String aname = request.getParameter("scheme_name");
        String desc = request.getParameter("scheme_des");
        String values = request.getParameter("value");
        String credits = request.getParameter("credits");
        List<AwardScheme> awardlist = new ArrayList<AwardScheme>();
        awardlist = adminService.getAllSchemes();
        mav.addObject("allschemes", awardlist);


        try {
            int val = Integer.parseInt(values);
        } catch (NumberFormatException e) {
            mav.addObject("errorph", true);
            return mav;
        }

        if ((Integer.parseInt(values) % 500) != 0) {
            mav.addObject("errorph", true);
            return mav;
        }


        int result = adminService.addNewScheme(aname, desc, Integer.parseInt(values), Integer.parseInt(credits));
        if (result != 1) {
            mav.addObject("error", true);
        }
        awardlist = adminService.getAllSchemes();
        mav.addObject("allschemes", awardlist);
        return mav;

    }

    @RequestMapping(value = "/admin/deletescheme/{awardScheme}", method = RequestMethod.GET)
    public ModelAndView viewProfile(@PathVariable("awardScheme") String aname) {
        ModelAndView mv = new ModelAndView("adminpage");
        List<AwardScheme> awardlist = new ArrayList<AwardScheme>();

        adminService.deleteScheme(aname);
        awardlist = adminService.getAllSchemes();
        mv.addObject("allschemes", awardlist);


        return mv;

    }

    @RequestMapping(value = "/admin/updateschemepage/{awardscheme}", method = RequestMethod.GET)
    public ModelAndView updateschempag(@PathVariable("awardscheme") String aname) {
        ModelAndView mav = new ModelAndView("updateschemepage");
        mav.addObject("thisaward", aname);
        return mav;
    }

    @RequestMapping(value = "/admin/updatescheme/{awardScheme}", method = RequestMethod.GET)
    public ModelAndView updtescheme(@PathVariable("awardScheme") String aname, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("updateschemepage");
        List<AwardScheme> awardlist = new ArrayList<AwardScheme>();
        String desc = request.getParameter("scheme_des");
        String values = request.getParameter("value");
        String credits = request.getParameter("credits");
        //window.close();
        try {
            int val = Integer.parseInt(values);
        } catch (NumberFormatException e) {
            mv.addObject("errorph", true);
            mv.addObject("allschemes", awardlist);
            return mv;
        }
        adminService.updateScheme(aname, desc, Integer.parseInt(values), Integer.parseInt(credits));
        mv.addObject("errorp", true);

        return mv;

    }

    @RequestMapping(value = "/admin/updatesuccessemp/{id}", method = RequestMethod.POST)
    public ModelAndView empandmngr(@PathVariable("id") int id, @RequestParam(value = "mngrs", required = true) String[] mngrs, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("updatesuccess");
        userService.empUnderMngr(mngrs, id);
      

        return mv;
    }

    @RequestMapping(value = "/admin/updatesuccessbuh/{id}", method = RequestMethod.POST)
    public ModelAndView mngrandbuh(@PathVariable("id") int id, @RequestParam(value = "mngrs", required = true) String[] mngrs, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("updatesuccess");
        userService.mngrsUnderBUH(mngrs, id);
        

        return mv;
    }

    @RequestMapping(value = "/admin/updatesuccessmngr/{id}/{radio}/{emptable}", method = RequestMethod.POST)
    public ModelAndView mngrndbuh(@PathVariable("id") int mid, @PathVariable("radio") boolean radio, @PathVariable("emptable") boolean emptable, @RequestParam(value = "buhs", required = true) String buh, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String[] eids = request.getParameterValues("users");

        ModelAndView mv = new ModelAndView("updatesuccess");

        userService.newManager(mid, Integer.parseInt(buh), eids, radio, emptable);

        return mv;
    }

    @RequestMapping(value = "/admin/editmngrabv/{id}")
    public ModelAndView editmngrabv(@PathVariable("id") int eid) {
        ModelAndView mv = new ModelAndView("updatesuccessemp");
        mv.addObject("empid", eid);
        Map<User, Boolean> managersmap = new HashMap<User, Boolean>();
        List<User> managerslist = new ArrayList<User>();
        managerslist = adminService.getManagersList();
        List<Integer> mngrbyid = new ArrayList<Integer>();
        mngrbyid = adminService.getMngrById(eid);
        for (User u : managerslist) {
            managersmap.put(u, mngrbyid.contains(u.getId()));
        }
        mv.addObject("mngrslist", managersmap);

        return mv;

    }

    @RequestMapping(value = "/admin/promotetomanager/{id}")
    public ModelAndView promotetomanager(@PathVariable("id") int eid) {
        adminService.promoteToMngr(eid);
        ModelAndView mav1 = new ModelAndView("updatesuccessmngr");
        List<User> buhlist = new ArrayList<User>();
        buhlist = adminService.getBuhList();
        Map<User, Boolean> buhmap = new HashMap<User, Boolean>();
        for (User u : buhlist) {
            buhmap.put(u, false);
        }
        mav1.addObject("buhlist", buhmap);
        List<User> emplis = new ArrayList<User>();
        emplis = adminService.getAllEmps();
        Map<User, Boolean> empmap = new HashMap<User, Boolean>();
        for (User u : emplis) {
            empmap.put(u, false);
        }
        mav1.addObject("allemps", empmap);
        mav1.addObject("empid", eid);
        mav1.addObject("radio", true);
        mav1.addObject("emptable", true);
        return mav1;
    }

    @RequestMapping(value = "/admin/promoteemptobuh/{id}")
    public ModelAndView promoteemptobuh(@PathVariable("id") int eid) {
        adminService.promoteToBuh(eid);
        ModelAndView mv = new ModelAndView("updatesuccessbuh");
        mv.addObject("empid", eid);
        Map<User, User> mngrbuh = new HashMap<User, User>();

        List<User> managerslist = new ArrayList<User>();
        managerslist = adminService.getManagersList();
        for (User u : managerslist) {
            mngrbuh.put(u, adminService.getBuhByMngr(u.getId()));
        }

        mv.addObject("mngrslist", mngrbuh);
        return mv;
    }

    @RequestMapping(value = "/admin/editbuhabv/{id}")
    public ModelAndView editbuhabv(@PathVariable("id") int eid) {

        ModelAndView mav1 = new ModelAndView("updatesuccessmngr");
        Map<User, Boolean> buhmap = new HashMap<User, Boolean>();
        int buh = adminService.getBuhById(eid);
        List<User> buhlist = new ArrayList<User>();
        buhlist = adminService.getBuhList();
        for (User u : buhlist) {
            buhmap.put(u, (u.getId() == buh));
        }
        mav1.addObject("buhlist", buhmap);
        mav1.addObject("radio", true);
        mav1.addObject("emptable", false);
        mav1.addObject("empid", eid);
        return mav1;
    }

    @RequestMapping(value = "/admin/editempunder/{id}")
    public ModelAndView editempunder(@PathVariable("id") int eid) {

        ModelAndView mav1 = new ModelAndView("updatesuccessmngr");
        Map<User, Boolean> empmap = new HashMap<User, Boolean>();
        List<Integer> emplis = new ArrayList<Integer>();
        List<User> buhlist = new ArrayList<User>();
        buhlist = adminService.getAllEmps();
        emplis = adminService.getEmpByMid(eid);
        for (User u : buhlist) {
            empmap.put(u, emplis.contains(u.getId()));
        }
        mav1.addObject("allemps", empmap);
        mav1.addObject("radio", false);
        mav1.addObject("emptable", true);
        mav1.addObject("empid", eid);
        return mav1;
    }

    @RequestMapping(value = "/admin/promotemngrtobuh/{id}")
    public ModelAndView promotemngrtobuh(@PathVariable("id") int eid) {
        adminService.promoteToBuh(eid);
        ModelAndView mv = new ModelAndView("updatesuccessbuh");
        mv.addObject("empid", eid);
        Map<User, User> mngrbuh = new HashMap<User, User>();

        List<User> managerslist = new ArrayList<User>();
        managerslist = adminService.getManagersList();
        for (User u : managerslist) {
            mngrbuh.put(u, adminService.getBuhByMngr(u.getId()));
        }

        mv.addObject("mngrslist", mngrbuh);
        return mv;
    }

    @RequestMapping(value = "/admin/editmngrunder/{id}")
    public ModelAndView editmngrunder(@PathVariable("id") int eid) {

        ModelAndView mv = new ModelAndView("updatesuccessbuh");
        mv.addObject("empid", eid);
        Map<User, User> mngrbuh = new HashMap<User, User>();

        List<Boolean> blist = new ArrayList<Boolean>();
        List<User> managerslist = new ArrayList<User>();
        managerslist = adminService.getManagersList();
        for (User u : managerslist) {
            mngrbuh.put(u, adminService.getBuhByMngr(u.getId()));


        }

        mv.addObject("mngrslist", mngrbuh);
        mv.addObject("blist", blist);
        return mv;
    }
}
