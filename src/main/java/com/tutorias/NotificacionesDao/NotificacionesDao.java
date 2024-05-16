/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.NotificacionesDao;

import com.tutorias.domain.Notificacion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface NotificacionesDao {
    
    void insertar(Notificacion notificacion);
    List<Notificacion> listarNotificaciones();
    Notificacion encontrar(int id);
    void activar(int id);
    void desactivar(int id);
    List<Notificacion> listarNotificacionesTutor();
    List<Notificacion> listarNotificacionesEstudiante();
    List<Notificacion> encontrarPorTutoria(int id);
    

    
    
}
