package com.leszeksz.passwordmanager.service;

import com.leszeksz.passwordmanager.entity.Portal;

import java.util.List;


public interface PortalService {

    void save(Portal portal);

    List<Portal> findAll();

    Portal findOneById(Long id);

    void delete(Portal portal);
}
