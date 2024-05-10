/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutoriasServices;

import com.tutorias.UsuarioServices.UsuarioRepositorio;
import com.tutorias.domain.Tutoria;
import java.util.List;


public class TutoriasServices {
    
    
    public TutoriasServices(TutoriasRepositorio tutoriasrep) {
        this.tutoriasrep = tutoriasrep;
    }
    
    private TutoriasRepositorio tutoriasrep;
    
    public void insertarTutoria(Tutoria tutoria){
        tutoriasrep.insertar(tutoria);
    }
    
    public List<Tutoria> listarTutorias(){
        return tutoriasrep.listarTutorias();
    }
    
    public void activarTutoria(int id){
        tutoriasrep.activar(id);
    }
    public void desactivarTutoria(int id){
        tutoriasrep.desactivar(id);
    }
    
    public Tutoria encontrarTutoria(int id){
        return tutoriasrep.encontrar(id);
    }
    
    
}
