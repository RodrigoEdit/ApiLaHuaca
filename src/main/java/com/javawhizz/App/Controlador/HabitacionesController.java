package com.javawhizz.App.Controlador;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

import com.javawhizz.App.Entidades.Habitaciones;
import com.javawhizz.App.Servicios.ServiceHabitaciones;

import java.util.Map;


@RestController
@RequestMapping("/habitaciones")
public class HabitacionesController {
    @Autowired
    private ServiceHabitaciones sh;

    @GetMapping("/list")
    public List<Habitaciones> listarhabitacione(){
        return sh.listarhabitaciones();
    }

    @PostMapping("/add")
    public Habitaciones guardarHabitaciones(@RequestBody Habitaciones c){
        return sh.guardarhabitaciones(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerhabitacionPorId(@PathVariable long id) {
        return sh.buscarhabitacionesporId(id)
                .map(habitacion -> ResponseEntity.ok(habitacion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> editarHabitaciones(@PathVariable Long id , @RequestBody Habitaciones h)
    {
        Habitaciones habitacionEx = sh.buscarhabitacionesporId(id).orElse(null);
        if(habitacionEx != null){
            habitacionEx.setIdh(h.getIdh());
            habitacionEx.setIdc(h.getIdc());
            habitacionEx.setNumero(h.getNumero());
            habitacionEx.setPrecio(h.getPrecio());
            habitacionEx.setEstado(h.getEstado());
            sh.guardarhabitaciones(habitacionEx);
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarHabitacion(@PathVariable Long id){
        Habitaciones habitaciones = sh.buscarhabitacionesporId(id).orElse(null);
        if(habitaciones != null){
            sh.eliminarhabitaciones(id);
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @GetMapping("/listarall")
    public ResponseEntity<?> getAllNuevo() {
        try {
            List<Object[]> habitacion = sh.Listarallcon();

            List<Map<String, Object>> pedidosList = new ArrayList<>();

            for (Object[] pedido : habitacion) {
                Map<String, Object> pedidoMap = new LinkedHashMap<>();
                pedidoMap.put("Idh", pedido[0]);
                pedidoMap.put("Idc", pedido[1]);
                pedidoMap.put("Numero", pedido[2]);
                pedidoMap.put("Precio", pedido[3]);
                pedidoMap.put("Estado", pedido[4]);
                pedidoMap.put("Categoria", pedido[5]);
                pedidosList.add(pedidoMap);
            }

            return ResponseEntity.ok(pedidosList);
        } catch (Exception e) {
            Map<String, Object> errorRespuesta = new LinkedHashMap<>();
            errorRespuesta.put("status", 500);
            errorRespuesta.put("statusMessage", "Error en el servidor: " + e.getMessage());
            return ResponseEntity.status(500).body(errorRespuesta);
        }
    }

}
