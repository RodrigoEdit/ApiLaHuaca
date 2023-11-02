package com.javawhizz.App.Interfaz;

import org.springframework.data.repository.CrudRepository;

import com.javawhizz.App.Entidades.Categoria;



public interface ICategoria extends CrudRepository<Categoria, Long> {
    
}
