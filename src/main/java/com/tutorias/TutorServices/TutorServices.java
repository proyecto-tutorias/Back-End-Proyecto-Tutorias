/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutorServices;

import com.tutorias.domain.Tutor;
import java.util.List;


public interface TutorServices {
    
    public List<Tutor> listaTutores();
    public void borrar(Tutor tutor);
    public void insertar(Tutor tutor);
    public Tutor encontrarTutor(Tutor tutor);
    
}
