/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.PlataformasServices;

import com.tutorias.domain.PlataformaReunion;
import java.util.List;


public interface PlataformasServices {
    
    public List<PlataformaReunion> listaPlataformas();
    public void borrar(PlataformaReunion plataformas);
    public void insertar(PlataformaReunion plataformas);
    public PlataformaReunion encontrarPlataforma(PlataformaReunion plataformas);
    
}
