/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstudianteDao;


import com.tutorias.domain.Estudiante;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface EstudianteDao {
    
    void insertar(int id);
    List<Estudiante> listarEstudiantes();
    
    
}
