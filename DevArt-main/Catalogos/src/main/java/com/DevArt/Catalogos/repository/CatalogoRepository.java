package com.DevArt.Catalogos.repository;
import com.DevArt.Catalogos.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Traspaso a mainv2

import java.time.LocalDateTime;
import java.util.List;

@Repository


public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
    // metodos de busqueda repository Catalogo
    List<Catalogo> findByID(int id);
    List<Catalogo> findByNombre(String nombre);
    List<Catalogo> findByTipo(String tipo);
    List<Catalogo> findByDescripcion(String descripcion);
    List<Catalogo> findByPrecio(int precio);
    List<Catalogo> findByFechaDespliegue(LocalDateTime fechaDespliegue);
    List<Catalogo> findByEstadoDesarrollo(String estadoDesarrollo);
}
