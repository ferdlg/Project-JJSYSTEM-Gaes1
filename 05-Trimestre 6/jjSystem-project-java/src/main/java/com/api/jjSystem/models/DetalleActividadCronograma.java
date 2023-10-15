package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "detalleActividadCronograma")
public class DetalleActividadCronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleActividad")
    private Integer idDetalleActividad;

    @ManyToOne
    @JoinColumn(name = "idCronogramaTecnico")
    private CronogramaTecnicos cronogramaTecnicos;
    @ManyToOne
    @JoinColumn(name = "idActividadCronogramaTecnico")
    private ActividadesCronogramaTecnicos actividadesCronogramaTecnicos;

    private LocalDateTime fechaActividadCronograma;
    //Constructores
    public DetalleActividadCronograma() {
    }

    public DetalleActividadCronograma(Integer idDetalleActividad, CronogramaTecnicos cronogramaTecnicos, ActividadesCronogramaTecnicos actividadesCronogramaTecnicos, LocalDateTime fechaActividadCronograma) {
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

    public CronogramaTecnicos getCronogramaTecnicos() {
        return cronogramaTecnicos;
    }

    public void setCronogramaTecnicos(CronogramaTecnicos cronogramaTecnicos) {
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
