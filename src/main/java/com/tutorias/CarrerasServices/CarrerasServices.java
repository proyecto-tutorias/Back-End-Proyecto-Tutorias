/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CarrerasServices;

import com.tutorias.domain.Carrera;
import java.util.List;


public interface CarrerasServices {
    
    public List<Carrera> listaCarreras();
    public void borrar(Carrera carrera);
    public void insertar(Carrera carrera);
    public Carrera encontrarCarrera(Carrera carrera);
    
}
