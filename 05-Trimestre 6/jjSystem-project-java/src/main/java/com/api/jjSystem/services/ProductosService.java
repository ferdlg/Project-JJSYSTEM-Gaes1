package com.api.jjSystem.services;

import com.api.jjSystem.Repository.ProductosRepository;
import com.api.jjSystem.models.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public Productos createProducto(Productos producto)
    {
        return productosRepository.save(producto);
    }

    public Productos getProductoById(Integer idProducto)
    {
        Optional<Productos> optionalProductos = productosRepository.findById(idProducto);
        return optionalProductos.get();
    }

    public List<Productos> getAllProductos()
    {
        return productosRepository.findAll();
    }

    public void deleteProductos(Integer idProducto)
    {
        productosRepository.deleteById(idProducto);
    }

}
