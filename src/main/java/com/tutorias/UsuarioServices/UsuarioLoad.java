/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.UsuarioServices;

import com.tutorias.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DBZve
 */
public class UsuarioLoad implements RowMapper<Usuario>{
    @Override
    public Usuario mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Usuario usuario = new Usuario();
        
        usuario.setNombre(rs.getString("nombre"));
        usuario.setCodigo_estudiante(rs.getInt("codigo_estudiante"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setId_carrera(rs.getInt("id_carrera"));
        usuario.setLogin(rs.getString("login"));
        usuario.setPassword(rs.getString("password"));
        usuario.setTipo_usuario(rs.getString("tipo_usuario"));
        usuario.setId_usuario(rs.getInt("id_usuario")); 
        usuario.setActivo(rs.getInt("activo"));
        usuario.setSemestre(rs.getInt("semestre"));

        return usuario;
    }
}
