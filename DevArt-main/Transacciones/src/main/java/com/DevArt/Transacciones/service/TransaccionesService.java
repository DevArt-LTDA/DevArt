package com.DevArt.Transacciones.service;

import com.DevArt.Transacciones.client.UsuarioClient;
import com.DevArt.Transacciones.model.Transacciones;
import com.DevArt.Transacciones.repository.TransaccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesService {

    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public Transacciones crearTransaccion(Transacciones transaccion) {
        Boolean existeUsuario = usuarioClient.existeUsuario(transaccion.getUsuarioRut());

        if (Boolean.FALSE.equals(existeUsuario)) {
            throw new IllegalArgumentException("El usuario con RUT " + transaccion.getUsuarioRut() + " no existe.");
        }

        return transaccionesRepository.save(transaccion);
    }

    public List<Transacciones> obtenerTodas() {
        return transaccionesRepository.findAll();
    }

    public Optional<Transacciones> obtenerPorId(Long id) {
        return transaccionesRepository.findById(id);
    }

    public List<Transacciones> obtenerPorRut(String rut) {
        return transaccionesRepository.findByUsuarioRut(rut);
    }


    public void eliminarTransaccionesPorRut(String rut) {
        List<Transacciones> transacciones = transaccionesRepository.findByUsuarioRut(rut);
        if (transacciones.isEmpty()) {
            throw new IllegalArgumentException("No existen transacciones para el RUT " + rut);
        }
        transaccionesRepository.deleteByUsuarioRut(rut);
    }

}
