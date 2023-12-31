package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroDocumento")
    private BigInteger numeroDocumento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "numeroContacto")
    private BigInteger numeroContacto;
    @OneToOne
    @JoinColumn(name = "idRol")
    private Roles roles;
    @ManyToOne
    @JoinColumn(name = "idEstadoUsuario")
    private EstadosUsuarios estadosUsuarios;

    //Constructores

    public Usuarios() {
    }

    public Usuarios(BigInteger numeroDocumento, String nombre, String apellido, String email, String password, BigInteger numeroContacto, Roles roles, EstadosUsuarios estadosUsuarios) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.numeroContacto = numeroContacto;
        this.roles = roles;
        this.estadosUsuarios = estadosUsuarios;
    }

    //Get y set

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(BigInteger numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public EstadosUsuarios getEstadosUsuarios() {
        return estadosUsuarios;
    }

    public void setEstadosUsuarios(EstadosUsuarios estadosUsuarios) {
        this.estadosUsuarios = estadosUsuarios;
    }
}
