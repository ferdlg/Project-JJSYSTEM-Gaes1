package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PQRSF")
public class PQRSF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPQRSF")
    private Integer idPQRSF;
    private Date fechaPQRSF;
    private String informacionPQRSF;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes clientes;
    @OneToOne
    @JoinColumn(name = "idEstadoPQRSF")
    private EstadosPQRSF estadosPQRSF;
    @OneToOne
    @JoinColumn(name = "idTipoPQRSF")
    private TiposPQRSF tiposPQRSF;

    public PQRSF() {
    }

    public PQRSF(Integer idPQRSF, Date fechaPQRSF, String informacionPQRSF, Clientes clientes, EstadosPQRSF estadosPQRSF, TiposPQRSF tiposPQRSF) {
        this.idPQRSF = idPQRSF;
        this.fechaPQRSF = fechaPQRSF;
        this.informacionPQRSF = informacionPQRSF;
        this.clientes = clientes;
        this.estadosPQRSF = estadosPQRSF;
        this.tiposPQRSF = tiposPQRSF;
    }

    public Integer getIdPQRSF() {
        return idPQRSF;
    }

    public void setIdPQRSF(Integer idPQRSF) {
        this.idPQRSF = idPQRSF;
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

    public EstadosPQRSF getEstadosPQRSF() {
        return estadosPQRSF;
    }

    public void setEstadosPQRSF(EstadosPQRSF estadosPQRSF) {
        this.estadosPQRSF = estadosPQRSF;
    }

    public TiposPQRSF getTiposPQRSF() {
        return tiposPQRSF;
    }

    public void setTiposPQRSF(TiposPQRSF tiposPQRSF) {
        this.tiposPQRSF = tiposPQRSF;
    }

}
