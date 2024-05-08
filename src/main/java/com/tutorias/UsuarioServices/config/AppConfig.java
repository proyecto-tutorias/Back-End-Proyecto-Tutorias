/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.UsuarioServices.config;

import com.tutorias.UsuarioServices.UsuarioRepositorio;
import com.tutorias.UsuarioServices.UsuarioServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author DBZve
 */
@Configuration
public class AppConfig {
    
    
    @Bean
    public UsuarioServices ususer(UsuarioRepositorio usurep){
        return new UsuarioServices(usurep);
    }   
    
}
