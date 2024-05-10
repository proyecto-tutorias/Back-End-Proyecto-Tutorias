/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AreaServices;


import com.tutorias.AreaDao.AreaDao;
import com.tutorias.UsuarioServices.UsuarioLoad;
import com.tutorias.domain.Area;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AreaRepositorio implements AreaDao{

     private JdbcTemplate jdbcTemplate;

    public AreaRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(Area area) {
    jdbcTemplate.update("INSERT INTO areas(descripcion)" + 
                "VALUES (?)" ,
                area.getDescripcion());    
    }

    @Override
    public void eliminar(Area area) {
        jdbcTemplate.update("DELETE FROM areas WHERE id_area=?", area.getIdArea());    }

    @Override
    public Area encontrarArea(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM areas WHERE id_area=?", new AreaLoad(), id);
       
    }

    @Override
    public List<Area> listarAreas() {
        return jdbcTemplate.query("SELECT * FROM areas", new AreaLoad());
    }
    
    
   
}
