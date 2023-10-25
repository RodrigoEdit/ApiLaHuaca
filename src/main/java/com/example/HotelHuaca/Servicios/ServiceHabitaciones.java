package com.example.HotelHuaca.Servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelHuaca.Entidades.Habitaciones;
import com.example.HotelHuaca.Interfaz.IHabitaciones;

@Service
public class ServiceHabitaciones {
    @Autowired
    private IHabitaciones iHabitaciones;

    public Habitaciones guardarhabitaciones(Habitaciones habitaciones){
        return iHabitaciones.save(habitaciones);
    }

    public List<Habitaciones> listarhabitaciones(){
        return (List<Habitaciones>)iHabitaciones.findAll();
    }

    public Optional<Habitaciones> buscarhabitacionesporId(long id){
        return iHabitaciones.findById(id);
    }

    public Habitaciones editarhabitaciones(Habitaciones habitaciones){
        return iHabitaciones.save(habitaciones);
    }

    public void eliminarhabitaciones(long id){
        iHabitaciones.deleteById(id);
    }
}
