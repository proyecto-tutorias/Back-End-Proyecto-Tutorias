/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.RangosServices;

import com.tutorias.domain.Rango;
import java.util.List;


public class RangosServices {
    
    public RangosServices(RangosRepositorio ranrep) {
        this.ranrep = ranrep;
    }
    
    private RangosRepositorio ranrep;
    
    public List<Rango> listarRangos(){
        return ranrep.listarRangos();
    }
    
}
