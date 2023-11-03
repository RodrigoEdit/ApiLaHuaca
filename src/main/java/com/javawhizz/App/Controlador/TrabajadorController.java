package com.javawhizz.App.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javawhizz.App.Entidades.Trabajadores;
import com.javawhizz.App.Servicios.ServiceTrabajador;



@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    private ServiceTrabajador sc;

    @GetMapping("/list")
    public List<Trabajadores> listartrabajadores() {
        return sc.listartrabajador();
    }

    @PostMapping("/add")
    public Trabajadores guardartrabajadores(@RequestBody Trabajadores c) {
        return sc.guardatrabajador(c);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> editartrabajadores(@PathVariable Long id, @RequestBody Trabajadores c) {

        Trabajadores traexist = sc.buscartrabajadorporId(id).orElse(null);

        if (traexist != null) {

            traexist.setNombre(c.getNombre());
            traexist.setApellido_materno(c.getApellido_materno());
            traexist.setApellido_paterno(c.getApellido_paterno());
            traexist.setDni(c.getDni());
            traexist.setTelefono(c.getTelefono());
            traexist.setDireccion(c.getDireccion());
            traexist.setFecha_Ingreso(c.getFecha_Ingreso());
            traexist.setSalario(c.getSalario());
            traexist.setContra(c.getContra());
            traexist.setUsuario(c.getUsuario());
            traexist.setCodrol(c.getCodrol());
            sc.guardatrabajador(traexist);
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminartrabajadores(@PathVariable Long id) {
        Trabajadores traexist = sc.buscartrabajadorporId(id).orElse(null);

        if (traexist != null) {
            sc.eliminartrabajador(id);
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }
}
