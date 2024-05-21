/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AgendamientoTutoriaDao;

import com.tutorias.AreaDao.*;
import com.tutorias.domain.AgendamientoTutoria;
import com.tutorias.domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface AgendamientoTutoriaDao {
    
    void insertar(AgendamientoTutoria agentuto);
    void desactivar(int id);
    void activar(int id);
    AgendamientoTutoria encontrar(int id);
    List<AgendamientoTutoria> listar();
    void insertarDatosReunion(AgendamientoTutoria agentuto);
    void insertarFecha(AgendamientoTutoria agentuto);
    
    
}
