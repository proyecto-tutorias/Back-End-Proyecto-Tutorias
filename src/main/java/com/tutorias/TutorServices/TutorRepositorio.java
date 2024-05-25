/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutorServices;

import com.tutorias.TutorDao.TutorDao;
import com.tutorias.domain.Tutor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TutorRepositorio implements TutorDao{
    
    private JdbcTemplate jdbcTemplate;

    public TutorRepositorio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertarTutor(Tutor tutor) {
        jdbcTemplate.update("INSERT INTO tutor(id_tutor, prom_puntaje, id_rango, activo)" + 
                       "VALUES (?,?,?,?)" ,
                       tutor.getIdTutor() ,
                       tutor.getPromedioPuntaje(), 
                       tutor.getIdRango(),
                       tutor.getActivo()); 
                      
    }

    @Override
    public Tutor encontarTutor(int id) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM tutor WHERE id_tutor=? and activo = 1", new TutorLoad(), id);   
        }catch(EmptyResultDataAccessException e){
            return null;
        }
        
    }

    @Override
    public void activarTutor(int id) {
        jdbcTemplate.update("UPDATE tutor SET activo = 1 WHERE id_tutor=?",id);
    }
    @Override
    public void desactivarTutor(int id) {
        jdbcTemplate.update("UPDATE tutor SET activo = 0 WHERE id_tutor=?",id);
    }

    @Override
    public List<Tutor> listarTutores() {
        return jdbcTemplate.query("SELECT * FROM tutor", new TutorLoad());
    }
    
    @Override
    public void insertarPromedio(double prom, int id){
        String sentencia = "update tutor set prom_puntaje ="+ prom +" where id_tutor = "+ id;
        
        jdbcTemplate.update(sentencia);
        
    }
    
    @Override
    public void modificarTutor(Tutor tutor){
        String sentencia = "update tutor set id_rango ="+ tutor.getIdRango() +" where id_tutor = "+ tutor.getIdTutor();
        
        jdbcTemplate.update(sentencia);
        
    }
    
    
    
    
    
   
    
}
