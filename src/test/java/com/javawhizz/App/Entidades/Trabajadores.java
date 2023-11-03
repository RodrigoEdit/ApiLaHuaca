package com.example.HotelHuaca.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "trabajadores")
public class Trabajadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtra;
    private String Nombre;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String Dni;
    private String Telefono;
    private String Direccion;
    private String Fecha_Ingreso;
    private Double Salario;
    private String Usuario;
    private String Contra;
    private int codrol;

    public Trabajadores(){
        
    }

    public Trabajadores(long idt, String nombre, String apellido_paterno, String apellido_materno, String dni,
            String telefono, String direccion, String fecha_Ingreso, Double salario, String usuario, String contra,
            int codrol) {
        idtra = idt;
        Nombre = nombre;
        Apellido_paterno = apellido_paterno;
        Apellido_materno = apellido_materno;
        Dni = dni;
        Telefono = telefono;
        Direccion = direccion;
        Fecha_Ingreso = fecha_Ingreso;
        Salario = salario;
        Usuario = usuario;
        Contra = contra;
        this.codrol = codrol;
    }

    public long getIdt() {
        return idtra;
    }

    public void setIdt(long idt) {
        idtra = idt;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido_paterno() {
        return Apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        Apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return Apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        Apellido_materno = apellido_materno;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
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

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String contra) {
        Contra = contra;
    }

    public int getCodrol() {
        return codrol;
    }

    public void setCodrol(int codrol) {
        this.codrol = codrol;
    }

    
    


    

    
}
