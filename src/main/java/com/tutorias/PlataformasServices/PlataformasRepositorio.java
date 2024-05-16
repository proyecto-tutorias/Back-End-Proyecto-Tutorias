/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.PlataformasServices;

import com.tutorias.PlataformasDao.PlataformasDao;
import com.tutorias.domain.PlataformaReunion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlataformasRepositorio implements PlataformasDao{

    private JdbcTemplate jdbcTemplate;

    public PlataformasRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(PlataformaReunion platareu) {
        jdbcTemplate.update("INSERT INTO plataformasreunion(descripcion)" +
                "VALUES(?)",
                platareu.getDescripcion());
    }

    @Override
    public List<PlataformaReunion> listar() {
        return jdbcTemplate.query("SELECT * FROM plataformasreunion", new PlataformasLoad());
    }

    @Override
    public PlataformaReunion encontrar(int id) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM plataformasreunion WHERE id_plataforma_reunion=?", new PlataformasLoad(), id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
       
    }
    
    
   
}
