/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.PlataformasDao;

import com.tutorias.domain.PlataformaReunion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;



public interface PlataformasDao  {
    
    void insertar(PlataformaReunion platareu);
    List<PlataformaReunion> listar();
    PlataformaReunion encontrar(int id);
    
}
