package com.leszeksz.passwordmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    String name;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    String surname;

    @NotNull
    @NotEmpty
    String password;

    @NotNull
    @NotEmpty
    @Email
    String email;

    @ManyToOne
    Data data;

}