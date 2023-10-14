package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "detalleActividadCronograma")
public class detalleActividadCronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleActividad")
    private Integer idDetalleActividad;

    @ManyToOne
    @JoinColumn(name = "idCronogramaTecnico")
    private cronogramaTecnicos cronogramaTecnicos;
    @ManyToOne
    @JoinColumn(name = "idActividadCronogramaTecnico")
    private ActividadesCronogramaTecnicos actividadesCronogramaTecnicos;

    private LocalDateTime fechaActividadCronograma;
    //Constructores
    public detalleActividadCronograma() {
    }

    public detalleActividadCronograma(Integer idDetalleActividad, com.api.jjSystem.models.cronogramaTecnicos cronogramaTecnicos, ActividadesCronogramaTecnicos actividadesCronogramaTecnicos, LocalDateTime fechaActividadCronograma) {
        this.idDetalleActividad = idDetalleActividad;
        this.cronogramaTecnicos = cronogramaTecnicos;
        this.actividadesCronogramaTecnicos = actividadesCronogramaTecnicos;
        this.fechaActividadCronograma = fechaActividadCronograma;
    }
    //get y set

    public Integer getId() {
        return idDetalleActividad;
    }

    public void setId(Integer id) {
        this.idDetalleActividad = idDetalleActividad;
    }

    public com.api.jjSystem.models.cronogramaTecnicos getCronogramaTecnicos() {
        return cronogramaTecnicos;
    }

    public void setCronogramaTecnicos(com.api.jjSystem.models.cronogramaTecnicos cronogramaTecnicos) {
        this.cronogramaTecnicos = cronogramaTecnicos;
    }

    public ActividadesCronogramaTecnicos getActividadesCronogramaTecnicos() {
        return actividadesCronogramaTecnicos;
    }

    public void setActividadesCronogramaTecnicos(ActividadesCronogramaTecnicos actividadesCronogramaTecnicos) {
        this.actividadesCronogramaTecnicos = actividadesCronogramaTecnicos;
    }

    public LocalDateTime getFechaActividadCronograma() {
        return fechaActividadCronograma;
    }

    public void setFechaActividadCronograma(LocalDateTime fechaActividadCronograma) {
        this.fechaActividadCronograma = fechaActividadCronograma;
    }
}
