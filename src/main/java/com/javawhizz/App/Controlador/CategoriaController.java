package com.javawhizz.App.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.javawhizz.App.Entidades.Categoria;
import com.javawhizz.App.Servicios.ServiceCategoria;



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

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCategoriaPorId(@PathVariable long id) {
        return sc.buscarCategoriaPorId(id)
                .map(categoria -> ResponseEntity.ok(categoria))
                .orElse(ResponseEntity.notFound().build());
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
