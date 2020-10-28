package com.leszeksz.passwordmanager.entity;

import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "data")
@Getter
@Setter
@NoArgsConstructor
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Nullable
    String randomGeneratedPassword;
}