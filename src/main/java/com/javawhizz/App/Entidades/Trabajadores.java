package com.javawhizz.App.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "trabajadores")
public class Trabajadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idt;
    private String Nombre;
    private String Apellido_PATERNO;
    private String Apellido_MATERNO;
    private String dnit;
    private String Fecha_Nacimiento;
    private String Fecha_Ingreso;
    private Double Salario;


    public Trabajadores(){
        
    }


    public Trabajadores(long idt, String nombre, String apellido_PATERNO, String apellido_MATERNO, String dnit,
            String fecha_Nacimiento, String fecha_Ingreso, Double salario) {
        Idt = idt;
        Nombre = nombre;
        Apellido_PATERNO = apellido_PATERNO;
        Apellido_MATERNO = apellido_MATERNO;
        this.dnit = dnit;
        Fecha_Nacimiento = fecha_Nacimiento;
        Fecha_Ingreso = fecha_Ingreso;
        Salario = salario;
    }
    public long getIdt() {
        return Idt;
    }
    public void setIdt(long idt) {
        Idt = idt;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellido_PATERNO() {
        return Apellido_PATERNO;
    }
    public void setApellido_PATERNO(String apellido_PATERNO) {
        Apellido_PATERNO = apellido_PATERNO;
    }
    public String getApellido_MATERNO() {
        return Apellido_MATERNO;
    }
    public void setApellido_MATERNO(String apellido_MATERNO) {
        Apellido_MATERNO = apellido_MATERNO;
    }
    public String getDnit() {
        return dnit;
    }
    public void setDnit(String dnit) {
        this.dnit = dnit;
    }
    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }
    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }
    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }
    public void setFecha_Ingreso(String fecha_Ingreso) {
        Fecha_Ingreso = fecha_Ingreso;
    }
    public Double getSalario() {
        return Salario;
    }
    public void setSalario(Double salario) {
        Salario = salario;
    }

    
}
