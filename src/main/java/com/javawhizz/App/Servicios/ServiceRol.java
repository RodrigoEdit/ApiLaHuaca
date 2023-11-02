package com.javawhizz.App.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawhizz.App.Entidades.Rol;
import com.javawhizz.App.Interfaz.IRol;


@Service
public class ServiceRol {
    @Autowired
    private IRol iRol;

     public Rol guardarol(Rol rol){
        return iRol.save(rol);
    }

    public List<Rol> listarrol(){
        return (List<Rol>)iRol.findAll();
    }

    public Optional<Rol> buscarrolporId(long id){
        return iRol.findById(id);
    }

    public Rol editarrol(Rol rol){
        return iRol.save(rol);
    }

    public void eliminarreserva(long id){
        iRol.deleteById(id);
    }
}
