package com.DevArt.Transacciones.controller;

import com.DevArt.Transacciones.model.Transacciones;
import com.DevArt.Transacciones.service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transacciones")
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionesService;

    @PostMapping
    public ResponseEntity<Transacciones> crearTransaccion(@RequestBody Transacciones transaccion) {
        try {
            Transacciones nueva = transaccionesService.crearTransaccion(transaccion);
            return ResponseEntity.ok(nueva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Transacciones>> listarTodas() {
        return ResponseEntity.ok(transaccionesService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacciones> buscarPorId(@PathVariable Long id) {
        Optional<Transacciones> trans = transaccionesService.obtenerPorId(id);
        return trans.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{rut}")
    public ResponseEntity<List<Transacciones>> buscarPorUsuario(@PathVariable String rut) {
        return ResponseEntity.ok(transaccionesService.obtenerPorRut(rut));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransaccion(@PathVariable Long id) {
        transaccionesService.eliminarTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}
