/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EspecialidadesServices;

import com.tutorias.EspecialidadesDao.EspecialidadesDao;
import com.tutorias.domain.Especialidad;
import com.tutorias.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecialidadesServicesImp implements EspecialidadesServices{

    @Autowired
    private EspecialidadesDao especialidadesDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Especialidad> listaEspecialidades() {
        return (List<Especialidad>)especialidadesDao.findAll();
    }

    @Override
    public void borrar(Especialidad especialidad) {
        especialidadesDao.delete(especialidad);
    }

    @Override
    public void insertar(Especialidad especialidad) {
        especialidadesDao.save(especialidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Especialidad encontrarEspecialidad(Especialidad especialidad) {
       return especialidadesDao.findById(especialidad.getIdEspecialidad()).orElse(null);
    }
    
}
