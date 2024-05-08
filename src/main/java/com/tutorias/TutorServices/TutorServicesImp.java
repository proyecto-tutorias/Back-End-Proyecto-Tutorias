/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutorServices;

import com.tutorias.TutorDao.TutorDao;
import com.tutorias.domain.Tutor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutorServicesImp implements TutorServices{

    @Autowired
    private TutorDao tutorDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Tutor> listaTutores() {
        return (List<Tutor>)tutorDao.findAll();
    }

    @Override
    public void borrar(Tutor tutor) {
        tutorDao.delete(tutor);
    }

    @Override
    public void insertar(Tutor tutor) {
        tutorDao.save(tutor);
    }

    @Override
    @Transactional(readOnly = true)
    public Tutor encontrarTutor(Tutor tutor) {
       return tutorDao.findById(tutor.getIdTutor()).orElse(null);
    }
    
}
