package java.com.DevArt.Usuarios.service;

import java.com.DevArt.Usuarios.model.Usuarios;
import java.com.DevArt.Usuarios.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .filter(usuario -> usuario.getFechaNacimiento().equals(fechaNacimiento))
                .toList();
    }
        //Get Usuario por el telefono
    public List<Usuarios> getUsuarioByTelefono(String telefono) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getTelefono().equals(telefono))
                .toList();
    }
    


    //creacion de un nuveo usuario
    public Usuarios createUsuario(Usuarios usuario){
        return usuariosRepository.save(usuario);
    }



    // actualizar un usuario existente
    public Usuarios updateUsuario(String rut, Usuarios usuario) {
        if (!usuariosRepository.existsById(rut)) {
            throw new RuntimeException("Usuario no encontrado con el rut: " + rut);
        }
        // aca se hacen los cambios de los atributos del usuario
        Usuarios existingUsuario = usuariosRepository.findById(rut).orElseThrow(() -> new RuntimeException("usuario no encontrado con el rut: " + rut));
        existingUsuario.setPrimerNombre(usuario.getPrimerNombre());
        existingUsuario.setSegundoNombre(usuario.getSegundoNombre());
        existingUsuario.setPrimApellido(usuario.getPrimApellido());
        existingUsuario.setSegApellido(usuario.getSegApellido());
        existingUsuario.setCorreo(usuario.getCorreo());
        existingUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
        existingUsuario.setTelefono(usuario.getTelefono());
        // guardado de usuario actualizado
        return usuariosRepository.save(existingUsuario);
    }


    // eliminar un usuario por rut
    public void deleteUsuario(String rut) {
        if (!usuariosRepository.existsById(rut)) {
            throw new RuntimeException("Usuario no encontrado con el rut: " + rut);
        }
        usuariosRepository.deleteById(rut);
    }

    // Verificar si un usuario existe por rut
    public boolean existsByRut(String rut) {
        return usuariosRepository.existsById(rut);
    }
    // Contar el número total de usuarios
    public long countUsuarios() {
        return usuariosRepository.count();
    }
    // Verificar si un usuario existe por rut
    public boolean existeUsuarioPorRut(String rut) {
        return usuariosRepository.existsById(rut);
    }
    // rol
    public List<Usuarios> getUsuarioByRol(String rol) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getRol().equalsIgnoreCase(rol))
                .toList();
    }
    // departamento
    public List<Usuarios> getUsuarioByDepartamento(String departamento) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getDepartamento().equalsIgnoreCase(departamento))
                .toList();
    }
    // cargo
    public List<Usuarios> getUsuarioByCargo(String cargo) {
        return usuariosRepository.findAll().stream()
                .filter(usuario -> usuario.getCargo().equalsIgnoreCase(cargo))
                .toList();
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