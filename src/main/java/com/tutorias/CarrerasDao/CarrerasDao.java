/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CarrerasDao;

import com.tutorias.domain.Carrera;
import java.util.List;




public interface CarrerasDao {
    
    void insertar(Carrera carrera);
    void eliminar(int id);
    List<Carrera> listarCarreras();
    Carrera encontrarCarrera(int id);
    
}
