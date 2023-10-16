package com.api.jjSystem.services;

import com.api.jjSystem.Repository.ClientesRepository;
import com.api.jjSystem.models.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;
    public Clientes createCliente(Clientes clientes)
    {
        return clientesRepository.save(clientes);
    }
    public Clientes getClienteById(Integer idCliente)
    {
        Optional<Clientes> clientes= clientesRepository.findById(idCliente);
        return clientes.get();
    }
    public List<Clientes> getAllClientes()
    {
        return clientesRepository.findAll();
    }
    public void deleteClienteById(Integer idCliente)
    {
        clientesRepository.deleteById(idCliente);
    }
}
