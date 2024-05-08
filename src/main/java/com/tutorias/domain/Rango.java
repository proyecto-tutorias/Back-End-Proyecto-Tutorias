/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rangos")
public class Rango implements Serializable {

    private Long idRango;
    private String descripcion;
    
    private static final long serialVersionUID = 1L;

    public Rango() {
    }

    public Rango(Long idRango, String descripcion) {
        this.idRango = idRango;
        this.descripcion = descripcion;
    }


    /**
     * @return the idRango
     */
    public Long getIdRango() {
        return idRango;
    }

    /**
     * @param idRango the idRango to set
     */
    public void setIdRango(Long idRango) {
        this.idRango = idRango;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
