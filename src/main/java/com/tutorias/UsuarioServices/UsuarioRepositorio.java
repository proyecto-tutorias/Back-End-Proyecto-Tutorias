/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.UsuarioServices;

import com.tutorias.UsuarioDao.UsuarioDao;
import com.tutorias.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository 
public class UsuarioRepositorio implements UsuarioDao{

    private JdbcTemplate jdbcTemplate;

    public UsuarioRepositorio(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(Usuario usuario) {
        jdbcTemplate.update("INSERT INTO usuario(tipo_usuario, nombre, apellido,codigo_estudiante, password, login, id_carrera, activo)" + 
                "VALUES (?,?,?,?,?,?,?,?)" ,
                usuario.getTipo_usuario() ,
                usuario.getNombre(), 
                usuario.getApellido() ,
                usuario.getCodigo_estudiante(), 
                usuario.getPassword(), 
                usuario.getLogin(),
                usuario.getId_carrera(),
                usuario.getActivo());
    }

    @Override
    public void eliminar(Usuario usuario) {
        jdbcTemplate.update("DELETE FROM usuario WHERE login=?", usuario.getId_usuario());
    }

    @Override
    public Usuario encontrarUsuario(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE id_usuario=?", new UsuarioLoad(), id);
     
    }

    @Override
    public Usuario encontrarUsuarioporLogin(String login, String password){
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE login=? AND password=?", new UsuarioLoad(), login, password);
            
        }catch(EmptyResultDataAccessException e){
            return null;
        }
   
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return jdbcTemplate.query("SELECT * FROM usuario", new UsuarioLoad()); 
    }
    
    @Override
    public void desactivarUsuario(int id){
        jdbcTemplate.update("UPDATE usuario SET activo = 0 WHERE id_usuario=?",id);
    }
    
    @Override
    public void activarUsuario(int id){
        jdbcTemplate.update("UPDATE usuario SET activo = 1 WHERE id_usuario=?",id);
    }
    
    
    
    
    
}
