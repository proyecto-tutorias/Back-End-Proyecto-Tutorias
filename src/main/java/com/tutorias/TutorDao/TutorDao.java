/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutorDao;

import com.tutorias.domain.Tutor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DBZve
 */
public interface TutorDao {
    
    void insertarTutor(Tutor tutor);
    Tutor encontarTutor(int id);
    void desactivarTutor(int id);
    void activarTutor(int id);
    List<Tutor> listarTutores();
    void insertarPromedio(double prom, int id);
    void modificarTutor(Tutor tutor);
    
}
