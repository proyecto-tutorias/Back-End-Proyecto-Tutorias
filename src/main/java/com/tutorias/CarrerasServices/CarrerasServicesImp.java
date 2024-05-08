/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CarrerasServices;

import com.tutorias.CarrerasDao.CarrerasDao;
import com.tutorias.domain.Carrera;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarrerasServicesImp implements CarrerasServices{

    @Autowired
    private CarrerasDao carrerasDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Carrera> listaCarreras() {
        return (List<Carrera>)carrerasDao.findAll();
    }

    @Override
    public void borrar(Carrera carrera) {
        carrerasDao.delete(carrera);
    }

    @Override
    public void insertar(Carrera carrera) {
        carrerasDao.save(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Carrera encontrarCarrera(Carrera carrera) {
       return carrerasDao.findById(carrera.getIdCarrera()).orElse(null);
    }
    
}
