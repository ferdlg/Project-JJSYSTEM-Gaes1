package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.text.DateFormat;

@Entity
@Table(name = "respuestas")

public class Respuestas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRespuesta")
    private Integer idRespuesta;
    @Column(name = "informacionRespuesta")
    private String informacionRespuesta;
    @Column(name = "fechaRespuesta")
    private DateFormat fechaRespuesta;
    @ManyToOne
    @JoinColumn(name = "idAdministrador")
    private Administrador administrador;
    @OneToOne
    @JoinColumn(name = "idPQRSF")
    private PQRSF pqrsf;

    //Constructor

    public Respuestas() {
    }

    public Respuestas(Integer idRespuesta, String informacionRespuesta, DateFormat fechaRespuesta, Administrador administrador, PQRSF pqrsf) {
        this.idRespuesta = idRespuesta;
        this.informacionRespuesta = informacionRespuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.administrador = administrador;
        this.pqrsf = pqrsf;
    }

    //Getter y Setter

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getInformacionRespuesta() {
        return informacionRespuesta;
    }

    public void setInformacionRespuesta(String informacionRespuesta) {
        this.informacionRespuesta = informacionRespuesta;
    }

    public DateFormat getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(DateFormat fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public PQRSF getPqrsf() {
        return pqrsf;
    }

    public void setPqrsf(PQRSF pqrsf) {
        this.pqrsf = pqrsf;
    }
}
