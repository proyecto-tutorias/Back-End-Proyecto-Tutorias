/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.UsuarioDao;

import com.tutorias.domain.Usuario;
import java.util.List;

/**
 *
 * @author DBZve
 */
public interface UsuarioDao {
    
    void insertar(Usuario usuario);
    void eliminar(Usuario usuario);
    Usuario encontrarUsuario(Usuario usuario);
    Usuario encontrarUsuarioporLogin(Usuario usuario);
    List<Usuario> listarUsuarios();
    
    
    
}
