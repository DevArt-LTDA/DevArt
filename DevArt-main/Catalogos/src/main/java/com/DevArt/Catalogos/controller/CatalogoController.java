package com.DevArt.Catalogos.controller;
import com.DevArt.Catalogos.controller.CatalogoController;
//Traspaso a main
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.DevArt.Catalogos.service.CatalogoService;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import com.DevArt.Catalogos.model.Catalogo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/{id}")
    public ResponseEntity<Catalogo> getCatalogoById(@PathVariable("id") int id) {
        return catalogoService.getCatalogoByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Catalogo>> getCatalogoByNombre(@PathVariable("nombre") String nombre) {
        List<Catalogo> catalogos = catalogoService.getCatalogoByNombre(nombre);
        if (catalogos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catalogos);
    }
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Catalogo>> getCatalogoByTipo(@PathVariable("tipo") String tipo) {
        List<Catalogo> catalogos = catalogoService.getCatalogoByTipo(tipo);
        if (catalogos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catalogos);
    }
    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<List<Catalogo>> getCatalogoByDescripcion(@PathVariable("descripcion") String descripcion) {
        List<Catalogo> catalogos = catalogoService.getCatalogoByDescripcion(descripcion);
        if (catalogos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catalogos);
    }
    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<Catalogo>> getCatalogoByPrecio(@PathVariable("precio") int precio) {
        List<Catalogo> catalogos = catalogoService.getCatalogoByPrecio(precio);
        if (catalogos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catalogos);
    }
    @GetMapping("/fecha-despliegue/{fechaDespliegue}")
    public ResponseEntity<List<Catalogo>> getCatalogoByFechaDespliegue(@PathVariable("fechaDespliegue") String fechaDespliegue) {
        List<Catalogo> catalogos = catalogoService.getCatalogoByFechaDespliegue(LocalDateTime.parse(fechaDespliegue));
        if (catalogos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catalogos);
    }
    @GetMapping("/estado-desarrollo/{estadoDesarrollo}")
    public ResponseEntity<List<Catalogo>> getCatalogoByEstadoDesarrollo(@PathVariable("estadoDesarrollo") String estadoDesarrollo) {
        List<Catalogo> catalogos = catalogoService.getCatalogoByEstadoDesarrollo(estadoDesarrollo);
        if (catalogos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catalogos);
    }


    @PostMapping
    public ResponseEntity<Catalogo> addCatalogo(@RequestBody Catalogo catalogo) {
        Catalogo createdCatalogo = catalogoService.addCatalogo(catalogo);
        return ResponseEntity.status(201).body(createdCatalogo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Catalogo> updateCatalogo(@PathVariable("id") int id, @RequestBody Catalogo catalogo) {
        catalogo.setId(id);
        Catalogo updatedCatalogo = catalogoService.updateCatalogo(catalogo);
        return ResponseEntity.ok(updatedCatalogo);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCatalogoByID(@PathVariable("id") Integer id) {
        catalogoService.deleteCatalogoByID(id);
        return ResponseEntity.noContent().build();
    }
}



