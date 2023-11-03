package com.example.HotelHuaca.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@RestController
public class ValidacionTController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/Login/validarTrabajador/{correo}/{contrasena}")
    public Integer  validarTrabajador(
            @PathVariable String correo,
            @PathVariable String contrasena) {

        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("ValidarTrabajador");
        procedure.registerStoredProcedureParameter("Correo", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("Clave", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("resultado", Integer.class, ParameterMode.OUT);

        procedure.setParameter("Correo", correo);
        procedure.setParameter("Clave", contrasena);

        procedure.execute();

        Integer resultado = (Integer) procedure.getOutputParameterValue("resultado");

        return resultado;
    }
}
