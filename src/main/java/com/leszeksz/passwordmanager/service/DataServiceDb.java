package com.leszeksz.passwordmanager.service;

import com.leszeksz.passwordmanager.entity.Data;
import com.leszeksz.passwordmanager.passwordGenerator.EncDec;
import com.leszeksz.passwordmanager.passwordGenerator.Generator;
import com.leszeksz.passwordmanager.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceDb implements DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataServiceDb(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Data save(Data data) {
        String secretKey = "boooooooooom!!!!";
        String password = Generator.generateRandomPassword();
        String hasheedPassword = EncDec.encrypt(password, secretKey);
        data.setRandomGeneratedPassword(hasheedPassword);
        return this.dataRepository.save(data);
    }

    @Override
    public Data findOneById(Long id) {
        return dataRepository.findOneById(id);
    }

    @Override
    public List<Data> findAll() {
        return dataRepository.findAll();
    }
}
