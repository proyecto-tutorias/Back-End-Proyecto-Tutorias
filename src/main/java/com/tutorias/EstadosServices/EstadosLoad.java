/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.EstadosServices;

import com.tutorias.EstudianteServices.*;
import com.tutorias.TutoriasServices.*;
import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class EstadosLoad implements RowMapper<Estado>{
    @Override
    public Estado mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Estado estado = new Estado();
        
        estado.setIdEstado(rs.getInt("id_estado"));
        estado.setDescripcion(rs.getString("descripcion"));
         

        return estado;
    }
}
