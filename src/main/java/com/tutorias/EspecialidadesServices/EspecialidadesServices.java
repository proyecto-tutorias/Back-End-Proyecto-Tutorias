/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EspecialidadesServices;

import com.tutorias.domain.Especialidad;
import java.util.List;


public interface EspecialidadesServices {
    
    public List<Especialidad> listaEspecialidades();
    public void borrar(Especialidad especialidad);
    public void insertar(Especialidad especialidad);
    public Especialidad encontrarEspecialidad(Especialidad especialidad);
    
}
