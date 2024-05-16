/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstadosServices;

import com.tutorias.domain.Estado;
import java.util.List;


public class EstadosServices {
    
    public EstadosServices(EstadosRepositorio estarep) {
        this.estarep = estarep;
    }
    
    private EstadosRepositorio estarep;
    
    public List<Estado> listarEstados(){
        return estarep.listar();
    }
    
    public void insertarEstado(Estado estado){
        estarep.insertar(estado);
    }
    public void eliminarEstado(Estado estado){
        estarep.eliminar(estado);
    }
    
}
