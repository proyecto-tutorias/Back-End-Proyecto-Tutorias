/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tutor")
public class Tutor extends Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idTutor;
    private Double promedioPuntaje;
    private int idRango;
    private int idEspecialidad;



    public Tutor() {
    }

    public Tutor(Long idTutor, Double promedioPuntaje, int idRango, int idEspecialidad) {
        this.idTutor = idTutor;
        this.promedioPuntaje = promedioPuntaje;
        this.idRango = idRango;
        this.idEspecialidad = idEspecialidad;
    }

    public Tutor(Long idTutor, Double promedioPuntaje, int idRango, int idEspecialidad, Long idUsuario, String tipo, String nombre, String apellido, int codigoEstudiante, String contraseña, String login, int idCarrera) {
        super(idUsuario, tipo, nombre, apellido, codigoEstudiante, contraseña, login, idCarrera);
        this.idTutor = idTutor;
        this.promedioPuntaje = promedioPuntaje;
        this.idRango = idRango;
        this.idEspecialidad = idEspecialidad;
    }

   
    /**
     * @return the idTutor
     */
    public Long getIdTutor() {
        return idTutor;
    }

    /**
     * @param idTutor the idTutor to set
     */
    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    /**
     * @return the promedioPuntaje
     */
    public Double getPromedioPuntaje() {
        return promedioPuntaje;
    }

    /**
     * @param promedioPuntaje the promedioPuntaje to set
     */
    public void setPromedioPuntaje(Double promedioPuntaje) {
        this.promedioPuntaje = promedioPuntaje;
    }

    /**
     * @return the idRango
     */
    public int getIdRango() {
        return idRango;
    }

    /**
     * @param idRango the idRango to set
     */
    public void setIdRango(int idRango) {
        this.idRango = idRango;
    }

    /**
     * @return the idEspecialidad
     */
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad the idEspecialidad to set
     */
    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

 
}
