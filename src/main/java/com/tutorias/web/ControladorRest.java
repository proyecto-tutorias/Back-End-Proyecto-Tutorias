/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.web;

import com.tutorias.UsuarioDao.UsuarioDao;
import com.tutorias.UsuarioServices.UsuarioServices;
import com.tutorias.domain.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author DBZve
 * 
 * 
 */


@Controller
@Slf4j
public class ControladorRest {
    
    @Autowired
    UsuarioServices ususer;
    
    @GetMapping("/")
    public String inicio(Usuario usuario){
       
        
        return "inicioSesion";
    }
    
    @GetMapping("/notificaciones")
    public String notificaciones(){
        return "notificaciones";
    }
    
    @GetMapping("/solicitud_tutoria")
    public String solicitud_tutoria(){
        return "solicitud_tutoria";
    }
    
    @GetMapping("/tutorias")
    public String tutorias(){
        return "tutorias";
    }
    
    @GetMapping("/requisitos_tutor")
    public String requisitos_tutor(){
        return "requisitos_tutor";
    }
    
    @GetMapping("/perfil")
    public String perfil(){
        return "miPerfil";
    }
    
    @GetMapping("/registro")
    public String registro(Usuario usuario){
        return "registro";
    }
    
    @PostMapping("/insertarUsuario")
    public String insertarUsuario(Usuario usuario){
        ususer.insertarUsuario(usuario);
        return "redirect:/tutorias";
    }
    @PostMapping("/comprobarUsuario")
    public String comprobarUsuario(Usuario usuario){
//        for(Usuario usu :usudao.findAll()){
//           if(usu.getLogin().equals(usuario.getLogin()) && usu.getPassword().equals(usuario.getPassword())){
//               return "redirect:/tutorias";
//           }
//        
//        }
        
        return "redirect:/";
    }

    
    
}



