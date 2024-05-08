/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutorDao;

import com.tutorias.domain.Tutor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface TutorDao extends CrudRepository<Tutor, Long> {
    
}
