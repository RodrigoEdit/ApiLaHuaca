package com.javawhizz.App.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 // Asegúrate de importar la clase de Usuario

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@RestController
public class ValidacionController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/Login/validarUsuario/{correo}/{contrasena}")
    public boolean validarUsuario(
            @PathVariable String correo,
            @PathVariable String contrasena) {

        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("Validarusuario");
        procedure.registerStoredProcedureParameter("Correo", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("Clave", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("resultado", Integer.class, ParameterMode.OUT);

        procedure.setParameter("Correo", correo);
        procedure.setParameter("Clave", contrasena);

        procedure.execute();

        Integer resultado = (Integer) procedure.getOutputParameterValue("resultado");

        // El resultado es verdadero si el procedimiento devuelve 1 y falso si devuelve 0
        return resultado != null && resultado == 1;
    }
}