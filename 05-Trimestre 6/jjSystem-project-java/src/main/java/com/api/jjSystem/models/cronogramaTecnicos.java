package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cronogramatecnicos")
public class cronogramaTecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCronogramaTecnico")
    private Integer idCronogramaTecnico;
    @OneToOne
    @JoinColumn(name = "Tecnico_idTecnico")
    private Tecnicos tecnico;

    @OneToOne
    @JoinColumn(name = "Cita_idCita")
    private Citas citas;

    @OneToOne
    @JoinColumn(name = "DisponibilidadCronograma_idDisponibilidadCronograma")
    private disponibilidadCronogramas disponibilidadCronograma;

    //Constructores
    public cronogramaTecnicos() {
    }

    public cronogramaTecnicos(Integer idCronogramaTecnico, Tecnicos tecnico, Citas citas, disponibilidadCronogramas disponibilidadCronograma) {
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

    public disponibilidadCronogramas getDisponibilidadCronograma() {
        return disponibilidadCronograma;
    }

    public void setDisponibilidadCronogramas(disponibilidadCronogramas disponibilidadCronograma) {
        this.disponibilidadCronograma = disponibilidadCronograma;
    }
}
