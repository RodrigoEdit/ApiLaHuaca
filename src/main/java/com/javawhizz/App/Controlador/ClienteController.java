package com.javawhizz.App.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.javawhizz.App.Entidades.Cliente;
import com.javawhizz.App.Servicios.ServiceCliente;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ServiceCliente sc;

    @GetMapping("/list")
    public List<Cliente> listarclientes() {
        return sc.listarclientes();
    }

    @PostMapping("/add")
    public Cliente guardarcliente(@RequestBody Cliente c) {
        return sc.guardarclientes(c);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> editarcliente(@PathVariable Long id, @RequestBody Cliente c) {

        Cliente clienteexistente = sc.buscarclientePorId(id).orElse(null);

        if (clienteexistente != null) {

            clienteexistente.setNombre(c.getNombre());
            clienteexistente.setApellido_paterno(c.getApellido_paterno());
            clienteexistente.setApellido_materno(c.getApellido_materno());
            clienteexistente.setDni(c.getDni());
            clienteexistente.setTelefono(c.getTelefono());
            clienteexistente.setDireccion(c.getDireccion());
            clienteexistente.setUsuario(c.getUsuario());
            clienteexistente.setContra(c.getContra());
            clienteexistente.setCodrol(c.getCodrol());
            sc.guardarclientes(clienteexistente);
            return ResponseEntity.ok("true");
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) {
        Cliente clienteexistente = sc.buscarclientePorId(id).orElse(null);

        if (clienteexistente != null) { 
            sc.eliminarcliente(id);
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = sc.buscarclientePorId(id);

        return clienteOptional
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
