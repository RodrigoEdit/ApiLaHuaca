package com.javawhizz.App.Entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "datos_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcli;
    private String Nombre;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String Dni;
    private String Telefono;
    private String Direccion;
    private String Usuario;
    private String Contra;
    private int codrol;


    public Cliente(){

    }


    public Cliente(long idcli, String nombre, String apellido_paterno, String apellido_materno, String dni,
            String telefono, String direccion, String usuario, String contra, int codrol) {
        this.idcli = idcli;
        Nombre = nombre;
        Apellido_paterno = apellido_paterno;
        Apellido_materno = apellido_materno;
        Dni = dni;
        Telefono = telefono;
        Direccion = direccion;
        Usuario = usuario;
        Contra = contra;
        this.codrol = codrol;
    }


    public long getIdcli() {
        return idcli;
    }


    public void setIdcli(long idcli) {
        this.idcli = idcli;
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
