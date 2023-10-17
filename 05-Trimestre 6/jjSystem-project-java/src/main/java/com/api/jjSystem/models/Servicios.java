package com.api.jjSystem.models;

import jakarta.persistence.*;
import org.hibernate.annotations.MapKeyCompositeType;

@Entity
@Table(name = "Servicios")

public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Integer idServicio;
    @Column(name = "nombreServicio")
    private String nombreServicio;
    @Column(name = "descripcionServicio")
    private String descripcionServicio;
    @ManyToOne
    @JoinColumn(name = "idAdministrador")
    private Administrador administrador;
    @OneToOne
    @JoinColumn(name = "idCategoriaServicio")
    private CategoriaServicios categoriaServicios;

    public Servicios() {
    }

    public Servicios(Integer idServicio, String nombreServicio, String descripcionServicio, Administrador administrador, CategoriaServicios categoriaServicios) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.administrador = administrador;
        this.categoriaServicios = categoriaServicios;
    }

    //Getter y Setter

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public CategoriaServicios getCategoriaServicios() {
        return categoriaServicios;
    }

    public void setCategoriaServicios(CategoriaServicios categoriaServicios) {
        this.categoriaServicios = categoriaServicios;
    }
}
