package com.javawhizz.App.Interfaz;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javawhizz.App.Entidades.Reserva;


public interface IReserva extends CrudRepository<Reserva,Long> {
    @Query(value ="SELECT h.fecha_inicio, h.fecha_fin, h.estado, n.Numero FROM reserva h INNER JOIN habitaciones_disponibles n ON h.Idh = n.Idh "+
            "WHERE h.idcli = :clienteId", nativeQuery=true)
    List<Object[]> findByClienteId(@Param("clienteId") Long clienteId);
}
