package com.api.jjSystem.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "citas")
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private Integer id;
    @Column(name = "fechaCita")
    private Date fechaCita;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "contactoCliente")
    private BigInteger contactoCliente;
    @Column(name = "descripcionCita")
    private String descripcionCita;

    @ManyToOne //establece la relacion de muchas citas pueden estar asociadas a un tecnico
    @JoinColumn(name = "idTecnico")
    private Tecnicos tecnicos;

    @ManyToOne
    @JoinColumn(name = "idAdministrador")
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "idCotizacion")
    private  Cotizaciones cotizaciones;

    @ManyToOne
    @JoinColumn(name = "idEstadoCita")
    private EstadosCitas estadosCitas;

    //Constructores
    public Citas() {
    }

    public Citas(Integer id, Date fechaCita, String direccion, BigInteger contactoCliente, String descripcionCita, Tecnicos tecnicos, Administrador administrador, Cotizaciones cotizaciones, EstadosCitas estadosCitas) {
        this.id = id;
        this.fechaCita = fechaCita;
        this.direccion = direccion;
        this.contactoCliente = contactoCliente;
        this.descripcionCita = descripcionCita;
        this.tecnicos = tecnicos;
        this.administrador = administrador;
        this.cotizaciones = cotizaciones;
        this.estadosCitas = estadosCitas;
    }
    //Get y set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getContactoCliente() {
        return contactoCliente;
    }

    public void setContactoCliente(BigInteger contactoCliente) {
        this.contactoCliente = contactoCliente;
    }

    public String getDescripcionCita() {
        return descripcionCita;
    }

    public void setDescripcionCita(String descripcionCita) {
        this.descripcionCita = descripcionCita;
    }

    public Tecnicos getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Tecnicos tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cotizaciones getCotizaciones() {
        return cotizaciones;
    }

    public void setCotizaciones(Cotizaciones cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    public EstadosCitas getEstadosCitas() {
        return estadosCitas;
    }

    public void setEstadosCitas(EstadosCitas estadosCitas) {
        this.estadosCitas = estadosCitas;
    }
}
