/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;




public class Estudiante extends Usuario{
    
        

    
    private int idEstudiante;

    public Estudiante() {
    }
    
    
    

    public Estudiante(int idEstudiante, int idUsuario, String tipo, String nombre, String apellido, int codigoEstudiante, String contraseña, String login, int idCarrera) {
        super(idUsuario, tipo, nombre, apellido, codigoEstudiante, contraseña, login, idCarrera);
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

 


    /**
     * @return the idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
}
