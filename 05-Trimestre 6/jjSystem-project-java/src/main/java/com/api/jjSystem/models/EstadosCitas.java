package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table

public class EstadosCitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoCita")
    private Integer id;
}
