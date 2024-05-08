/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CalificacionesDao;

import com.tutorias.domain.Area;
import com.tutorias.domain.Calificacion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface CalificacionesDao{
    void insertar(Calificacion calificacion);
    void elimCalificacion(Calificacion calificacion);
    Area encontrarCalificacion(Calificacion calificacion);
    List<Area> listarCalificacion();
    List<Area> listarCalificacionPorId(int id_tutor);
    
}
