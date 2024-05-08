/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AreaServices;

import com.tutorias.domain.Area;
import com.tutorias.domain.Estudiante;
import java.util.List;


public interface AreaServices {
    
    public List<Area> listaAreas();
    public void borrar(Area area);
    public void insertar(Area area);
    public Area encontrarArea(Area area);
    
}
