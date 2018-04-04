package com.jovin.webapp.auth.services;

import com.jovin.webapp.auth.models.Users;
import com.jovin.webapp.auth.models.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by hexad3cimal on 25/3/18.
 */
@Service("loginService")
public class LoginService implements UserDetailsService {
    @Autowired
    private UserService userService;


    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            System.out.println("hhhh"+userName);
            Users user = userService.getByEmail(userName);
            if (Objects.nonNull(user)) {
                String role = "";
                   for(UserRoles ur: user.getUserRoleses())
                       role = ur.getRoles().getRoleName();
                List<GrantedAuthority> rolesList = new ArrayList<GrantedAuthority>();
                rolesList.add(new SimpleGrantedAuthority(role));

                return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(),
                        true, true, true, true, rolesList);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
