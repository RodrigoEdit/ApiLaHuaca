package com.example.HotelHuaca.Interfaz;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.HotelHuaca.Entidades.Usuario;

public interface IUsuario extends CrudRepository<Usuario,Long> {
    
    @Procedure(name = "Validarusuario")
    Boolean validarUsuario(
            @Param("Correo") String correo,
            @Param("Clave") String clave,
            @Param("resultado") Boolean resultado);
    
}
