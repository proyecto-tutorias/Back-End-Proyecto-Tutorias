/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.config;

import com.tutorias.AreaServices.AreaRepositorio;
import com.tutorias.AreaServices.AreaServices;
import com.tutorias.CarrerasServices.CarrerasRepositorio;
import com.tutorias.CarrerasServices.CarrerasServices;
import com.tutorias.EstudianteServices.EstudianteRepositorio;
import com.tutorias.EstudianteServices.EstudianteServices;
import com.tutorias.TutorServices.TutorRepositorio;
import com.tutorias.TutorServices.TutorServices;
import com.tutorias.TutoriasServices.TutoriasRepositorio;
import com.tutorias.TutoriasServices.TutoriasServices;
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
    
    @Bean
    public AreaServices areser(AreaRepositorio arerep){
        return new AreaServices(arerep);
    }
    
    @Bean
    public TutorServices tutoser(TutorRepositorio tutorep){
        return new TutorServices(tutorep);
    }
    
    @Bean
    public TutoriasServices tutoriaser(TutoriasRepositorio tutoriasrep){
        return new TutoriasServices(tutoriasrep);
    }
    
    @Bean
    public EstudianteServices estuser(EstudianteRepositorio esturep){
        return new EstudianteServices(esturep);
    }
    
    @Bean
    public CarrerasServices carreser(CarrerasRepositorio carrep){
        return new CarrerasServices(carrep);
    }
    
}
