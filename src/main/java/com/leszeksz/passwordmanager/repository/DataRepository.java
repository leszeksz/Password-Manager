package com.leszeksz.passwordmanager.repository;

import com.leszeksz.passwordmanager.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {

    Data findOneById(Long id);
}
