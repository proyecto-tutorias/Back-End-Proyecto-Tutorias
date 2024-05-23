/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.UsuarioServices;

import com.tutorias.domain.Usuario;
import java.sql.SQLException;
import java.util.List;


public class UsuarioServices {

    public UsuarioServices(UsuarioRepositorio usurep) {
        this.usurepo = usurep;
    }
    
    private UsuarioRepositorio usurepo;
    
    public void insertarUsuario(Usuario usuario){
        usurepo.insertar(usuario);
    }
    
    public Usuario encontrarUsuario(int id){
        return usurepo.encontrarUsuario(id);
    }
    
    public void desactivarUsuario(int id){
        usurepo.desactivarUsuario(id);
    }
    public void activarUsuario(int id){
        usurepo.activarUsuario(id);
    }
    
    public List<Usuario> listarUsuarios(){
        return usurepo.listarUsuarios();
    }
    
    public Usuario encontrarUsuarioporLogin(String login, String password){
        
        return usurepo.encontrarUsuarioporLogin(login, password);
        
        
        
    }
    
    public void modificarUsuario(Usuario usuario){
        usurepo.modificarUsuario(usuario);
    }
    
    
    
}
