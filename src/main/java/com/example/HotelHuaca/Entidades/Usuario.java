package com.example.HotelHuaca.Entidades;

import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdUsuario;
    private int IdRo;
    private String NombreUsuario;
    private String Correo;
    private String Clave;



    
    public Usuario(){
        
    }

    public Usuario(long idUsuario, int idRo, String nombreUsuario, String correo, String clave) {
        IdUsuario = idUsuario;
        IdRo = idRo;
        NombreUsuario = nombreUsuario;
        Correo = correo;
        Clave = clave;
    }

    public long getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(long idUsuario) {
        IdUsuario = idUsuario;
    }
    public int getIdRo() {
        return IdRo;
    }
    public void setIdRo(int idRo) {
        IdRo = idRo;
    }
    public String getNombreUsuario() {
        return NombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }
    public String getClave() {
        return Clave;
    }
    public void setClave(String clave) {
        Clave = clave;
    }


    

    
}
