/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.NotificacionesServices;

import com.tutorias.domain.Notificacion;
import java.util.List;


public class NotificacionesServices {
    
    
    public NotificacionesServices(NotificacionesRepositorio notirep) {
        this.notirep = notirep;
    }
    
    private NotificacionesRepositorio notirep;
    
    
    public List<Notificacion> listarNotificaciones(){
        return notirep.listarNotificaciones();
    }
    
    public void activarNotificacion(int id){
        notirep.activar(id);
    }
    public void desactivarNotificacion(int id){
        notirep.desactivar(id);
    }
    
    public void insertarNotificacion(Notificacion notificacion){
        notirep.insertar(notificacion);
    }
    
    public List<Notificacion> listarNotificacionesTutor(){
        return notirep.listarNotificacionesTutor();
    }
    public List<Notificacion> listarNotificacionesEstudiante(){
        return notirep.listarNotificacionesEstudiante();
    }
    
    public Notificacion encontrarNotificacion(int id){
        return notirep.encontrar(id);
    }
    public List<Notificacion> encontrarPorTutoria(int id){
        return notirep.encontrarPorTutoria(id);
    }

    
    
}
