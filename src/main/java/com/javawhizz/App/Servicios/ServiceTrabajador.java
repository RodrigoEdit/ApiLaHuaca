package com.javawhizz.App.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawhizz.App.Entidades.Trabajadores;
import com.javawhizz.App.Interfaz.ITrabajador;



@Service
public class ServiceTrabajador {
    @Autowired
    private ITrabajador iTrabajador;

    public Trabajadores guardatrabajador(Trabajadores tra){
        return iTrabajador.save(tra);
    }

    public List<Trabajadores> listartrabajador(){
        return (List<Trabajadores>)iTrabajador.findAll();
    }

    public Optional<Trabajadores> buscartrabajadorporId(long id){
        return iTrabajador.findById(id);
    }

    public Trabajadores editartrabajador(Trabajadores tra){
        return iTrabajador.save(tra);
    }

    public void eliminartrabajador(long id){
        iTrabajador.deleteById(id);
    }
}
