/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstadosDao;

import com.tutorias.domain.Estado;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface EstadosDao {
    
    List<Estado> listar();
    void insertar(Estado estado);
    void eliminar(Estado estado);
    
}
