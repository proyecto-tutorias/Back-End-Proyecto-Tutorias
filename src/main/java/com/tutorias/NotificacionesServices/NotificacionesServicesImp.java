/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.NotificacionesServices;

import com.tutorias.NotificacionesDao.NotificacionesDao;
import com.tutorias.domain.Notificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificacionesServicesImp implements NotificacionesServices{

    @Autowired
    private NotificacionesDao notificacionesDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Notificacion> listaNotificaciones() {
        return (List<Notificacion>)notificacionesDao.findAll();
    }

    @Override
    public void borrar(Notificacion notificacion) {
        notificacionesDao.delete(notificacion);
    }

    @Override
    public void insertar(Notificacion notificacion) {
        notificacionesDao.save(notificacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Notificacion encontrarNotificacion(Notificacion notificacion) {
       return notificacionesDao.findById(notificacion.getIdNotificacion()).orElse(null);
    }
    
}
