package com.example.HotelHuaca.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String Nombre;


    public Rol(){
        
    }

    public Rol(long idrol, String nombre) {
        codigo = idrol;
        Nombre = nombre;
    }
    public long getIdRol() {
        return codigo;
    }
    
    public void setIdRol(long idRo) {
        codigo = idRo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    
    
}
