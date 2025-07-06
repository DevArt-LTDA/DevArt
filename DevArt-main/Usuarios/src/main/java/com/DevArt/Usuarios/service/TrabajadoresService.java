package com.DevArt.Usuarios.service;

import com.DevArt.Usuarios.model.Usuarios;
import com.DevArt.Usuarios.repository.UsuariosRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TrabajadoresService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Verificar si existe un trabajador por RUT
    public boolean existeTrabajador(String rut) {
        return !usuariosRepository.findByRut(rut).isEmpty();
    }

    // Agregar un trabajador
    public Usuarios agregarTrabajador(Usuarios trabajador) {
        return usuariosRepository.save(trabajador);
    }

    // Actualizar un trabajador por RUT
    public Usuarios actualizarTrabajador(String rut, Usuarios trabajadorActualizado) {
        Usuarios trabajadorExistente = usuariosRepository.findByRut(rut).stream().findFirst().orElse(null);
        if (trabajadorExistente != null) {
            trabajadorActualizado.setRut(rut);
            return usuariosRepository.save(trabajadorActualizado);
        }
        return null;
    }

    // Eliminar un trabajador por RUT
    public void eliminarTrabajador(String rut) {
        Usuarios trabajadorExistente = usuariosRepository.findByRut(rut).stream().findFirst().orElse(null);
        if (trabajadorExistente != null) {
            usuariosRepository.delete(trabajadorExistente);
        }
    }

    // Obtener todos los trabajadores
    public List<Usuarios> getAllTrabajadores() {
        return usuariosRepository.findAll();
    }

    // Buscar por RUT
    public List<Usuarios> getTrabajadorByRut(String rut) {
        return usuariosRepository.findByRut(rut);
    }

    // Buscar por primer nombre
    public List<Usuarios> getTrabajadorByPrimerNombre(String primerNombre) {
        return usuariosRepository.findByPrimerNombre(primerNombre);
    }

    // Buscar por segundo nombre
    public List<Usuarios> getTrabajadorBySegundoNombre(String segundoNombre) {
        return usuariosRepository.findBySegundoNombre(segundoNombre);
    }

    // Buscar por primer apellido
    public List<Usuarios> getTrabajadorByPrimerApellido(String primApellido) {
        return usuariosRepository.findByPrimApellido(primApellido);
    }

    // Buscar por segundo apellido
    public List<Usuarios> getTrabajadorBySegundoApellido(String segApellido) {
        return usuariosRepository.findBySegApellido(segApellido);
    }

    // Buscar por correo
    public List<Usuarios> getTrabajadorByCorreo(String correo) {
        return usuariosRepository.findByCorreo(correo);
    }

    // Buscar por fecha de nacimiento
    public List<Usuarios> getTrabajadorByFechaNacimiento(String fechaNacimiento) {
        return usuariosRepository.findByFechaNacimiento(fechaNacimiento);
    }

    // Buscar por teléfono
    public List<Usuarios> getTrabajadorByTelefono(String telefono) {
        return usuariosRepository.findByTelefono(telefono);
    }
}
