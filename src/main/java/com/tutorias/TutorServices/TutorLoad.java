/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutorServices;


import com.tutorias.domain.Tutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DBZve
 */
public class TutorLoad implements RowMapper<Tutor>{
    @Override
    public Tutor mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Tutor tutor = new Tutor();
        
        tutor.setIdTutor(rs.getInt("id_tutor"));
        tutor.setIdEspecialidad(rs.getInt("id_especialidad"));
        tutor.setIdRango(rs.getInt("id_rango"));
        tutor.setPromedioPuntaje(rs.getDouble("prom_puntaje"));
        tutor.setActivo(rs.getInt("activo"));

        return tutor;
    }
}
