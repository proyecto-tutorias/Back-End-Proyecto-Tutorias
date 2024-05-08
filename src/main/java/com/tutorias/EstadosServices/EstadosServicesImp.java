/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstadosServices;

import com.tutorias.EstadosDao.EstadosDao;
import com.tutorias.domain.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadosServicesImp implements EstadosServices{

    @Autowired
    private EstadosDao estadosDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Estado> listaEstados() {
        return (List<Estado>)estadosDao.findAll();
    }

    @Override
    public void borrar(Estado estado) {
        estadosDao.delete(estado);
    }

    @Override
    public void insertar(Estado estado) {
        estadosDao.save(estado);
    }

    @Override
    @Transactional(readOnly = true)
    public Estado encontrarEstado(Estado estado) {
       return estadosDao.findById(estado.getIdEstado()).orElse(null);
    }
    
}
