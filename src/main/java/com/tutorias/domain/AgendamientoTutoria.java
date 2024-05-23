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
    private String hora_inicio;
    private String hora_fin;
    private String fecha_fin;
    private String fecha_inicio;
    private String hora_def;

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

    /**
     * @return the hora_inicio
     */
    public String getHora_inicio() {
        return hora_inicio;
    }

    /**
     * @param hora_inicio the hora_inicio to set
     */
    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    /**
     * @return the hora_fin
     */
    public String getHora_fin() {
        return hora_fin;
    }

    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    /**
     * @return the fecha_fin
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the hora_def
     */
    public String getHora_def() {
        return hora_def;
    }

    /**
     * @param hora_def the hora_def to set
     */
    public void setHora_def(String hora_def) {
        this.hora_def = hora_def;
    }

    /**
     * @return the fecha_inicio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

}