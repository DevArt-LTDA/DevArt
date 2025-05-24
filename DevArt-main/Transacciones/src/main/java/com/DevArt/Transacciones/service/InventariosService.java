package com.DevArt.Transacciones.service;

import com.DevArt.Transacciones.client.UsuarioClient;
import com.DevArt.Transacciones.model.Transacciones;
import com.DevArt.Transacciones.repository.InventariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class InventariosService {
    @Autowired
    private InventariosRepository Inventarios;

    @Autowired
    private UsuarioClient usuarioClient;

}
