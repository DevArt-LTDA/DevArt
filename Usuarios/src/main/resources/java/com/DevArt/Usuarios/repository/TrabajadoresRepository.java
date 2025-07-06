package com.DevArt.Usuarios.repository;
import com.DevArt.Usuarios.model.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrabajadoresRepository extends JpaRepository<Trabajadores, String> {
    List<Trabajadores> findByRut(String rut);
    List<Trabajadores> findByPrimerNombre(String primerNombre);
    List<Trabajadores> findBySegundoNombre(String segundoNombre);
    List<Trabajadores> findByPrimApellido(String primApellido);
    List<Trabajadores> findBySegApellido(String segApellido);
    List<Trabajadores> findByCorreo(String correo);
    List<Trabajadores> findByFechaNacimiento(String fechaNacimiento); 
    List<Trabajadores> findByTelefono(String telefono);
    List<Trabajadores> findByRol(String rol);
    
}