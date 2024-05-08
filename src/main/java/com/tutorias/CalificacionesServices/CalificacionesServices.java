/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CalificacionesServices;

import com.tutorias.domain.Calificacion;
import java.util.List;


public interface CalificacionesServices {
    
    public List<Calificacion> listaCalificaciones();
    public void borrar(Calificacion calificacion);
    public void insertar(Calificacion calificacion);
    public Calificacion encontrarCalificacion(Calificacion calificacion);
    
}
