/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.UsuarioServices;

import com.tutorias.domain.Usuario;
import java.util.List;


public class UsuarioServices {

    public UsuarioServices(UsuarioRepositorio usurep) {
        this.usurepo = usurep;
    }
    
    private UsuarioRepositorio usurepo;
    
    public void insertarUsuario(Usuario usuario){
        usurepo.insertar(usuario);
    }
    
    
    
    
}
