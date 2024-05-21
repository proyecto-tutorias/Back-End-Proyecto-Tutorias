    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AgendamientoTutoriaServices;

import com.tutorias.AgendamientoTutoriaDao.AgendamientoTutoriaDao;
import com.tutorias.AgendamientoTutoriaServices.*;
import com.tutorias.EstudianteDao.EstudianteDao;
import com.tutorias.TutorServices.*;
import com.tutorias.TutorDao.TutorDao;
import com.tutorias.domain.AgendamientoTutoria;
import com.tutorias.domain.Estudiante;
import com.tutorias.domain.Tutor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AgendamientoTutoriaRepositorio implements AgendamientoTutoriaDao{
    
    private JdbcTemplate jdbcTemplate;

    public AgendamientoTutoriaRepositorio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(AgendamientoTutoria agentuto) {
        jdbcTemplate.update("INSERT INTO agendamientotutoria(id_agendamiento,activo)" +
                "VALUES(?,?)", 
                agentuto.getIdAgendamiento(),
                agentuto.getActivo());
                
    }

    @Override
    public void desactivar(int id) {
        jdbcTemplate.update("UPDATE agendamientotutoria SET activo = 0 WHERE id_agendamiento=?", id);
    }

    @Override
    public void activar(int id) {
        jdbcTemplate.update("UPDATE agendamientotutoria SET activo = 1 WHERE id_agendamiento=?", id);    
    }

    @Override
    public AgendamientoTutoria encontrar(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM agendamientotutoria WHERE id_agendamiento=?", new AgendamientoTutoriaLoad(), id);
    }
    
    @Override
    public void insertarDatosReunion(AgendamientoTutoria agentuto){
        String sentencia ="update agendamientotutoria set url_reunion='"+ agentuto.getURLReunion()+ "', id_plataforma_reunion="+agentuto.getIdPlataformaReunion()+" where id_agendamiento="+ agentuto.getIdAgendamiento();
        
        jdbcTemplate.update(sentencia);
        
    }
    
    @Override
    public void insertarFecha(AgendamientoTutoria agentuto){
        String sentencia ="update agendamientotutoria set datos_adicionales='"+ agentuto.getDatos_adicionales()+ "', fecha_agendamiento='"+agentuto.getFechaAgendamiento()+"' where id_agendamiento="+ agentuto.getIdAgendamiento();
        
        jdbcTemplate.update(sentencia);
    }
    

    @Override
    public List<AgendamientoTutoria> listar() {
        return jdbcTemplate.query("SELECT * FROM agendamientotutoria", new AgendamientoTutoriaLoad());
    }

    
  
    
    
    
   
    
}
