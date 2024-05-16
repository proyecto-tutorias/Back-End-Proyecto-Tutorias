/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstudianteServices;

import com.tutorias.TutoriasServices.*;
import com.tutorias.UsuarioServices.UsuarioRepositorio;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Tutoria;
import java.util.List;


public class EstudianteServices {
    
    
    public EstudianteServices(EstudianteRepositorio esturep) {
        this.esturep = esturep;
    }
    
    private EstudianteRepositorio esturep;
    
    public void insertarEstudiante(int id){
        esturep.insertar(id);
    }
    
    public List<Estudiante> listarTutorias(){
        return esturep.listarEstudiantes();
    }

    
    
}
