package com.example.HotelHuaca.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.HotelHuaca.Entidades.Categoria;
import com.example.HotelHuaca.Servicios.ServiceCategoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private ServiceCategoria sc;

    @GetMapping("/list")
    public List<Categoria> listarcategorias() {
        return sc.listarcategorias();
    }

    @PostMapping("/add")
    public Categoria guardarcategorias(@RequestBody Categoria c) {
        return sc.guardarCategoria(c);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> editarCategoria(@PathVariable Long id, @RequestBody Categoria c) {

        Categoria categoriaExistente = sc.buscarCategoriaPorId(id).orElse(null);

        if (categoriaExistente != null) {

            categoriaExistente.setCategoria(c.getCategoria());
            categoriaExistente.setDescripcion(c.getDescripcion()); 
            sc.guardarCategoria(categoriaExistente);
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) {
        Categoria categoriaExistente = sc.buscarCategoriaPorId(id).orElse(null);

        if (categoriaExistente != null) {
            sc.eliminarCategoria(id);
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }
}
