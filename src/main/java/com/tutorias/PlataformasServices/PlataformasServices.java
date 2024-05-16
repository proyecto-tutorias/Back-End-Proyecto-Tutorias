/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.PlataformasServices;

import com.tutorias.domain.PlataformaReunion;
import java.util.List;


public class PlataformasServices {
    
    public PlataformasServices(PlataformasRepositorio platarep) {
      this.platarep = platarep;
    }
    private PlataformasRepositorio platarep;
      
      
    
    public PlataformaReunion encontrarPlataforma(int id){
        return platarep.encontrar(id);
    }
    
    public List<PlataformaReunion> listarPlataformas(){
        return platarep.listar();
    }
    
    public void insertar(PlataformaReunion plareu){
        platarep.insertar(plareu);
    }
    
    
    
}
