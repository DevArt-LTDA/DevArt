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

    @Column(name = "nombre_producto", length = 255, unique = true, nullable = false)
    private String nombre;
    
    @Column(name = "tipo_producto", length = 255, unique = true, nullable = false)
    private String tipo;    

    
    @Column(name = "descripcion_producto", length = 255, unique = true, nullable = false)    
    private String descripcion;


    @Column(name = "precio_producto", length = 255, unique = true, nullable = false)
    private int precio;

    @Column(name = "fecha_despliegue")
    private LocalDateTime fechaDespliegue;

    @Column(name = "estado_desarrollo")
    private String estadoDesarrollo;    

    //@Column(name = "tiempo_entrega", nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private LocalDateTime fechaCreacion;


    //@Column(name = "fecha_modificacion", nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private LocalDateTime fechaModificacion;


    

}

