/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;



public class Tutor extends Usuario{
    



    private int idTutor;
    private Double promedioPuntaje;
    private int idRango;
    private int idEspecialidad;



    public Tutor() {
    }

    public Tutor(int idTutor, Double promedioPuntaje, int idRango, int idEspecialidad) {
        this.idTutor = idTutor;
        this.promedioPuntaje = promedioPuntaje;
        this.idRango = idRango;
        this.idEspecialidad = idEspecialidad;
    }

    public Tutor(int idTutor, Double promedioPuntaje, int idRango, int idEspecialidad, int idUsuario, String tipo, String nombre, String apellido, int codigoEstudiante, String contraseña, String login, int idCarrera) {
        super(idUsuario, tipo, nombre, apellido, codigoEstudiante, contraseña, login, idCarrera);
        this.idTutor = idTutor;
        this.promedioPuntaje = promedioPuntaje;
        this.idRango = idRango;
        this.idEspecialidad = idEspecialidad; 
    }

   
    /**
     * @return the idTutor
     */
    public int getIdTutor() {
        return idTutor;
    }

    /**
     * @param idTutor the idTutor to set
     */
    public void setIdTutor(int idTutor) {
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
