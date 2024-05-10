/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.CalificacionesServices;

import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.Calificacion;
import com.tutorias.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DBZve
 */
public class CalificacionesLoad implements RowMapper<Calificacion>{
    @Override
    public Calificacion mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Calificacion calificacion = new Calificacion();

        calificacion.setIdCalificacion(rs.getInt("id_calificacion"));
        calificacion.setComentario(rs.getString("comentario"));
        calificacion.setPuntaje(rs.getDouble("puntaje"));

        return calificacion;
    }
}
