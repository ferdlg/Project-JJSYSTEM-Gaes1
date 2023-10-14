package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "disponibilidadCronogramas")
public class disponibilidadCronogramas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDisponibilidadCronograma")
    private Integer idDisponibilidadCronograma;
    @Column(name = "nombreDisponibilidad")
    private String nombreDisponibilidad;
    public disponibilidadCronogramas() {
    }
    public disponibilidadCronogramas(Integer idDisponibilidadCronograma, String nombreDisponibilidad) {
        this.idDisponibilidadCronograma = idDisponibilidadCronograma;
        this.nombreDisponibilidad = nombreDisponibilidad;
    }

    public Integer getIdDisponibilidadCronograma() {
        return idDisponibilidadCronograma;
    }

    public void setIdDisponibilidadCronograma(Integer idDisponibilidadCronograma) {
        this.idDisponibilidadCronograma = idDisponibilidadCronograma;
    }

    public String getNombreDisponibilidad() {
        return nombreDisponibilidad;
    }

    public void setNombreDisponibilidad(String nombreDisponibilidad) {
        this.nombreDisponibilidad = nombreDisponibilidad;
    }
}