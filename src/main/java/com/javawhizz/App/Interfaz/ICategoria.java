package com.example.HotelHuaca.Interfaz;

import org.springframework.data.repository.CrudRepository;

import com.example.HotelHuaca.Entidades.Categoria;

public interface ICategoria extends CrudRepository<Categoria, Long> {
    
}
