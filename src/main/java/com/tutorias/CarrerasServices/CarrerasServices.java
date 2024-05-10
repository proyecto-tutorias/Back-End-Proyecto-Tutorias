/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CarrerasServices;


import com.tutorias.domain.Carrera;
import java.util.List;


public class CarrerasServices {
    
    public CarrerasServices(CarrerasRepositorio carrep) {
        this.carrep = carrep;
    }
    
    private CarrerasRepositorio carrep;
    
    
    public void insertarCarrera(Carrera carrera){
        carrep.insertar(carrera);
    }
    
    public void eliminarCarrera(int id){
        carrep.eliminar(id);
    }
    
    public List<Carrera> listarCarreras(){
        return carrep.listarCarreras();
    }
    
    
}
