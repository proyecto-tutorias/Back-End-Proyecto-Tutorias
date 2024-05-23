/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AgendamientoTutoriaServices;

import com.tutorias.EstudianteServices.*;
import com.tutorias.TutoriasServices.*;
import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Tutoria;
import com.tutorias.domain.AgendamientoTutoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class AgendamientoTutoriaLoad implements RowMapper<AgendamientoTutoria>{
    @Override
    public AgendamientoTutoria mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final AgendamientoTutoria agetuto = new AgendamientoTutoria();
        
        agetuto.setIdAgendamiento(rs.getInt("id_agendamiento"));
        agetuto.setURLReunion(rs.getString("url_reunion"));
        agetuto.setFechaAgendamiento(rs.getString("fecha_agendamiento"));
        agetuto.setIdPlataformaReunion(rs.getInt("id_plataforma_reunion"));
        agetuto.setActivo(rs.getInt("activo"));
        agetuto.setDatos_adicionales(rs.getString("datos_adicionales"));
        agetuto.setHora_inicio(rs.getString("hora_inicio"));
        agetuto.setHora_fin(rs.getString("hora_fin"));
        agetuto.setFecha_inicio(rs.getString("fecha_inicio"));
        agetuto.setFecha_fin(rs.getString("fecha_fin"));
        agetuto.setHora_def(rs.getString("hora_def"));
         

        return agetuto;
    }
}
