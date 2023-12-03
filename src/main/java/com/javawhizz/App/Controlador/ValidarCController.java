package com.javawhizz.App.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ValidarCController {
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/Login/validarCliente/{correo}/{contrasena}")
    public Map<String, Integer> validarCliente(
            @PathVariable String correo,
            @PathVariable String contrasena) {

        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("ValidarCliente");
        procedure.registerStoredProcedureParameter("pUsuario", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("pContra", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("cliente_id", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("rol_id", Integer.class, ParameterMode.OUT);

        procedure.setParameter("pUsuario", correo);
        procedure.setParameter("pContra", contrasena);

        procedure.execute();

        Integer clienteId = (Integer) procedure.getOutputParameterValue("cliente_id");
        Integer rolId = (Integer) procedure.getOutputParameterValue("rol_id");

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("cliente_id", clienteId);
        resultMap.put("rol_id", rolId);

        return resultMap;
    }
}
