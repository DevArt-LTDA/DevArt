package com.DevArt.Usuarios.controller;
import com.DevArt.Usuarios.model.UsData;
import com.DevArt.Usuarios.model.Usuarios;
import com.DevArt.Usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    @Autowired 
    private UsuarioService UsuarioService;

    @GetMapping("")
    public List<Usuarios> getUsuarios () {
        /*no existe externalRestCall el UsuarioService,
        de modo que al parecer no podemos hacer consultas externas
        verifiquemos si es necesario sino este ENDPOINT solo necesita
        trar todos los usuarios solo queria agregar 
        departamento y cargo desde una consulta externa*/
        UsData usData = UsuarioService.externalRestCall("")
        System.out.println("Libros Disponibles");
        return UsuarioService.getAllUsuarios();
    }
    
    

}
