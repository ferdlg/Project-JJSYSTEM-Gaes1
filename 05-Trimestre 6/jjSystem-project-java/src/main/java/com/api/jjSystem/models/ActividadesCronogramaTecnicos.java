package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "actividadesCronogramaTecnicos")
public class ActividadesCronogramaTecnicos {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idActividadCronogramaTecnico")
   private Integer idActividadCronogramaTecnico;
   @Column(name="nombreActividad")
   private String nombreActividad;

   //contructor vacio
    public ActividadesCronogramaTecnicos() {
    }
    //Contructor->acceso a datos
    public ActividadesCronogramaTecnicos(Integer idActividadCronogramaTecnico, String nombreActividad) {
        this.idActividadCronogramaTecnico = idActividadCronogramaTecnico;
        this.nombreActividad = nombreActividad;
    }
    //metodos get y set
    public Integer getId() {
        return idActividadCronogramaTecnico;
    }

    public void setId(Integer idActividadCronogramaTecnico) {
        this.idActividadCronogramaTecnico = idActividadCronogramaTecnico;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
}
