/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstadosDao;

import com.tutorias.domain.Estado;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface EstadosDao extends CrudRepository<Estado, Long> {
    
}
