package com.leszeksz.passwordmanager.service;

import com.leszeksz.passwordmanager.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    public User findUserByEmail(String email);

    public void save(User user);

    User findOneById(Long id);
}

