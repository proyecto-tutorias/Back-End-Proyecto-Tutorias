/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CalificacionesDao;

import com.tutorias.domain.Calificacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface CalificacionesDao extends CrudRepository<Calificacion, Long> {
    
}
