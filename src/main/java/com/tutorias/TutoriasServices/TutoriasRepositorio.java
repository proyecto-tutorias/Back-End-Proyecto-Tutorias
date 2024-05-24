/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutoriasServices;

import com.tutorias.TutoriasDao.TutoriasDao;
import com.tutorias.domain.Tutoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TutoriasRepositorio implements TutoriasDao{
    
    private JdbcTemplate jdbcTemplate;

    public TutoriasRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(Tutoria tutoria) {
        jdbcTemplate.update("INSERT INTO tutorias(titulo,descripcion,fecha_limite,precio,id_estado,id_estudiante,id_area,activo,id_carrera)" + 
                      "VALUES (?,?,?,?,?,?,?,?,?)" ,
                      tutoria.getTitulo() ,
                      tutoria.getDescripcion(),
                      tutoria.getFechaLimite(),
                      tutoria.getPrecio(), 
                      tutoria.getIdEstado(),
                      tutoria.getIdEstudiante(),
                      tutoria.getIdArea(),
                      tutoria.getActivo(),
                      tutoria.getIdCarrera());    
    }

    @Override
    public void desactivar(int id) {
        jdbcTemplate.update("UPDATE tutorias SET activo = 0 WHERE id_tutoria=?",id);
    }
    @Override
    public void activar(int id) {
        jdbcTemplate.update("UPDATE tutorias SET activo = 1 WHERE id_tutoria=?",id);   
    }

    @Override
    public List<Tutoria> listarTutorias() {
        return jdbcTemplate.query("SELECT * FROM tutorias where activo = 1", new TutoriasLoad());
    }
    
    @Override
    public Tutoria encontrar(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM tutorias WHERE id_tutoria=?", new TutoriasLoad(), id);
    }
    
    @Override
    public List<Tutoria> listarMisTutorias(int id){
        try{
            return jdbcTemplate.query("SELECT * FROM tutorias WHERE id_estudiante=? and activo = 1", new TutoriasLoad(), id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
   
    @Override
    public List<Tutoria> listarTutoriasAsignadas(int id){
        try{
            return jdbcTemplate.query("SELECT * FROM tutorias WHERE id_tutor=? and activo = 1", new TutoriasLoad(), id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
    
    @Override
    public void cambiarEstado(int estado, int id){
        jdbcTemplate.update("UPDATE tutorias SET id_estado=? WHERE id_tutoria=?", estado, id);
    }
   
    @Override
    public void modificarTutoria(Tutoria tutoria){
        String sentencia ="update tutorias set descripcion='"+ tutoria.getDescripcion()+ "', titulo='"+tutoria.getTitulo()+"', precio ="+ tutoria.getPrecio()+", id_area ="+ tutoria.getIdArea()+ ", id_carrera="+ tutoria.getIdCarrera()+" where id_tutoria="+ tutoria.getIdTutoria();
        
        jdbcTemplate.update(sentencia);
        
    }
   
    

    
    
}
