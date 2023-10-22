package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pqrsf")
public class PQRSF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPQRSF")
    private Integer id;

    private Date fechaPQRSF;

    private String informacionPQRSF;

    @ManyToOne
    @JoinColumn(name = "Cliente_idCliente")
    private Clientes clientes;

    @OneToOne
    @JoinColumn(name = "EstadoPQRSF_idEstadoPQRSF")
    private EstadosPQRSF estadosPQRSF;

    @OneToOne
    @JoinColumn(name = "TipoPQRSF_idTipoPQRSF")
    private TipoPQRSF tipoPQRSF;

    public PQRSF() {
    }

    public PQRSF(Integer id, Date fechaPQRSF, String informacionPQRSF, Clientes clientes, EstadosPQRSF estadosPQRSF, TipoPQRSF tipoPQRSF) {
        this.id = id;
        this.fechaPQRSF = fechaPQRSF;
        this.informacionPQRSF = informacionPQRSF;
        this.clientes = clientes;
        this.estadosPQRSF = estadosPQRSF;
        this.tipoPQRSF = tipoPQRSF;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPQRSF() {
        return fechaPQRSF;
    }

    public void setFechaPQRSF(Date fechaPQRSF) {
        this.fechaPQRSF = fechaPQRSF;
    }

    public String getInformacionPQRSF() {
        return informacionPQRSF;
    }

    public void setInformacionPQRSF(String informacionPQRSF) {
        this.informacionPQRSF = informacionPQRSF;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public EstadosPQRSF getEstadoPQRSF() {
        return estadosPQRSF;
    }

    public void setEstadoPQRSF(EstadosPQRSF estadosPQRSF) {
        this.estadosPQRSF = estadosPQRSF;
    }

    public TipoPQRSF getTipoPQRSF() {
        return tipoPQRSF;
    }

    public void setTipoPQRSF(TipoPQRSF tipoPQRSF) {
        this.tipoPQRSF = tipoPQRSF;
    }
}
