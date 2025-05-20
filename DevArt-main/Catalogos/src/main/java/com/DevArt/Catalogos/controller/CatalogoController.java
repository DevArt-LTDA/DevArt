package com.DevArt.Catalogos.controller;
import com.DevArt.Catalogos.controller.CatalogoController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.DevArt.Catalogos.service.CatalogoService;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.DevArt.Catalogos.model.Catalogo;

@RestController
@RequestMapping("/api/v1/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;
    @RequestMapping
    (value = "/getAllCatalogos", method = RequestMethod.GET)
    public ResponseEntity<List<Catalogo>> getAllCatalogos() {
        return ResponseEntity.ok(catalogoService.getAllCatalogos());
    }
    
}
