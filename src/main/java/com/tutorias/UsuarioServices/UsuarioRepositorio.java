/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.UsuarioServices;

import com.tutorias.UsuarioDao.UsuarioDao;
import com.tutorias.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        jdbcTemplate.update("INSERT INTO usuario(tipo_usuario, nombre, apellido,codigo_estudiante, password, login, id_carrera)" + 
                "VALUES (?,?,?,?,?,?,?)" ,
                usuario.getTipo_usuario() ,
                usuario.getNombre(), 
                usuario.getApellido() ,
                usuario.getCodigo_estudiante(), 
                usuario.getPassword(), 
                usuario.getLogin(),
                usuario.getId_carrera());
    }

    @Override
    public void eliminar(Usuario usuario) {
        jdbcTemplate.update("DELETE FROM usuario WHERE login=?", usuario.getId_usuario());
    }

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE login=?", new UsuarioLoad(), usuario.getId_usuario());
        return usuario;
    }

    @Override
    public Usuario encontrarUsuarioporLogin(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
