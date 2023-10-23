package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadosCotizaciones")

public class EstadosCotizaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoCotizacion")
    private Integer idEstadoCotizacion;
    @Column(name = "nombreEstadoCotizacion")
    private String nombreEstadoCotizacion;

    //Constructores

    public EstadosCotizaciones() {
    }

    public EstadosCotizaciones(Integer idEstadoCotizacion, String nombreEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
        this.nombreEstadoCotizacion = nombreEstadoCotizacion;
    }

    //Getter y Setter

    public Integer getIdEstadoCotizacion() {
        return idEstadoCotizacion;
    }

    public void setIdEstadoCotizacion(Integer idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public String getNombreEstadoCotizacion() {
        return nombreEstadoCotizacion;
    }

    public void setNombreEstadoCotizacion(String nombreEstadoCotizacion) {
        this.nombreEstadoCotizacion = nombreEstadoCotizacion;
    }
}
