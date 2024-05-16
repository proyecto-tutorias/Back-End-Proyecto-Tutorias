/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.NotificacionesServices;

import com.tutorias.TutoriasServices.*;
import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.Tutoria;
import com.tutorias.domain.Notificacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class NotificacionesLoad implements RowMapper<Notificacion>{
    @Override
    public Notificacion mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Notificacion notificacion = new Notificacion();
        
        notificacion.setId_Tutor(rs.getInt("id_tutor"));
        notificacion.setIdNotificacion(rs.getInt("id_notificacion"));
        notificacion.setDescripcion(rs.getString("descripcion"));
        notificacion.setId_Tutoria(rs.getInt("id_tutoria"));
        notificacion.setActivo(rs.getInt("activo"));
        notificacion.setId_destinatario(rs.getInt("id_destinatario"));
        notificacion.setId_tipo_notificacion(rs.getInt("id_tipo_notificacion"));
         

        return notificacion;
    }
}
