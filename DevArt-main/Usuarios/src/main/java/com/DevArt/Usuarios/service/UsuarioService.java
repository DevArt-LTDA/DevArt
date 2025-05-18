package com.DevArt.Usuarios.service;

import com.DevArt.Usuarios.model.Usuarios;
import com.DevArt.Usuarios.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // obtener todos los usuarios
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    // buscar por el rut
    public List<Usuarios> getUsuarioByRut(String rut) {
        return usuariosRepository.findByRut(rut);
    }

    // buscar por primer nombre
    public List<Usuarios> getUsuarioByPrimerNombre(String primerNombre) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getPrimerNombre().equalsIgnoreCase(primerNombre))
                .toList();
    }

    // buscar por segundo_nombre
    public List<Usuarios> getUsuarioBySegundoNombre(String segundoNombre) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getSegundoNombre() != null && usuario.getSegundoNombre().equalsIgnoreCase(segundoNombre))
                .toList();
    }

    // buscar por primer apellido
    public List<Usuarios> getUsuarioByPrimerApellido(String primerApellido) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getPrimApellido().equalsIgnoreCase(primerApellido))
                .toList();
    }

    // buscar por segundo apellido
    public List<Usuarios> getUsuarioBySegundoApellido(String segundoApellido) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getSegApellido() != null && usuario.getSegApellido().equalsIgnoreCase(segundoApellido))
                .toList();
    }
    // buscar por correo
    public List<Usuarios> getUsuarioByCorreo(String correo) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getCorreo().equalsIgnoreCase(correo))
                .toList();
    }
    // buscar por fecha de nacimiento
    public List<Usuarios> getUsuarioByFechaNacimiento(String fechaNacimiento) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getFecha_nacimiento().equals(fechaNacimiento))
                .toList();
    }
    
    // guardar un nuevo usuario
    public Usuarios saveUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }


    // actualizar un usuario existente
    public Usuarios updateUsuario(Usuarios usuario) {
        if (usuariosRepository.existsById(usuario.getRut())) {
            return usuariosRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado con el rut: " + usuario.getRut());
        }

    }
    // eliminar un usuario por rut
    public void deleteUsuario(String rut) {
        if (usuariosRepository.existsById(rut)) {
            usuariosRepository.deleteById(rut);
        } else {
            throw new RuntimeException("Usuario no encontrado con el rut: " + rut);
        }
    }
    // Verificar si un usuario existe por rut
    public boolean existsByRut(String rut) {
        return usuariosRepository.existsById(rut);
    }
    // Contar el número total de usuarios
    public long countUsuarios() {
        return usuariosRepository.count();
    }
    
    
}




//                    ,,,, 
//              ,;) .';;;;',
//  ;;,,_,-.-.,;;'_,|I\;;;/),,_
//   `';;/:|:);{ ;;;|| \;/ /;;;\__
//       L;/-';/ \;;\',/;\/;;;.') \
//       .:`''` - \;;'.__/;;;/  . _'-._ 
//     .'/   \     \;;;;;;/.'_7:.  '). \_
//   .''/     | '._ );}{;//.'    '-:  '.,L
// .'. /       \  ( |;;;/_/         \._./;\   _,
//  . /        |\ ( /;;/_/             ';;;\,;;_,
// . /         )__(/;;/_/                (;;'''''
//  /        _;:':;;;;:';-._             );
// /        /   \  `'`   --.'-._         \/
//        .'     '.  ,'         '-,
//       /    /   r--,..__       '.\
//     .'    '  .'        '--._     ]
//     (     :.(;>        _ .' '- ;/
//     |      /:;(    ,_.';(   __.'
//      '- -'"|;:/    (;;;;-'--'
//            |;/      ;;(
//            ''      /;;|
//                    \;;|
//                     \/