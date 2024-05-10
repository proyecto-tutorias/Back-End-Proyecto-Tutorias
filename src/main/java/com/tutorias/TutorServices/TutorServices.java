/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutorServices;

import com.tutorias.UsuarioServices.UsuarioRepositorio;
import com.tutorias.domain.Tutor;
import java.util.List;


public class TutorServices {
    
    public TutorServices(TutorRepositorio tutorep) {
        this.tutorep = tutorep;
    }
    
    private TutorRepositorio tutorep;
    
    
    
    public void insertarTutor(Tutor tutor){
        tutorep.insertarTutor(tutor);
    }
    
    public List<Tutor> listarTutores(){
        return tutorep.listarTutores();
    }
    
    public Tutor encontrarTutor(int id){
        return tutorep.encontarTutor(id);
    }
    
    
    
}
