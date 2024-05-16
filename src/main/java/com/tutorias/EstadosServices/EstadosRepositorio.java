/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstadosServices;

import com.tutorias.EstadosDao.EstadosDao;
import com.tutorias.domain.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EstadosRepositorio implements EstadosDao{

     private JdbcTemplate jdbcTemplate;

    public EstadosRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Estado> listar() {
        return jdbcTemplate.query("SELECT * FROM estados", new EstadosLoad());
    }

    @Override
    public void insertar(Estado estado) {
        jdbcTemplate.update("INSERT INTO estados(descripcion)" + "VALUES(?)", estado.getDescripcion());
    }

    @Override
    public void eliminar(Estado estado) {
        jdbcTemplate.update("DELETE FROM estados WHERE id_estado=?", estado.getIdEstado());
    }

    
}
