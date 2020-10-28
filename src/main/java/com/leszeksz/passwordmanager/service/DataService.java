package com.leszeksz.passwordmanager.service;

import com.leszeksz.passwordmanager.entity.Data;

import java.util.List;

public interface DataService {
    Data save(Data data);
    Data findOneById(Long id);
    List<Data> findAll();

}
