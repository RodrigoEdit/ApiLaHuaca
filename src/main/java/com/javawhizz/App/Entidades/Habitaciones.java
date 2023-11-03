package com.example.HotelHuaca.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones_disponibles")
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idh;
    private int Idc;
    private int Numero;
    private int Precio;
    private String Estado;


    public Habitaciones(){
        
    }

    public Habitaciones(long idh, int idc, int numero, int precio, String estado) {
        Idh = idh;
        Idc = idc;
        Numero = numero;
        Precio = precio;
        Estado = estado;
    }

    public long getIdh() {
        return Idh;
    }
    public void setIdh(long idh) {
        Idh = idh;
    }
    public int getIdc() {
        return Idc;
    }
    public void setIdc(int idc) {
        Idc = idc;
    }
    public int getNumero() {
        return Numero;
    }
    public void setNumero(int numero) {
        Numero = numero;
    }
    public int getPrecio() {
        return Precio;
    }
    public void setPrecio(int precio) {
        Precio = precio;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }

    
    
}
