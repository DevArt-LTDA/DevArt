package com.DevArt.Usuarios.service;

import com.DevArt.Usuarios.model.Usuarios;
import com.DevArt.Usuarios.Repository.UsuariosRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional

public class TrabajadoresService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public TrabajadoresService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // Existe un trabajador por rut
    public boolean existeTrabajador(String rut) {
        return !usuariosRepository.findByRut(rut).isEmpty();
    }



    //Agregar un trabajador
    public Usuarios agregarTrabajador(Usuarios trabajador) {
        return usuariosRepository.save(trabajador);
    }
    // actualizar un trabajador por rut
    public Usuarios actualizarTrabajador(String rut, Usuarios trabajadorActualizado) {
        Usuarios trabajadorExistente = usuariosRepository.findByRut(rut).stream().findFirst().orElse(null);
        if (trabajadorExistente != null) {
            trabajadorActualizado.setRut(rut); 
            return usuariosRepository.save(trabajadorActualizado);
        }
        return null; 
    }

    // eliminar un trabajador por rut
    public void eliminarTrabajador(String rut) {
        Usuarios trabajadorExistente = usuariosRepository.findByRut(rut).stream().findFirst().orElse(null);
        if (trabajadorExistente != null) {
            usuariosRepository.delete(trabajadorExistente);
        }
    }


    // obtener todos los trabajadores
    public List<Usuarios> getAllTrabajadores() {
        return usuariosRepository.findAll();
    }

    // buscar por el rut
    public List<Usuarios> getTrabajadorByRut(String rut) {
        return usuariosRepository.findByRut(rut);
    }

    // buscar por primer nombre
    public List<Usuarios> getTrabajadorByPrimerNombre(String primerNombre) {
        return usuariosRepository.findByPrimerNombre(primerNombre);
    }

    // buscar por segundo nombre
    public List<Usuarios> getTrabajadorBySegundoNombre(String segundoNombre) {
        return usuariosRepository.findBySegundoNombre(segundoNombre);
    }

    // buscar por primer apellido
    public List<Usuarios> getTrabajadorByPrimerApellido(String primApellido) {
        return usuariosRepository.findByPrimApellido(primApellido);
    }

    // buscar por segundo apellido
    public List<Usuarios> getTrabajadorBySegundoApellido(String segApellido) {
        return usuariosRepository.findBySegApellido(segApellido);
    }

    // buscar por correo
    public List<Usuarios> getTrabajadorByCorreo(String correo) {
        return usuariosRepository.findByCorreo(correo);
    }

    // buscar por fecha de nacimiento
    public List<Usuarios> getTrabajadorByFechaNacimiento(String fechaNacimiento) {
        return usuariosRepository.findByFechaNacimiento(fechaNacimiento);
    }

    // buscar por telefono
    public List<Usuarios> getTrabajadorByTelefono(String telefono) {
        return usuariosRepository.findByTelefono(telefono);
    }
    
}
