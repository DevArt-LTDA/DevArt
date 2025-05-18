package com.DevArt.Usuarios.controller;
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

    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<Usuarios>> getUsuarios () {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<List<Usuarios>> getUsuarioByRut(@PathVariable String rut) {
        List<Usuarios> usuarios = usuarioService.getUsuarioByRut(rut);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/nombre/{primerNombre}")
    public ResponseEntity<List<Usuarios>> getUsuarioByPrimerNombre(@PathVariable String primerNombre) {
        List<Usuarios> usuarios = usuarioService.getUsuarioByPrimerNombre(primerNombre);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/segundo-nombre/{segundoNombre}")
    public ResponseEntity<List<Usuarios>> getUsuarioBySegundoNombre(@PathVariable String segundoNombre) {
        List<Usuarios> usuarios = usuarioService.getUsuarioBySegundoNombre(segundoNombre);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/apellido/{primerApellido}")
    public ResponseEntity<List<Usuarios>> getUsuarioByPrimerApellido(@PathVariable String primerApellido) {
        List<Usuarios> usuarios = usuarioService.getUsuarioByPrimerApellido(primerApellido);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/segundo-apellido/{segundoApellido}")
    public ResponseEntity<List<Usuarios>> getUsuarioBySegundoApellido(@PathVariable String segundoApellido) {
        List<Usuarios> usuarios = usuarioService.getUsuarioBySegundoApellido(segundoApellido);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/correo/{correo}")
    public ResponseEntity<List<Usuarios>> getUsuarioByCorreo(@PathVariable String correo) {
        List<Usuarios> usuarios = usuarioService.getUsuarioByCorreo(correo);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/fecha-nacimiento/{fechaNacimiento}")
    public ResponseEntity<List<Usuarios>> getUsuarioByFechaNacimiento(@PathVariable String fechaNacimiento) {
        List<Usuarios> usuarios = usuarioService.getUsuarioByFechaNacimiento(fechaNacimiento);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<List<Usuarios>> getUsuarioByTelefono(@PathVariable String telefono) {
        List<Usuarios> usuarios = usuarioService.getUsuarioByTelefono(telefono);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @PostMapping
    public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios usuario) {
        Usuarios createdUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(201).body(createdUsuario);
    }
    @PutMapping("/{rut}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable String rut, @RequestBody Usuarios usuario) {
        Usuarios updatedUsuario = usuarioService.updateUsuario(rut, usuario);
        if (updatedUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String rut) {
        usuarioService.deleteUsuario(rut);
        return ResponseEntity.noContent().build();
    }


}
