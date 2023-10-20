package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Usuarios;
import com.api.jjSystem.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public Usuarios createUsuario(Usuarios usuarios)
    {
        return usuariosService.createUsuario(usuarios);
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios()
    {
        return usuariosService.getAllUsuarios();
    }

    @GetMapping("{numeroDocumento}")
    public Usuarios buscarUsuariosById(@PathVariable Integer numeroDocumento)
    {
        return usuariosService.getUsuarioByDocument(numeroDocumento);
    }

    @DeleteMapping("{numeroDocumento}")
    public void deleteUsuarioById(@PathVariable("numeroDocumento") Integer numeroDocumento)
    {
        usuariosService.getUsuarioByDocument(numeroDocumento);
    }
}