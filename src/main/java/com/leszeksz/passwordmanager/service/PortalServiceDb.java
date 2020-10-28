package com.leszeksz.passwordmanager.service;

import com.leszeksz.passwordmanager.entity.Portal;
import com.leszeksz.passwordmanager.repository.PortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalServiceDb implements PortalService {

    private PortalRepository portalRepository;

    @Autowired
    public PortalServiceDb(PortalRepository portalRepository) {

        this.portalRepository = portalRepository;
    }


    @Override
    public void save(Portal portal) {
        portalRepository.save(portal);
    }

    @Override
    public List<Portal> findAll() {
        return portalRepository.findAll();
    }

    @Override
    public Portal findOneById(Long id) {
        return portalRepository.findOneById(id);
    }

    @Override
    public void delete(Portal portal) {
        portalRepository.delete(portal);
    }

}
