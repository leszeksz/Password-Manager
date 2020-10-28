package com.leszeksz.passwordmanager.service;

import com.leszeksz.passwordmanager.entity.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void save(User user);
    }

