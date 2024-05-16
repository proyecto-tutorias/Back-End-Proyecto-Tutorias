/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;



public class Calificacion{
    

    private int idCalificacion;
    private Double puntaje;
    private String comentario;

    /**
     * @return the idCalificacion
     */
    public int getIdCalificacion() {
        return idCalificacion;
    }

    /**
     * @param idCalificacion the idCalificacion to set
     */
    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    /**
     * @return the puntaje
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}