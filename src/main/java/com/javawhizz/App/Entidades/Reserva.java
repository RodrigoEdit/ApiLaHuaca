package com.javawhizz.App.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idr;
    private String fecha_inicio;
    private String fecha_fin;
    private int Idcli;
    private int Idh;
    private int idtra;
    private String estado;


    public Reserva(){
        
    }


    public Reserva(long idr, String fecha_inicio, String fecha_fin, int idcli, int idh, int idtra, String estado) {
        Idr = idr;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        Idcli = idcli;
        Idh = idh;
        this.idtra = idtra;
        this.estado = estado;
    }


    public long getIdr() {
        return Idr;
    }


    public void setIdr(long idr) {
        Idr = idr;
    }


    public String getFecha_inicio() {
        return fecha_inicio;
    }


    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }


    public String getFecha_fin() {
        return fecha_fin;
    }


    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


    public int getIdcli() {
        return Idcli;
    }


    public void setIdcli(int idcli) {
        Idcli = idcli;
    }


    public int getIdh() {
        return Idh;
    }


    public void setIdh(int idh) {
        Idh = idh;
    }


    public int getIdtra() {
        return idtra;
    }


    public void setIdtra(int idtra) {
        this.idtra = idtra;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    

    

}
