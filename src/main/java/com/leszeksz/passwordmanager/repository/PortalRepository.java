package com.leszeksz.passwordmanager.repository;

import com.leszeksz.passwordmanager.entity.Portal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalRepository extends JpaRepository<Portal, Long> {

    Portal findOneById(Long id);
}
