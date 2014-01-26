package com.sprsec.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.UserDAO;
import static com.sprsec.service.CustomUserDetailsService.getGrantedAuthorities;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        com.sprsec.model.User domainUser = userDAO.getUser(login);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new CustomUser(
                domainUser.getLogin(),
                domainUser.getPassword(),
                domainUser.getName(),
                domainUser.getDob(),
                domainUser.getId(),
                domainUser.getRating(),
                domainUser.getEmp_role(),
                domainUser.getDoj(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRole().getId()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    public List<String> getRoles(Integer role) {

        List<String> roles = new ArrayList<String>();

        if (role.intValue() == 1) {
            roles.add("CEO");
            roles.add("EMP");
        }else if (role.intValue() == 2) {
            roles.add("BUH");
            roles.add("MNGR");
            roles.add("EMP");
        }else if (role.intValue() == 3) {
            roles.add("MNGR");
            roles.add("EMP");
        }else if (role.intValue() == 4) {
            roles.add("EMP");
        }else if (role.intValue() == 5) {
            roles.add("ADMN");
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}