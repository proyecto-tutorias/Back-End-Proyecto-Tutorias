/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.web;

import com.tutorias.AreaServices.AreaServices;
import com.tutorias.CarrerasServices.CarrerasServices;
import com.tutorias.TutorServices.TutorServices;
import com.tutorias.TutoriasServices.TutoriasServices;
import com.tutorias.UsuarioDao.UsuarioDao;
import com.tutorias.UsuarioServices.UsuarioServices;
import com.tutorias.domain.Area;
import com.tutorias.domain.Carrera;
import com.tutorias.domain.Tutor;
import com.tutorias.domain.Tutoria;
import com.tutorias.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@Slf4j
public class ControladorRest {
    
    @Autowired
    UsuarioServices ususer;
    
    
    @Autowired
    TutorServices tutoser;
    
    @Autowired
    TutoriasServices tutoriaser;
    
    @Autowired
    AreaServices areaser;
    
    @Autowired
    CarrerasServices carreser;
    
    
    Usuario ususesion;
    Tutor tutorsesion;
    List<Tutoria> tutorias;
    List<Usuario> usuarios;
    List<Area> areas;
    List<Carrera> carreras;
    List<Usuario> usuariosConTutorias = new ArrayList<>();
    
    
    @GetMapping("/")
    public String inicio(Usuario usuario){
        return "inicioSesion";
    }
    
    @GetMapping("/notificaciones")
    public String notificaciones(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        return "notificaciones";
    }
    @GetMapping("/mis_tutorias")
    public String misTutorias(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        return "misTutorias";
    }
    
    
    
    @GetMapping("/solicitud_tutoria")
    public String solicitud_tutoria(Model modelo, Tutoria tutoria){
        areas = areaser.listarAreas();
        carreras = carreser.listarCarreras();
        modelo.addAttribute("areas",areas);
        modelo.addAttribute("carreras",carreras);
        modelo.addAttribute("ususesion", ususesion);
        return "solicitud_tutoria";
    }
    
    @GetMapping("/tutorias")
    public String tutorias(Model modelo){
        
        tutorsesion = tutoser.encontrarTutor(ususesion.getId_usuario());
        tutorias = tutoriaser.listarTutorias();
        usuarios = ususer.listarUsuarios();
        getUsuariosConTutorias();
        
        
        modelo.addAttribute("usututorias", usuariosConTutorias);
        modelo.addAttribute("ususesion",ususesion );
        modelo.addAttribute("tutorsesion",tutorsesion );
        modelo.addAttribute("tutorias",tutorias );
        
        return "tutorias";
    }
    
    @GetMapping("/requisitos_tutor")
    public String requisitos_tutor(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        return "requisitos_tutor";
    }
    
    @GetMapping("/perfil")
    public String perfil(Model modelo){
         modelo.addAttribute("ususesion", ususesion);
        return "miPerfil";
    }
    @GetMapping("/lista_usuarios")
    public String listaUsuarios(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        return "listadoUsuarios";
    }
    @GetMapping("/tutorias_asignadas")
    public String tutoriasAsignadas(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        return "tutoriasAsignadas";
    }
    
    @GetMapping("/registro")
    public String registro(Usuario usuario){
        return "registro";
    }
    
    @PostMapping("/insertarUsuario")
    public String insertarUsuario(Usuario usuario){
        usuario.setActivo(1);
        usuario.setTipo_usuario("usuario");
        ususer.insertarUsuario(usuario);
        return "redirect:/tutorias";
    }
    @PostMapping("/comprobarUsuario")
    public String comprobarUsuario(Usuario usuario){
        
        if(!(usuario.getLogin().equals("")) && !(usuario.getPassword().equals(""))){
            ususesion = ususer.encontrarUsuarioporLogin(usuario.getLogin(), usuario.getPassword());
            if(ususesion != null && ususesion.getActivo() == 1){
                return "redirect:/tutorias";
            }
            
        }
        

        return "redirect:/";
    }

    public void getUsuariosConTutorias(){
        
        if(tutorias != null && !tutorias.isEmpty()){
            for(Tutoria tutoria : tutorias){
                for(Usuario usuario : usuarios){
                    if(tutoria.getIdEstudiante() == usuario.getId_usuario()){
                        usuariosConTutorias.add(usuario);
                    }
                }
            }
        }
    }
    
    @PostMapping("/insertarTutoria")
    public String insertarTutoria(Tutoria tutoria){
        tutoria.setIdEstado(1);
        tutoria.setActivo(1);
        tutoria.setIdEstudiante(ususesion.getId_usuario());
        tutoriaser.insertarTutoria(tutoria);
        return "redirect:/tutorias";
    
    }
    
    
}



