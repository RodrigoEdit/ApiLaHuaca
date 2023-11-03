package com.javawhizz.App.Interfaz;


import org.springframework.data.repository.CrudRepository;

import com.javawhizz.App.Entidades.Reserva;


public interface IReserva extends CrudRepository<Reserva,Long> {
    
}
