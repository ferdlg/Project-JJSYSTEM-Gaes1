package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cotizaciones")
public class Cotizaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCotizacion")
    private Integer id;
}
