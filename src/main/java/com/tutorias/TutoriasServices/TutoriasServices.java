/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutoriasServices;

import com.tutorias.domain.Tutoria;
import java.util.List;


public interface TutoriasServices {
    
    public List<Tutoria> listaTutorias();
    public void borrar(Tutoria tutoria);
    public void insertar(Tutoria tutoria);
    public Tutoria encontrarTutoria(Tutoria tutoria);
    
}
