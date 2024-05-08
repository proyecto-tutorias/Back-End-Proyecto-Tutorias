/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.NotificacionesServices;

import com.tutorias.domain.Notificacion;
import java.util.List;


public interface NotificacionesServices {
    
    public List<Notificacion> listaNotificaciones();
    public void borrar(Notificacion notificacion);
    public void insertar(Notificacion notificacion);
    public Notificacion encontrarNotificacion(Notificacion notificacion);
    
}
