package com.example.HotelHuaca.Controlador;

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

import com.example.HotelHuaca.Entidades.Rol;
import com.example.HotelHuaca.Servicios.ServiceRol;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private ServiceRol sh;

    @GetMapping("/list")
    public List<Rol> listarRol(){
        return sh.listarrol();
    }

    @PostMapping("/add")
    public Rol guardarRol(@RequestBody Rol c){
        return sh.guardarol(c);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> editarRol(@PathVariable Long id , @RequestBody Rol h)
    {
        Rol rol = sh.buscarrolporId(id).orElse(null);
        if(rol != null){
            rol.setNombre(h.getNombre());
            sh.guardarol(rol);
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarRol(@PathVariable Long id){
        Rol rol = sh.buscarrolporId(id).orElse(null);
        if(rol != null){
            sh.eliminarreserva(id);
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }
}
