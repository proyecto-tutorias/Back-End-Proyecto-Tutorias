/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.RangosDao;

import com.tutorias.domain.Rango;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface RangosDao {
    
    List<Rango> listarRangos();
    void insertar(Rango rango);
    
    
}
