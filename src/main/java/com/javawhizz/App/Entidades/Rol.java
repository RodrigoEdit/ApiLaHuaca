package com.example.HotelHuaca.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codrol;
    private String Nombre;


    public Rol(){
        
    }

    public Rol(long idrol, String nombre) {
        codrol = idrol;
        Nombre = nombre;
    }
    public long getIdRol() {
        return codrol;
    }
    
    public void setIdRol(long idRo) {
        codrol = idRo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    
    
}
