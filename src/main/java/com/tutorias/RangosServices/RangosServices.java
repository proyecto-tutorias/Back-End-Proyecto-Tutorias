/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.RangosServices;

import com.tutorias.domain.Rango;
import java.util.List;


public interface RangosServices {
    
    public List<Rango> listaRangos();
    public void borrar(Rango rango);
    public void insertar(Rango rango);
    public Rango encontrarRango(Rango rango);
    
}
