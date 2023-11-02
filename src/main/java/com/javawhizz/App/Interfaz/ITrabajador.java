package com.javawhizz.App.Interfaz;
import org.springframework.data.repository.CrudRepository;

import com.javawhizz.App.Entidades.Trabajadores;



public interface ITrabajador extends CrudRepository<Trabajadores,Long> {
    
}
