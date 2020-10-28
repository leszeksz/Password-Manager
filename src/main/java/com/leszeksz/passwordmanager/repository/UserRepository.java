package com.leszeksz.passwordmanager.repository;

import com.leszeksz.passwordmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
