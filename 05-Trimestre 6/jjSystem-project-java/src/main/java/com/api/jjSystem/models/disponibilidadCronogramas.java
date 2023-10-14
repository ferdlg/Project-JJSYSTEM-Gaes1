package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "disponibilidadCronogramas")
public class disponibilidadCronogramas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDisponibilidadCronograma")
    private Integer id;
}