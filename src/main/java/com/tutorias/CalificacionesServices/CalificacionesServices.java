/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CalificacionesServices;


import com.tutorias.domain.Calificacion;
import java.util.List;


public class CalificacionesServices {
    
    public CalificacionesServices(CalificacionesRepositorio calirep) {
        this.calirep = calirep;
    }
    
    private CalificacionesRepositorio calirep;
    
    public void insertarCalificacion(Calificacion calificacion){
        calirep.insertar(calificacion);
    }
    
    public Calificacion encontrarCalificacion(int id){
        return calirep.encontrarCalificacion(id);
    }
    
    public List<Calificacion> listarCalificaciones(){
        return calirep.listarCalificaciones();
    }
    
    
    
    
    
}
