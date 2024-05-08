/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;

import jakarta.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "estudiante")
public class Estudiante extends Usuario implements Serializable{
    
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEstudiante;

    public Estudiante() {
    }
    
    
    

    public Estudiante(Long idEstudiante, Long idUsuario, String tipo, String nombre, String apellido, int codigoEstudiante, String contraseña, String login, int idCarrera) {
        super(idUsuario, tipo, nombre, apellido, codigoEstudiante, contraseña, login, idCarrera);
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

 


    /**
     * @return the idEstudiante
     */
    public Long getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
}
