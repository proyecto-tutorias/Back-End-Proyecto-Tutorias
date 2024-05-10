/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.TutoriasServices;

import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.Tutoria;
import com.tutorias.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class TutoriasLoad implements RowMapper<Tutoria>{
    @Override
    public Tutoria mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Tutoria tutoria = new Tutoria();
        
        tutoria.setIdTutoria(rs.getInt("id_tutoria"));
        tutoria.setDescripcion(rs.getString("descripcion"));
        tutoria.setPrecio(rs.getDouble("precio"));
        tutoria.setIdArea(rs.getInt("id_area"));
        tutoria.setFechaLimite(rs.getString("fecha_limite"));
        tutoria.setIdEstudiante(rs.getInt("id_estudiante"));
        tutoria.setTitulo(rs.getString("titulo"));
        tutoria.setActivo(rs.getInt("activo"));
        tutoria.setIdEstado(rs.getInt("id_estado"));
        tutoria.setIdCarrera(rs.getInt("id_carrera"));
         

        return tutoria;
    }
}
