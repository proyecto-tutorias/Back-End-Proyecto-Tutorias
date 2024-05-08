/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutoriasServices;

import com.tutorias.TutoriasDao.TutoriasDao;
import com.tutorias.domain.Tutoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutoriasServicesImp implements TutoriasServices{

    @Autowired
    private TutoriasDao tutoriasDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Tutoria> listaTutorias() {
        return (List<Tutoria>)tutoriasDao.findAll();
    }

    @Override
    public void borrar(Tutoria tutoria) {
        tutoriasDao.delete(tutoria);
    }

    @Override
    public void insertar(Tutoria tutoria) {
        tutoriasDao.save(tutoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Tutoria encontrarTutoria(Tutoria tutoria) {
       return tutoriasDao.findById(tutoria.getIdTutoria()).orElse(null);
    }
    
}
