/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;


public class PlataformaReunion {

    private int idPlataformaReunion;
    private String descripcion;

    public PlataformaReunion() {
    }

    public PlataformaReunion(int idPlataformaReunion, String descripcion) {
        this.idPlataformaReunion = idPlataformaReunion;
        this.descripcion = descripcion;
    }

  

    /**
     * @return the idPlataformaReunion
     */
    public int getIdPlataformaReunion() {
        return idPlataformaReunion;
    }

    /**
     * @param idPlataformaReunion the idPlataformaReunion to set
     */
    public void setIdPlataformaReunion(int idPlataformaReunion) {
        this.idPlataformaReunion = idPlataformaReunion;
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
