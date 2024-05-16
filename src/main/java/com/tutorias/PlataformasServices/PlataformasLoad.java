/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.PlataformasServices;

import com.tutorias.TutoriasServices.*;
import com.tutorias.UsuarioServices.*;
import com.tutorias.domain.PlataformaReunion;
import com.tutorias.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class PlataformasLoad implements RowMapper<PlataformaReunion>{
    @Override
    public PlataformaReunion mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final PlataformaReunion platareu = new PlataformaReunion();
        
        platareu.setIdPlataformaReunion(rs.getInt("id_plataforma_reunion"));
        platareu.setDescripcion(rs.getString("descripcion"));
         

        return platareu;
    }
}
