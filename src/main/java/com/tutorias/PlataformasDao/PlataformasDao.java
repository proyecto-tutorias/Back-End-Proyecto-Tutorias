/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.PlataformasDao;

import com.tutorias.domain.PlataformaReunion;
import org.springframework.data.repository.CrudRepository;



public interface PlataformasDao extends CrudRepository<PlataformaReunion, Long> {
    
}
