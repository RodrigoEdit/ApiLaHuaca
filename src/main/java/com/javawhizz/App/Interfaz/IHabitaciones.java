package com.javawhizz.App.Interfaz;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.javawhizz.App.Entidades.Habitaciones;

public interface IHabitaciones extends CrudRepository<Habitaciones, Long> {
    @Query(value = "SELECT h.Idh , h.Idc, h.Numero, h.Precio, h.Estado , c.Categoria from habitaciones_disponibles h inner join categorias c on h.Idc = c.Idc", nativeQuery=true)
    List<Object[]>Listarallcon();
}
