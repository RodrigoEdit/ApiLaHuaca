package com.javawhizz.App.Servicios;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawhizz.App.Entidades.Reserva;
import com.javawhizz.App.Interfaz.IReserva;



@Service
public class ServiceReserva {
    @Autowired
    private IReserva iReserva;

    public Reserva guardareserva(Reserva reserva){
        return iReserva.save(reserva);
    }

    public List<Reserva> listarreserva(){
        return (List<Reserva>)iReserva.findAll();
    }

    public Optional<Reserva> buscarreservaporId(long id){
        return iReserva.findById(id);
    }

    public Reserva editarreserva(Reserva reserva){
        return iReserva.save(reserva);
    }

    public void eliminarreserva(long id){
        iReserva.deleteById(id);
    }

    public List<Object[]> buscarReservasDetallePorIdCliente(Long idCliente) {
        return (List<Object[]>)iReserva.findByClienteId(idCliente);
    }

   
   
}
