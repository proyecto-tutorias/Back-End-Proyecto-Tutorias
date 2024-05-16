/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;



public class Notificacion{



    private int idNotificacion;
    
    private String descripcion;
    private int id_Tutor;
    private int id_Tutoria;
    private int activo;
    private int id_tipo_notificacion;
    private int id_destinatario;
    
    public Notificacion(int idNotificacion, String descripcion, int id_Tutor, int id_Tutoria) {
        this.idNotificacion = idNotificacion;
        this.descripcion = descripcion;
        this.id_Tutor = id_Tutor;
        this.id_Tutoria = id_Tutoria;
    }

    public Notificacion() {
    }


    /**
     * @return the idNotificacion
     */
    public int getIdNotificacion() {
        return idNotificacion;
    }

    /**
     * @param idNotificacion the idNotificacion to set
     */
    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
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

    /**
     * @return the id_Tutor
     */
    public int getId_Tutor() {
        return id_Tutor;
    }

    /**
     * @param id_Tutor the id_Tutor to set
     */
    public void setId_Tutor(int id_Tutor) {
        this.id_Tutor = id_Tutor;
    }

    /**
     * @return the id_Tutoria
     */
    public int getId_Tutoria() {
        return id_Tutoria;
    }

    /**
     * @param id_Tutoria the id_Tutoria to set
     */
    public void setId_Tutoria(int id_Tutoria) {
        this.id_Tutoria = id_Tutoria;
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
     * @return the id_tipo_notificacion
     */
    public int getId_tipo_notificacion() {
        return id_tipo_notificacion;
    }

    /**
     * @param id_tipo_notificacion the id_tipo_notificacion to set
     */
    public void setId_tipo_notificacion(int id_tipo_notificacion) {
        this.id_tipo_notificacion = id_tipo_notificacion;
    }

    /**
     * @return the id_destinatario
     */
    public int getId_destinatario() {
        return id_destinatario;
    }

    /**
     * @param id_destinatario the id_destinatario to set
     */
    public void setId_destinatario(int id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

}
