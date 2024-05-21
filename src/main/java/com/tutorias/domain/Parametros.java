/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author DBZve
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Parametros {
    
    private String busqueda;
    private int idCarrera;
    private int idArea;

    
    
}
