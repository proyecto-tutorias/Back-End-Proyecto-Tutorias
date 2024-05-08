/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.NotificacionesDao;

import com.tutorias.domain.Notificacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface NotificacionesDao extends CrudRepository<Notificacion, Long> {
    
}
