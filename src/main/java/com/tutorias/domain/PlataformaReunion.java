/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plataformasreunion")
public class PlataformaReunion implements Serializable{

    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Long idPlataformaReunion;
    private String descripcion;

    public PlataformaReunion() {
    }

    public PlataformaReunion(Long idPlataformaReunion, String descripcion) {
        this.idPlataformaReunion = idPlataformaReunion;
        this.descripcion = descripcion;
    }

  

    /**
     * @return the idPlataformaReunion
     */
    public Long IdPlataformaReunion() {
        return idPlataformaReunion;
    }

    /**
     * @param idPlataformaReunion the idPlataformaReunion to set
     */
    public void setIdPlataformaReunion(Long idPlataformaReunion) {
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
