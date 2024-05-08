/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstadosServices;

import com.tutorias.domain.Estado;
import java.util.List;


public interface EstadosServices {
    
    public List<Estado> listaEstados();
    public void borrar(Estado estado);
    public void insertar(Estado estado);
    public Estado encontrarEstado(Estado estado);
    
}
