package com.javawhizz.App.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "datos_del_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idcli;
    private String Nombre;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String Dni;
    private String Telefono;
    private String Direccion;


    public Cliente(){

    }


    public Cliente(long idcli, String nombre, String apellido_paterno, String apellido_materno, String dni,
            String telefono, String direcccion) {
        Idcli = idcli;
        Nombre = nombre;
        Apellido_paterno = apellido_paterno;
        Apellido_materno = apellido_materno;
        Dni = dni;
        Telefono = telefono;
        Direccion = direcccion;
    }

    public long getIdcli() {
        return Idcli;
    }
    public void setIdcli(long idcli) {
        Idcli = idcli;
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
    public String getDirecccion() {
        return Direccion;
    }
    public void setDirecccion(String direcccion) {
        Direccion = direcccion;
    }

    
    
}
