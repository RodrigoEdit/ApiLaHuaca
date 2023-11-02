package com.javawhizz.App.Interfaz;

import org.springframework.data.repository.CrudRepository;

import com.javawhizz.App.Entidades.Cliente;



public interface ICliente extends CrudRepository<Cliente,Long> {
    
}
