package com.DevArt.Transacciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "iventarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    @Id
    @Column(name = "rut_programador", nullable = false, length = 255)
    private String rutProgramador;
    @Column(name = "horas_disponibles", nullable = false, length = 100)
    private int  horaDisponible;
}
