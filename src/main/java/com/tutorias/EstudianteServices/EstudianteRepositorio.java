/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstudianteServices;

import com.tutorias.EstudianteDao.EstudianteDao;
import com.tutorias.TutorServices.*;
import com.tutorias.TutorDao.TutorDao;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Tutor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EstudianteRepositorio implements EstudianteDao{
    
    private JdbcTemplate jdbcTemplate;

    public EstudianteRepositorio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(int id) {
        jdbcTemplate.update("INSERT INTO estudiante(id_estudiante)" + 
                       "VALUES (?)" ,
                       id);
    }



    @Override
    public List<Estudiante> listarEstudiantes() {
        return jdbcTemplate.query("SELECT * FROM estudiante", new EstudianteLoad());
    }

  
    
    
    
   
    
}
