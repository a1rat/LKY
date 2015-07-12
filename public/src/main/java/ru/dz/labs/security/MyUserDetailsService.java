package ru.dz.labs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.UserService;

/**
 * Created by Rail on 28.06.2015.
 */

@Component
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users userInfo = userService.loadUserByUsername(s);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + s + " not found");
        return new User(userInfo);
    }
}
