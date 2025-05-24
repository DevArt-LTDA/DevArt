package com.DevArt.Transacciones.repository;

import com.DevArt.Transacciones.model.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventariosRepository extends JpaRepository<Transacciones, Long> {
    List<Transacciones> findByRutProgramador(String rutProgramador);
    List<Transacciones> findByHorasDisponibles(int horasDisponibles);
    List<Transacciones> findByEstado(boolean estado);
}
