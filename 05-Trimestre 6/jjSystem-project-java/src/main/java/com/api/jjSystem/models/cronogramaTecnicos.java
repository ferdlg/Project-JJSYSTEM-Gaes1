package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cronogramatecnicos")
public class cronogramaTecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCronogramaTecnico")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "Tecnico_idTecnico")
    private Tecnicos tecnico;

    @OneToOne
    @JoinColumn(name = "Cita_idCita")
    private Citas citas;

    @OneToMany
    @JoinColumn(name = "DisponibilidadCronograma_idDisponibilidadCronograma")
    private DisponibilidadCronograma disponibilidadCronograma;

    //Constructores
    public cronogramaTecnicos() {
    }

    public cronogramaTecnicos(Integer id, Tecnicos tecnico, Citas citas, DisponibilidadCronograma disponibilidadCronograma) {
        this.id = id;
        this.tecnico = tecnico;
        this.citas = citas;
        this.disponibilidadCronograma = disponibilidadCronograma;
    }
    //get y set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public DisponibilidadCronograma getDisponibilidadCronograma() {
        return disponibilidadCronograma;
    }

    public void setDisponibilidadCronograma(DisponibilidadCronograma disponibilidadCronograma) {
        this.disponibilidadCronograma = disponibilidadCronograma;
    }
}
