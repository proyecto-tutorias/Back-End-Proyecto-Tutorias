/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CarrerasServices;


import com.tutorias.domain.Carrera;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DBZve
 */
public class CarrerasLoad implements RowMapper<Carrera>{
    @Override
    public Carrera mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Carrera carrera = new Carrera();
        
        carrera.setIdCarrera(rs.getInt("id_carrera"));
        carrera.setDescripcion(rs.getString("descripcion"));
        carrera.setMaxSemestre(rs.getInt("max_semestre"));
        carrera.setMinSemestre(rs.getInt("min_semestre"));

        return carrera;
    }
}
