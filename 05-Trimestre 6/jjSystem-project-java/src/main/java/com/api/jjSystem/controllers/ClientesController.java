package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Citas;
import com.api.jjSystem.models.Clientes;
import com.api.jjSystem.services.CitasService;
import com.api.jjSystem.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/clientes")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;
    @PostMapping
    public Clientes createCliente(Clientes clientes)
    {
        return clientesService.createCliente(clientes);
    }
    @GetMapping
    public List<Clientes> getAllClientes()
    {
        return clientesService.getAllClientes();
    }
    @GetMapping("idCliente")
    public Clientes getClienteById(@PathVariable Integer idCliente)
    {
        return clientesService.getClienteById(idCliente);
    }
    @DeleteMapping
    public void deleteClientebyId(@PathVariable("idCliente")Integer idCliente)
    {
        clientesService.deleteClienteById(idCliente);
    }
}
