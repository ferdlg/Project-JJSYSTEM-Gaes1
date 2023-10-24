package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CronogramaTecnicos")
public class CronogramaTecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCronogramaTecnico")
    private Integer idCronogramaTecnico;
    @OneToOne
    @JoinColumn(name = "idTecnico")
    private Tecnicos tecnico;
    @OneToOne
    @JoinColumn(name = "idCita")
    private Citas citas;
    @OneToOne
    @JoinColumn(name = "idDisponibilidadCronograma")
    private DisponibilidadCronogramas disponibilidadCronograma;

    //Constructores
    public CronogramaTecnicos() {
    }

    public CronogramaTecnicos(Integer idCronogramaTecnico, Tecnicos tecnico, Citas citas, DisponibilidadCronogramas disponibilidadCronograma) {
        this.idCronogramaTecnico = idCronogramaTecnico;
        this.tecnico = tecnico;
        this.citas = citas;
        this.disponibilidadCronograma = disponibilidadCronograma;
    }
    //get y set

    public Integer getId() {
        return idCronogramaTecnico;
    }

    public void setId(Integer id) {
        this.idCronogramaTecnico = idCronogramaTecnico;
    }

    public Tecnicos getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnicos tecnico) {
        this.tecnico = tecnico;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public DisponibilidadCronogramas getDisponibilidadCronograma() {
        return disponibilidadCronograma;
    }

    public void setDisponibilidadCronogramas(DisponibilidadCronogramas disponibilidadCronograma) {
        this.disponibilidadCronograma = disponibilidadCronograma;
    }
}
