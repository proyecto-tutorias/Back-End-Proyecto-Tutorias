/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.config;

import com.tutorias.AgendamientoTutoriaServices.AgendamientoTutoriaRepositorio;
import com.tutorias.AgendamientoTutoriaServices.AgendamientoTutoriaServices;
import com.tutorias.AreaServices.AreaRepositorio;
import com.tutorias.AreaServices.AreaServices;
import com.tutorias.CalificacionesServices.CalificacionesRepositorio;
import com.tutorias.CalificacionesServices.CalificacionesServices;
import com.tutorias.CarrerasServices.CarrerasRepositorio;
import com.tutorias.CarrerasServices.CarrerasServices;
import com.tutorias.EstadosServices.EstadosRepositorio;
import com.tutorias.EstadosServices.EstadosServices;
import com.tutorias.EstudianteServices.EstudianteRepositorio;
import com.tutorias.EstudianteServices.EstudianteServices;
import com.tutorias.NotificacionesServices.NotificacionesRepositorio;
import com.tutorias.NotificacionesServices.NotificacionesServices;
import com.tutorias.PlataformasServices.PlataformasRepositorio;
import com.tutorias.PlataformasServices.PlataformasServices;
import com.tutorias.RangosServices.RangosRepositorio;
import com.tutorias.RangosServices.RangosServices;
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
    
    @Bean
    public EstadosServices estaser(EstadosRepositorio estarep){
        return new EstadosServices(estarep);
    }
    
    @Bean
    public NotificacionesServices notiser(NotificacionesRepositorio notirep){
        return new NotificacionesServices(notirep);
    }
    @Bean
    public AgendamientoTutoriaServices agentutoser(AgendamientoTutoriaRepositorio agentutorep){
        return new AgendamientoTutoriaServices(agentutorep);
    }
    
    @Bean
    public PlataformasServices plataser(PlataformasRepositorio platarep){
        return new PlataformasServices(platarep);
    }
    @Bean
    public CalificacionesServices caliser(CalificacionesRepositorio calirep){
        return new CalificacionesServices(calirep);
    }
    
    @Bean
    public RangosServices ranser(RangosRepositorio ranrep){
        return new RangosServices(ranrep);
    }
    
}
