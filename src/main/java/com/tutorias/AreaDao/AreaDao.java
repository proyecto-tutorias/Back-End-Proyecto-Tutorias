/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AreaDao;

import com.tutorias.domain.Area;
import com.tutorias.domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface AreaDao {
    
    void insertar(Area area);
    void eliminar(Area area);
    Area encontrarArea(int id);
    List<Area> listarAreas();
    
    
}
