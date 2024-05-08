/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutoriasDao;

import com.tutorias.domain.Tutoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface TutoriasDao extends CrudRepository<Tutoria, Long> {
    
}
