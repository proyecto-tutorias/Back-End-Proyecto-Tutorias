/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.NotificacionesServices;

import com.tutorias.NotificacionesDao.NotificacionesDao;
import com.tutorias.domain.Notificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificacionesRepositorio implements NotificacionesDao{

    private JdbcTemplate jdbcTemplate;

    public NotificacionesRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override 
    public void insertar(Notificacion notificacion){
        jdbcTemplate.update("INSERT INTO notificaciones(descripcion, id_tutor, id_tutoria, activo, id_tipo_notificacion, id_destinatario)"
                + "VALUES(?,?,?,?,?,?)",
                notificacion.getDescripcion(),
                notificacion.getId_Tutor(),
                notificacion.getId_Tutoria(),
                notificacion.getActivo(),
                notificacion.getId_tipo_notificacion(),
                notificacion.getId_destinatario());
    }

    @Override
    public List<Notificacion> listarNotificaciones() {
        try{
            return jdbcTemplate.query("SELECT * FROM notificaciones", new NotificacionesLoad());
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
    
    @Override
    public List<Notificacion> encontrarPorTutoria(int id){
        return jdbcTemplate.query("SELECT * FROM notificaciones WHERE id_tutoria=?", new NotificacionesLoad(), id);
    }

    

    @Override
    public Notificacion encontrar(int id) {
           try{
            return jdbcTemplate.queryForObject("SELECT * FROM notificaciones WHERE id_notificacion=?", new NotificacionesLoad(), id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void activar(int id) {
        jdbcTemplate.update("UPDATE notificaciones SET activo = 1 WHERE id_notificacion=?", id);
    }

    @Override
    public void desactivar(int id) {
        jdbcTemplate.update("UPDATE notificaciones SET activo = 0 WHERE id_notificacion=?", id);
    }

    @Override
    public List<Notificacion> listarNotificacionesTutor() {
        try{
            return jdbcTemplate.query("SELECT * FROM notificaciones WHERE id_destinatario = 1", new NotificacionesLoad());
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Notificacion> listarNotificacionesEstudiante() {
        try{
            return jdbcTemplate.query("SELECT * FROM notificaciones WHERE id_destinatario = 2", new NotificacionesLoad());
        }catch(EmptyResultDataAccessException e){
            return null;
        }    
    }

    
  
}
