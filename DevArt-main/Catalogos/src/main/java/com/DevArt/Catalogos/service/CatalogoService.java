package com.DevArt.Catalogos.service;
import org.springframework.stereotype.Service;
import com.DevArt.Catalogos.repository.CatalogoRepository;
import com.DevArt.Catalogos.model.Catalogo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
@Service
@Transactional


public class CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;
    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }
    // obtener todos los catalogos
    public List<Catalogo> getAllCatalogos() {
        return catalogoRepository.findAll();
    }
    // buscar por ID
    public List<Catalogo> getCatalogoById(int id) {
        return catalogoRepository.findById(id);
    }


    // buscar por nombre
    public List<Catalogo> getCatalogoByNombre(String nombre) {
        return catalogoRepository.findByNombre(nombre);
    }
    // buscar por tipo
    public List<Catalogo> getCatalogoByTipo(String tipo) {
        return catalogoRepository.findByTipo(tipo);
    }

    // buscar por descripcion
    public List<Catalogo> getCatalogoByDescripcion(String descripcion) {
        return catalogoRepository.findByDescripcion(descripcion);
    }
    // buscar por precio
    public List<Catalogo> getCatalogoByPrecio(int precio) {
        return catalogoRepository.findByPrecio(precio);
    }
    // buscar por fecha de despliegue
    public List<Catalogo> getCatalogoByFechaDespliegue(LocalDateTime fechaDespliegue) {
        return catalogoRepository.findByFechaDespliegue(fechaDespliegue);
    }
    
    // buscar por estado de desarrollo
    public List<Catalogo> getCatalogoByEstadoDesarrollo(String estadoDesarrollo) {
        return catalogoRepository.findByEstadoDesarrollo(estadoDesarrollo);
    }


    // Agregar un catalogo
    public Catalogo addCatalogo(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }
    // Actualizar un catalogo
    public Catalogo updateCatalogo(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }
    // Eliminar un catalogo
    public void deleteCatalogo(int id) {
        catalogoRepository.deleteById(id);
    }
    // Eliminar Catalogo por ID
    public void deleteCatalogoByID(Integer id) {
        catalogoRepository.deleteById(id);
    }
    


}
