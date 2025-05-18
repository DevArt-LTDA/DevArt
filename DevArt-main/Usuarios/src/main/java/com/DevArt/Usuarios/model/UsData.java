package com.DevArt.Usuarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Considerar esta clase como eliminable
no se si sera realmente necesaria
es posible modificar Usuarios y agregarlo alli
como atributos para la tabla.*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsData {
    private String departamento;
    private String cargo;
    ; 
}
