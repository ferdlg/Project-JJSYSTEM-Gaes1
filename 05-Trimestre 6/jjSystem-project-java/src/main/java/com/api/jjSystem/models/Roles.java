package com.api.jjSystem.models;

import jakarta.persistence.*;

//Notaciones para mapear la base de datos e indicarle a la amquina con que tabla estamos trbajando
@Entity
@Table(name = "roles")
public class Roles {

    //atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer id;
    private String nombreRol;

    //Constructor vacio
    public Roles() {
    }
    //Constructor con los campos de la tabla acceder a los datos de la tabla
    public Roles(Integer id, String nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;
    }

    //Metodos Get y Set para cada campo
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
