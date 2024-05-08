/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CarrerasDao;

import com.tutorias.domain.Carrera;
import org.springframework.data.repository.CrudRepository;


public interface CarrerasDao extends CrudRepository<Carrera, Long> {
    
}
