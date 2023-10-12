package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "actividadcronogramatecnicos")
public class ActividadesCronogramaTecnicos {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idActividadCronogramaTecnico")
   private Integer id;

   private String nombreActividad;

   //contructor vacio
    public ActividadesCronogramaTecnicos() {
    }
    //Contructor->acceso a datos
    public ActividadesCronogramaTecnicos(Integer id, String nombreActividad) {
        this.id = id;
        this.nombreActividad = nombreActividad;
    }
    //metodos get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
}
