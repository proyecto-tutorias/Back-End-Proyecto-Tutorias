/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CalificacionesServices;

import com.tutorias.CalificacionesDao.CalificacionesDao;
import com.tutorias.CalificacionesServices.CalificacionesServices;
import com.tutorias.domain.Area;

import com.tutorias.domain.Calificacion;
import com.tutorias.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CalificacionesRepositorio implements CalificacionesDao{

    private JdbcTemplate jdbcTemplate;

    public CalificacionesRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(Calificacion calificacion) {
        jdbcTemplate.update("INSERT INTO calificaciones(id_calificacion,puntaje, comentario)" + 
                "VALUES (?,?,?)" ,
                calificacion.getIdCalificacion(),
                calificacion.getPuntaje() ,
                calificacion.getComentario());
    }

    @Override
    public void elimCalificacion(Calificacion calificacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Calificacion encontrarCalificacion(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM calificaciones WHERE id_calificacion=?", new CalificacionesLoad(), id);
    }

    @Override
    public List<Calificacion> listarCalificaciones() {
        return jdbcTemplate.query("SELECT * FROM calificaciones", new CalificacionesLoad());
    }
    
    

    
    
   
}
