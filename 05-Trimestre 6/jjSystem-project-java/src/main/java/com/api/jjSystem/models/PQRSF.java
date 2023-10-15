package com.api.jjSystem.models;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Date;

@Entity
@Table(name = "PQRSF")
public class PQRSF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPQRSF")
    private Integer id;

    private Date fechaPQRSF;

    private String informacionPQRSF;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes clientes;

    @OneToOne
    @JoinColumn(name = "idEstadoPQRSF")
    private EstadoPQRSF estadoPQRSF;

    @OneToOne
    @JoinColumn(name = "idTipoPQRS")
    private TipoPQRSF tipoPQRSF;

    public PQRSF() {
    }

    public PQRSF(Integer id, Date fechaPQRSF, String informacionPQRSF, Clientes clientes, EstadoPQRSF estadoPQRSF, TipoPQRSF tipoPQRSF) {
        this.id = id;
        this.fechaPQRSF = fechaPQRSF;
        this.informacionPQRSF = informacionPQRSF;
        this.clientes = clientes;
        this.estadoPQRSF = estadoPQRSF;
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

    public EstadoPQRSF getEstadoPQRSF() {
        return estadoPQRSF;
    }

    public void setEstadoPQRSF(EstadoPQRSF estadoPQRSF) {
        this.estadoPQRSF = estadoPQRSF;
    }

    public TipoPQRSF getTipoPQRSF() {
        return tipoPQRSF;
    }

    public void setTipoPQRSF(TipoPQRSF tipoPQRSF) {
        this.tipoPQRSF = tipoPQRSF;
    }
}
