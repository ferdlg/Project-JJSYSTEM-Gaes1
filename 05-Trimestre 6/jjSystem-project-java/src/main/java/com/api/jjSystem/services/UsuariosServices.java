package com.api.jjSystem.services;

import com.api.jjSystem.Repository.UsuariosRepository;
import com.api.jjSystem.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuariosServices {
    @Autowired
    private UsuariosRepository usuariosRepository;
    public Usuarios createUsuario(Usuarios usuarios){return usuariosRepository.save(usuarios); }
    public Usuarios getUsuarioByDocument(Integer numeroDocumento)
    {
        Optional<Usuarios> usuarios = usuariosRepository.findById(numeroDocumento);
        return usuarios.get();
    }

    public List<Usuarios> getAllUsuarios()
    {
        return usuariosRepository.findAll();
    }
    public void deleteUsuariosByDocument(Integer numeroDocumento)
    {
        usuariosRepository.deleteById(numeroDocumento);
    }

}
