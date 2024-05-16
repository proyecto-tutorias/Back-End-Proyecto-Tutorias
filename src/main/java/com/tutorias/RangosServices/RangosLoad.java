/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.RangosServices;


import com.tutorias.TutorServices.*;
import com.tutorias.domain.Rango;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DBZve
 */
public class RangosLoad implements RowMapper<Rango>{
    @Override
    public Rango mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Rango rango = new Rango();
        
        rango.setIdRango(rs.getInt("id_rango"));
        rango.setDescripcion(rs.getString("descripcion"));
      

        return rango;
    }
}
