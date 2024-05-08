/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "notificaciones")
public class Notificacion implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idNotificacion;
    
    private String descripcion;
    private int id_Tutor;
    private int id_Tutoria;

    public Notificacion(Long idNotificacion, String descripcion, int id_Tutor, int id_Tutoria) {
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
    public Long getIdNotificacion() {
        return idNotificacion;
    }

    /**
     * @param idNotificacion the idNotificacion to set
     */
    public void setIdNotificacion(Long idNotificacion) {
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

}
