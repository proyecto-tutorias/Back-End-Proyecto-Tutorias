/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AreaServices;

import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.Area;
import com.tutorias.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DBZve
 */
public class AreaLoad implements RowMapper<Area>{
    @Override
    public Area mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Area area = new Area();
        
        area.setIdArea(rs.getInt("id_area"));
        area.setDescripcion(rs.getString("descripcion"));
        

        return area;
    }
}
