/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AgendamientoTutoriaServices;

import com.tutorias.EstudianteServices.*;
import com.tutorias.TutoriasServices.*;
import com.tutorias.UsuarioServices.UsuarioRepositorio;
import com.tutorias.domain.AgendamientoTutoria;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Tutoria;
import java.util.List;


public class AgendamientoTutoriaServices {
    
    
    public AgendamientoTutoriaServices(AgendamientoTutoriaRepositorio agenturep) {
        this.agenturep = agenturep;
    }
    
    private AgendamientoTutoriaRepositorio agenturep;
    
    public void insertar(AgendamientoTutoria agentuto){
        agenturep.insertar(agentuto);
    }
    
    public List<AgendamientoTutoria> listar(){
        return agenturep.listar();
    }
    
    public AgendamientoTutoria encontrar(int id){
        return agenturep.encontrar(id);
    }
    
    public void activar(int id){
        agenturep.activar(id);
    }
    public void desactivar(int id){
        agenturep.desactivar(id);
    }
    
    public void insertarDatosReunion(AgendamientoTutoria agentuto){
        agenturep.insertarDatosReunion(agentuto);
    }
    
    public void insertarFecha(AgendamientoTutoria agentuto){
        agenturep.insertarFecha(agentuto);
    }

    
    
}
