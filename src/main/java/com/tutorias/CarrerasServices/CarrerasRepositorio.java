/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CarrerasServices;

import com.tutorias.CarrerasDao.CarrerasDao;
import com.tutorias.domain.Carrera;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarrerasRepositorio implements CarrerasDao{

    private JdbcTemplate jdbcTemplate;

    public CarrerasRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(Carrera carrera) {
        jdbcTemplate.update("INSERT INTO carreras(descripcion, min_semestre, max_semestre)" + 
                "VALUES(?,?,?)" ,
                carrera.getDescripcion(),
                carrera.getMinSemestre(),
                carrera.getMaxSemestre());
    }

    @Override
    public void eliminar(int id) {
        jdbcTemplate.update("DELETE FROM carreras WHERE id_carrera=?", id);
    }

    @Override
    public List<Carrera> listarCarreras() {
        return jdbcTemplate.query("SELECT * FROM carreras", new CarrerasLoad());
    }

    @Override
    public Carrera encontrarCarrera(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM carreras WHERE id_carrera=?", new CarrerasLoad(), id);
    }
    
    
}
