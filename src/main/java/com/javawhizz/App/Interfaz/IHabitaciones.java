package com.javawhizz.App.Interfaz;

import org.springframework.data.repository.CrudRepository;

import com.javawhizz.App.Entidades.Habitaciones;



public interface IHabitaciones extends CrudRepository<Habitaciones,Long> {
    
}
