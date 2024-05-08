/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CalificacionesServices;

import com.tutorias.CalificacionesDao.CalificacionesDao;
import com.tutorias.CalificacionesServices.CalificacionesServices;

import com.tutorias.domain.Calificacion;
import com.tutorias.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalificacionesServicesImp implements CalificacionesServices{

    @Autowired
    private CalificacionesDao calificacionesDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Calificacion> listaCalificaciones() {
        return (List<Calificacion>)calificacionesDao.findAll();
    }

    @Override
    public void borrar(Calificacion calificacion) {
        calificacionesDao.delete(calificacion);
    }

    @Override
    public void insertar(Calificacion calificacion) {
        calificacionesDao.save(calificacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Calificacion encontrarCalificacion(Calificacion calificacion) {
       return calificacionesDao.findById(calificacion.getIdCalificacion()).orElse(null);
    }
    
}
