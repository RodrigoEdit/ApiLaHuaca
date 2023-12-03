package com.javawhizz.App.Controlador;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.javawhizz.App.Entidades.Reserva;
import com.javawhizz.App.Servicios.ServiceReserva;



@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ServiceReserva sh;

    @GetMapping("/list")
    public List<Reserva> listaReservas(){
        return sh.listarreserva();
    }

    @PostMapping("/add")
    public Reserva guardarReserva(@RequestBody Reserva c){
        return sh.guardareserva(c);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> editarReserva(@PathVariable Long id , @RequestBody Reserva h)
    {
        Reserva reservaex = sh.buscarreservaporId(id).orElse(null);
        if(reservaex != null){
            reservaex.setIdh(h.getIdh());
            reservaex.setIdcli(h.getIdcli());
            reservaex.setFecha_fin(h.getFecha_fin());
            reservaex.setFecha_inicio(h.getFecha_inicio());
            reservaex.setIdtra(h.getIdtra());
            reservaex.setEstado(h.getEstado());
            sh.guardareserva(reservaex);
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarHabitacion(@PathVariable Long id){
        Reserva reserva = sh.buscarreservaporId(id).orElse(null);
        if(reserva != null){
            sh.eliminarreserva(id);
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false");
        }
    }



    @GetMapping("/reservaxcli/{idCliente}")
    public ResponseEntity<?> getreservaxhabi(@PathVariable Long idCliente) {
        try {
            List<Object[]> reserva = sh.buscarReservasDetallePorIdCliente(idCliente);
            List<Map<String, Object>> pedidosList = new ArrayList<>();

            for (Object[] pedido : reserva) {
                Map<String, Object> pedidoMap = new LinkedHashMap<>();
                pedidoMap.put("fecha_inicio", pedido[0]);
                pedidoMap.put("fecha_fin", pedido[1]);
                pedidoMap.put("estado", pedido[2]);
                pedidoMap.put("Numero", pedido[3]);
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
