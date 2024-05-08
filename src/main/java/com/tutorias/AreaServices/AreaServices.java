/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AreaServices;

import com.tutorias.UsuarioServices.UsuarioRepositorio;
import com.tutorias.domain.Area;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Usuario;
import java.util.List;


public class AreaServices {
    
    public AreaServices(AreaRepositorio arearep) {
        this.arearep = arearep;
    }
    
    private AreaRepositorio arearep;
    
    public void insertarArea(Area area){
        arearep.insertar(area);
    }
    
    public List<Area> encontrarAreas(){
        return arearep.listarAreas();
    }
    
    
    
}
