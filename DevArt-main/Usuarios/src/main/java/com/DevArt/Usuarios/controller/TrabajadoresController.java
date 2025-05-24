package com.DevArt.Usuarios.controller;

import com.DevArt.Usuarios.model.Usuarios;
import com.DevArt.Usuarios.service.TrabajadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
@RestController
@RequestMapping("/api/v1/trabajadores")
public class TrabajadoresController {
    @Autowired 
    private TrabajadoresService trabajadoresService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> getTrabajadores() {
        return ResponseEntity.ok(trabajadoresService.getAllTrabajadores());
    }

    @GetMapping("/existe/{rut}")
    public ResponseEntity<Boolean> existeTrabajador(@PathVariable("rut") String rut) {
        List<Usuarios> trabajadores = trabajadoresService.getTrabajadorByRut(rut);
        return ResponseEntity.ok(!trabajadores.isEmpty());
    }
    
    @PostMapping
    public ResponseEntity<Usuarios> agregarTrabajador(@RequestBody Usuarios trabajador) {
        Usuarios nuevoTrabajador = trabajadoresService.agregarTrabajador(trabajador);
        return ResponseEntity.ok(nuevoTrabajador);
    }

    @PutMapping("/{rut}")
    public ResponseEntity<Usuarios> actualizarTrabajador(@PathVariable("rut") String rut, @RequestBody Usuarios trabajadorActualizado) {
        Usuarios trabajador = trabajadoresService.actualizarTrabajador(rut, trabajadorActualizado);
        if (trabajador != null) {
            return ResponseEntity.ok(trabajador);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> eliminarTrabajador(@PathVariable("rut") String rut) {
        trabajadoresService.eliminarTrabajador(rut);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Usuarios>> getTrabajadorByRut(@PathVariable("rut") String rut) {
        List<Usuarios> trabajadores = trabajadoresService.getTrabajadorByRut(rut);
        if (trabajadores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajadores);
    }

    @GetMapping("/primer-nombre/{primerNombre}")
    public ResponseEntity<List<Usuarios>> getTrabajadorByPrimerNombre(@PathVariable("primerNombre") String primerNombre) {
        List<Usuarios> trabajadores = trabajadoresService.getTrabajadorByPrimerNombre(primerNombre);
        if (trabajadores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajadores);
    }

    @GetMapping("/segundo-nombre/{segundoNombre}")
    public ResponseEntity<List<Usuarios>> getTrabajadorBySegundoNombre(@PathVariable("segundoNombre") String segundoNombre) {
        List<Usuarios> trabajadores = trabajadoresService.getTrabajadorBySegundoNombre(segundoNombre);
        if (trabajadores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajadores);
    }

}
