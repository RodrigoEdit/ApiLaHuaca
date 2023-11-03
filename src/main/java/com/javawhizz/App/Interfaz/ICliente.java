package com.example.HotelHuaca.Interfaz;

import org.springframework.data.repository.CrudRepository;

import com.example.HotelHuaca.Entidades.Cliente;

public interface ICliente extends CrudRepository<Cliente,Long> {
    
}
