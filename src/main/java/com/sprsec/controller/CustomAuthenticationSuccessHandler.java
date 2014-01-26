/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import java.io.IOException;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

/**
 *
 * @author DELL
 */
@Controller
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("CEO")) {
            response.sendRedirect("userpage");
        } else if (roles.contains("BUH")) {
            response.sendRedirect("userpage");
        } else if (roles.contains("MNGR")) {
            response.sendRedirect("userpage");
        } else if (roles.contains("EMP")) {
            response.sendRedirect("userpage");
        } else if (roles.contains("ADMN")) {
            response.sendRedirect("admin/adminpage");
        }
    }
}
