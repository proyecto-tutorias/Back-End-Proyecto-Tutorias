/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Data;





public class AgendamientoTutoria {
    
   
    
    
    private int idAgendamiento;
    private String URLReunion;
    private String fechaAgendamiento;
    private int idPlataformaReunion;
    private int activo;
    private String datos_adicionales;

    /**
     * @return the idAgendamiento
     */
    public int getIdAgendamiento() {
        return idAgendamiento;
    }

    /**
     * @param idAgendamiento the idAgendamiento to set
     */
    public void setIdAgendamiento(int idAgendamiento) {
        this.idAgendamiento = idAgendamiento;
    }

    /**
     * @return the URLReunion
     */
    public String getURLReunion() {
        return URLReunion;
    }

    /**
     * @param URLReunion the URLReunion to set
     */
    public void setURLReunion(String URLReunion) {
        this.URLReunion = URLReunion;
    }

    /**
     * @return the fechaAgendamiento
     */
    public String getFechaAgendamiento() {
        return fechaAgendamiento;
    }

    /**
     * @param fechaAgendamiento the fechaAgendamiento to set
     */
    public void setFechaAgendamiento(String fechaAgendamiento) {
        this.fechaAgendamiento = fechaAgendamiento;
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
     * @return the activo
     */
    public int getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }

    /**
     * @return the datos_adicionales
     */
    public String getDatos_adicionales() {
        return datos_adicionales;
    }

    /**
     * @param datos_adicionales the datos_adicionales to set
     */
    public void setDatos_adicionales(String datos_adicionales) {
        this.datos_adicionales = datos_adicionales;
    }

}