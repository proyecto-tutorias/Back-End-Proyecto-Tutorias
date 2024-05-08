/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.RangosServices;

import com.tutorias.RangosDao.RangosDao;
import com.tutorias.domain.Rango;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RangosServicesImp implements RangosServices{

    @Autowired
    private RangosDao rangosDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Rango> listaRangos() {
        return (List<Rango>)rangosDao.findAll();
    }

    @Override
    public void borrar(Rango rango) {
        rangosDao.delete(rango);
    }

    @Override
    public void insertar(Rango rango) {
        rangosDao.save(rango);
    }

    @Override
    @Transactional(readOnly = true)
    public Rango encontrarRango(Rango rango) {
       return rangosDao.findById(rango.getIdRango()).orElse(null);
    }
    
}
