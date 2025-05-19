package com.DevArt.Catalogos.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Entity
@Table(name = "catalogo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 255, unique = true, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 255, unique = true, nullable = false)    
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime fechaModificacion;

}

