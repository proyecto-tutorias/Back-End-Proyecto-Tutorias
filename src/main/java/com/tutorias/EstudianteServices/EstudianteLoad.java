/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstudianteServices;

import com.tutorias.TutoriasServices.*;
import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Tutoria;
import com.tutorias.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class EstudianteLoad implements RowMapper<Estudiante>{
    @Override
    public Estudiante mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Estudiante estudiante = new Estudiante();
        
        estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
         

        return estudiante;
    }
}
