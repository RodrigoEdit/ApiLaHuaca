package com.javawhizz.App.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idc;
    private String Categoria;
    private String Descripcion;

    

    public Categoria(){
        
    }


    public Categoria(long idc, String categoria, String descripcion) {
        Idc = idc;
        Categoria = categoria;
        Descripcion = descripcion;
    }

    public long getIdc() {
        return Idc;
    }
    public void setIdc(long idc) {
        Idc = idc;
    }
    public String getCategoria() {
        return Categoria;
    }
    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    
}
