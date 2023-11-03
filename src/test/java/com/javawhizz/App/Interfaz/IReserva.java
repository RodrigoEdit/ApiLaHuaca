package com.example.HotelHuaca.Interfaz;

import org.springframework.data.repository.CrudRepository;

import com.example.HotelHuaca.Entidades.Reserva;

public interface IReserva extends CrudRepository<Reserva,Long> {
    
}
