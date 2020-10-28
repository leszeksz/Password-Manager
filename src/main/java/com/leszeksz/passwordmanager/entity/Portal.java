package com.leszeksz.passwordmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "portals")
@Getter
@Setter
@NoArgsConstructor
public class Portal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Please write at least 2 letters")
    String portalName;

    @NotEmpty
    @NotNull
    @Size(min = 5, message = "Please write at least 5 letters")
    String description;

    @ManyToOne
    private Data data;

}