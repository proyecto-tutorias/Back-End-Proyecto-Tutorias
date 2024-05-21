/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.web;

import com.tutorias.AgendamientoTutoriaServices.AgendamientoTutoriaServices;
import com.tutorias.AreaServices.AreaServices;
import com.tutorias.CalificacionesServices.CalificacionesServices;
import com.tutorias.CarrerasServices.CarrerasServices;
import com.tutorias.EstadosServices.EstadosServices;
import com.tutorias.EstudianteServices.EstudianteServices;
import com.tutorias.NotificacionesServices.NotificacionesServices;
import com.tutorias.PlataformasServices.PlataformasServices;
import com.tutorias.RangosServices.RangosServices;
import com.tutorias.TutorServices.TutorServices;
import com.tutorias.TutoriasServices.TutoriasServices;
import com.tutorias.UsuarioDao.UsuarioDao;
import com.tutorias.UsuarioServices.UsuarioServices;
import com.tutorias.domain.AgendamientoTutoria;
import com.tutorias.domain.Area;
import com.tutorias.domain.Calificacion;
import com.tutorias.domain.Carrera;
import com.tutorias.domain.Estado;
import com.tutorias.domain.Notificacion;
import com.tutorias.domain.Parametros;
import com.tutorias.domain.PlataformaReunion;
import com.tutorias.domain.Rango;
import com.tutorias.domain.Tutor;
import com.tutorias.domain.Tutoria;
import com.tutorias.domain.Usuario;
import jakarta.validation.Valid;
import static java.lang.String.format;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;





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
    
    @Autowired
    EstudianteServices estuser;
    
    @Autowired
    EstadosServices estaser;
    
    @Autowired
    NotificacionesServices notiser;
    
    @Autowired
    AgendamientoTutoriaServices agentutoser;
    
    @Autowired
    PlataformasServices plataser;
    
    @Autowired
    CalificacionesServices caliser;
    
    @Autowired
    RangosServices ranser;
    
    
    Usuario ususesion;
    Tutor tutorsesion;
    
    
    List<Tutoria> tutorias;
    
    List<Integer> semestres = new ArrayList<>();
    
    List<Area> areas;
    List<Carrera> carreras;
    List<Estado> estados;
    List<Tutoria> misTutorias;
    List<Usuario> usuariosConTutorias = new ArrayList<>();
    Tutoria tutoriaSeleccionada;
    List<Notificacion> notificaciones = new ArrayList<>();
    Notificacion notificacionActual;
    List<AgendamientoTutoria> tutoriasAsignadas = new ArrayList<>();
    List<PlataformaReunion> plataformas;
    List<Tutoria> tutoriasCopia;
    
    int agen_id;
    
    Parametros parametros = new Parametros();
    boolean filtroBusqueda = false;
    
    int destinatario_tutor = 1;
    int destinatario_estudiante = 2;
    
    List<Usuario> usuarios = new ArrayList<>();
    
    int aprobacion = 1;
    int informacion = 2;
    
    int semestreRegistro = 0;
  
    
    @GetMapping("/")
    public String inicio(Usuario usuario){
        ususesion = null;
        tutorsesion = null;
        return "inicioSesion";
    }
    
  
    
    @GetMapping("/notificaciones")
    public String notificaciones(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        
        List<Notificacion> notificacionesIterar = notiser.listarNotificaciones();
        notificaciones = new ArrayList<>();
        
        if(notificacionesIterar != null){
            for(Tutoria tutoria : tutorias){
                for(Notificacion notificacion : notificacionesIterar){
                    if(tutoria.getIdTutoria() == notificacion.getId_Tutoria() && notificacion.getActivo() == 1){
                        if(tutorsesion != null){
                            if(ususesion.getId_usuario() == notificacion.getId_Tutor() && notificacion.getId_destinatario() == destinatario_tutor){
                                notificaciones.add(notificacion);
                            } 
                        }
                        
                        if(ususesion.getId_usuario() == tutoria.getIdEstudiante() && notificacion.getId_destinatario() == destinatario_estudiante){
                            notificaciones.add(notificacion);
                        }
                    }
                }
            }
        }
        
        modelo.addAttribute("notificaciones", notificaciones);
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("parametros",parametros );
        
        return "notificaciones";
    }
    @GetMapping("/mis_tutorias")
    public String misTutorias(Model modelo, Calificacion calificacion){
        misTutorias = tutoriaser.listarMisTutorias(ususesion.getId_usuario());
        estados = estaser.listarEstados();
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("mis_tutorias", misTutorias);
        modelo.addAttribute("estados", estados);
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("parametros",parametros );
        
        return "misTutorias";
    }
    
    @PostMapping("busqueda")
    public String busqueda(Parametros parametros){
        
        if(!(parametros.getBusqueda().equals(""))){
            
            List<Tutoria> totalTutorias = tutoriaser.listarTutorias();
            tutorias = new ArrayList<>();
            filtroBusqueda = true;
            
            for(Tutoria t: totalTutorias){
                if(t.getTitulo().toLowerCase().contains(parametros.getBusqueda().toLowerCase())){
                    tutorias.add(t);
                }
            }
            
        }
        
        return "redirect:/tutorias";
    }
    
    @PostMapping("calificar_tutor")
    public String calificarTutor(@RequestParam int id, Calificacion calificacion){
        List<Notificacion> noti = notiser.encontrarPorTutoria(id);
        List<AgendamientoTutoria> agen = agentutoser.listar();
        
        int id_tutor = 0;
        
        for(Notificacion n : noti){
            for(AgendamientoTutoria ag : agen){
                if(n.getIdNotificacion() == ag.getIdAgendamiento()){
                    id_tutor = n.getId_Tutor();
                    calificacion.setIdCalificacion(ag.getIdAgendamiento());
                }
            }
        }
        
        
        
        caliser.insertarCalificacion(calificacion);
        tutoriaser.cambiarEstado(4, id);
        
        hacerPromPuntaje(id_tutor);
        
        return "redirect:/mis_tutorias";
    }
    
    public void hacerPromPuntaje(int id_tutor){
        double prom = 0;
        List<Notificacion> noti = notiser.listarNotificaciones();
        List<AgendamientoTutoria> agen = agentutoser.listar();
        List<Calificacion> cali = new ArrayList<>();
        
        for(Notificacion n: noti){
            for(AgendamientoTutoria ag: agen){
                if(n.getIdNotificacion() == ag.getIdAgendamiento() && n.getId_Tutor() == id_tutor){
                    cali.add(caliser.encontrarCalificacion(ag.getIdAgendamiento()));
                }
            }
        }
        
        for(Calificacion c : cali){
            prom = prom + c.getPuntaje();
        }
        
        prom = prom / cali.size();
        
        tutoser.insertarPromedio(prom, id_tutor);
          
        
    }
    
    @GetMapping("/informacion_tutoria")
    public String informacionTutoria(@RequestParam int id, Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("parametros",parametros );
        
        
        List<Notificacion> noti = notiser.encontrarPorTutoria(id);
        List<AgendamientoTutoria> agentuto = agentutoser.listar();
        AgendamientoTutoria agenActual = new AgendamientoTutoria();
        Notificacion notiActual = new Notificacion();
        plataformas = plataser.listarPlataformas();
        carreras = carreser.listarCarreras();
      
                
        for(Notificacion n : noti){
            for(AgendamientoTutoria ag : agentuto){
                if(ag.getIdAgendamiento() == n.getIdNotificacion()){
                    agenActual = ag;
                    notiActual = n;
                }
            }
        }
        
        Usuario usu = ususer.encontrarUsuario(notiActual.getId_Tutor());
        Tutor tutor = tutoser.encontrarTutor(usu.getId_usuario());
        tutor.setNombre(usu.getNombre());
        tutor.setApellido(usu.getApellido());
        tutor.setSemestre(usu.getSemestre());
        tutor.setId_carrera(usu.getId_carrera());
        
        modelo.addAttribute("tutor" ,tutor);
        modelo.addAttribute("carreras" ,carreras);
        modelo.addAttribute("plataformas" ,plataformas);
        modelo.addAttribute("agendamiento" ,agenActual);
        
        return "informacionTutoria";
    }
    
    @GetMapping("/solicitud_tutoria")
    public String solicitud_tutoria(Model modelo, Tutoria tutoria){
        carreras = carreser.listarCarreras();
        areas = areaser.listarAreas();
        modelo.addAttribute("areas",areas);
        modelo.addAttribute("carreras",carreras);
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("parametros",parametros );
        modelo.addAttribute("tutorsesion", tutorsesion);
        return "solicitud_tutoria";
    }
    
    @GetMapping("/tutorias")
    public String tutorias(Model modelo){
        
        carreras = carreser.listarCarreras();
        areas = areaser.listarAreas();
        
        usuariosConTutorias = new ArrayList<>();
        if(filtroBusqueda == false){
            tutorias = tutoriaser.listarTutorias();
            tutoriasCopia = tutoriaser.listarTutorias();
        }
        else{
            filtroBusqueda = false;
        }
      
        List<Notificacion> notificacionesIterar = notiser.listarNotificaciones();
        
        if(tutorsesion != null){
            for(Tutoria tutoria : tutorias){
                for(Notificacion notificacion: notificacionesIterar){
                    if(notificacion.getId_Tutoria() == tutoria.getIdTutoria() && notificacion.getId_tipo_notificacion() == aprobacion && notificacion.getId_Tutor() == tutorsesion.getIdTutor()){
                        tutoria.setPostulacion_disponible(0);
                    }
                }
            }
        }
        
        getUsuariosConTutorias();
        
        
        modelo.addAttribute("usututorias", usuariosConTutorias);
        modelo.addAttribute("ususesion",ususesion );
        modelo.addAttribute("tutorsesion",tutorsesion );
        modelo.addAttribute("tutorias",tutorias );
        modelo.addAttribute("parametros",parametros );
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("carreras", carreras);
        modelo.addAttribute("areas", areas);
        
        return "tutorias";
    }
    
    @PostMapping("/rechazar")
    public String rechazar(@RequestParam int id){
        notiser.desactivarNotificacion(id);
        Notificacion notiActual = notiser.encontrarNotificacion(id);
        Tutoria tutoActual = tutoriaser.encontrarTutoria(notiActual.getId_Tutoria());
        
        Notificacion noti = new Notificacion();
        
        noti.setDescripcion("Tu postulacion a la tutoria " + tutoActual.getTitulo() + " ha sido rechazada" );
        noti.setActivo(1);
        noti.setId_Tutor(notiActual.getId_Tutor());
        noti.setId_Tutoria(notiActual.getId_Tutoria());
        noti.setId_destinatario(destinatario_tutor);
        noti.setId_tipo_notificacion(informacion);
        
        notiser.insertarNotificacion(noti);
        
        return "redirect:/notificaciones";
    }
    
    @PostMapping("/filtrado")
    public @ResponseBody ResponseEntity filtrado(@RequestParam(value="idCarrera") int carrera,@RequestParam(value="idArea")int area ){
        
        ResponseEntity respuesta=null;
        
        
        
        if(area == 0 && carrera == 0){
            tutorias = tutoriaser.listarTutorias();   
        }
        
        if(area != 0 && carrera == 0){ 
            tutorias = tutoriaser.listarTutorias();
            List<Tutoria> elimTuto = new ArrayList();
            
            for(Tutoria tutoria : tutorias){
                if(tutoria.getIdArea() != area){
                    elimTuto.add(tutoria);
                }
            }
            
            tutorias.removeAll(elimTuto);
            
        }
        if(area == 0 && carrera != 0){
            tutorias = tutoriaser.listarTutorias();
            List<Tutoria> elimTuto = new ArrayList();
            
            for(Tutoria tutoria : tutorias){
                if(tutoria.getIdCarrera() != carrera){
                    elimTuto.add(tutoria);
                }
            }
                tutorias.removeAll(elimTuto);
            
            
        }
        if(area != 0 && carrera != 0){
            tutorias = tutoriaser.listarTutorias();
            List<Tutoria> elimTuto = new ArrayList();
            
            for(Tutoria tutoria : tutorias){
                if(tutoria.getIdArea() != area && tutoria.getIdCarrera() != carrera){
                    elimTuto.add(tutoria);
                }
                if(tutoria.getIdArea() == area && tutoria.getIdCarrera() != carrera){
                    elimTuto.add(tutoria);
                }
                if(tutoria.getIdArea() != area && tutoria.getIdCarrera() == carrera){
                    elimTuto.add(tutoria);
                }
            }
                tutorias.removeAll(elimTuto);
        }
        
        
        
        respuesta= new ResponseEntity(HttpStatus.OK);
        
        return respuesta;
    }
    
    
    @GetMapping("refrescarTutorias")
    public String refrescarTutorias(Model modelo){
        
        
        modelo.addAttribute("usututorias", usuariosConTutorias);
        modelo.addAttribute("ususesion",ususesion );
        modelo.addAttribute("tutorsesion",tutorsesion );
        modelo.addAttribute("tutorias",tutorias );
        modelo.addAttribute("parametros",parametros );
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("carreras", carreras);
        modelo.addAttribute("areas", areas);
        
        return "tutoriasFrag :: tutorias";
    }
    
    @GetMapping("/perfil_interesado")
    public String perfilInteresado(@RequestParam int id, Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("tutorsesion", tutorsesion);
        
        Notificacion noti = notiser.encontrarNotificacion(id);
        Usuario usuario = ususer.encontrarUsuario(noti.getId_Tutor());
        Tutor tutor = tutoser.encontrarTutor(noti.getId_Tutor());
        
        tutor.setNombre(usuario.getNombre());
        tutor.setApellido(usuario.getApellido());
        tutor.setSemestre(usuario.getSemestre());
        tutor.setId_carrera(usuario.getId_carrera());
        tutor.setCodigo_estudiante(usuario.getCodigo_estudiante());
        
        List<AgendamientoTutoria> agendamiento = agentutoser.listar();
        notificaciones = notiser.listarNotificaciones();
        List<Calificacion> calificaciones = caliser.listarCalificaciones();
        List<Notificacion> notiTutor = new ArrayList<>();
        List<Calificacion> caliTutor = new ArrayList<>();
        
        List<Tutoria> tutorias = tutoriaser.listarTutorias();
        List<Tutoria> tutoriaTutor = new ArrayList<>();
        areas = areaser.listarAreas();
        carreras = carreser.listarCarreras();
        List<Rango> rangos = ranser.listarRangos();
        
        for(Notificacion n: notificaciones){
            for(AgendamientoTutoria ag : agendamiento){
                if(ag.getIdAgendamiento() == n.getIdNotificacion() && n.getId_Tutor() == tutor.getIdTutor()){
                    notiTutor.add(n);
                
                    for(Calificacion c: calificaciones){
                        if(c.getIdCalificacion() == ag.getIdAgendamiento()){
                            caliTutor.add(c);
                        }
                    }
                }
            }
        }
        
        for(Notificacion n: notiTutor){
            for(Tutoria t : tutorias){
                if(t.getIdTutoria() == n.getId_Tutoria()){
                    tutoriaTutor.add(t);
                }
            }
        }
        
        
        modelo.addAttribute("tutor", tutor);
        modelo.addAttribute("notificaciones", notiTutor);
        modelo.addAttribute("calificaciones", caliTutor);
        modelo.addAttribute("areas", areas);
        modelo.addAttribute("tutorias", tutoriaTutor);
        modelo.addAttribute("carreras", carreras);
        modelo.addAttribute("rangos", rangos);
        modelo.addAttribute("parametros",parametros );
        modelo.addAttribute("tutorsesion", tutorsesion);

        
        return "perfilTutorInteresado";
    }
    
    @PostMapping("/agregar_notificacion")
    public String agregarNotificacion(@RequestParam int id){
        notiser.insertarNotificacion(generarNotificacionPostulacion(id));
        return "redirect:/tutorias";
        
        
    }
    
    public Notificacion generarNotificacionPostulacion(int id){
        tutoriaSeleccionada =  tutoriaser.encontrarTutoria(id);
        
        Notificacion notificacion = new Notificacion();
        notificacion.setDescripcion("Has recibido una respuesta al " + tutoriaSeleccionada.getTitulo() + " de parte del tutor " + tutorsesion.getNombre());
        notificacion.setId_Tutor(tutorsesion.getIdTutor());
        notificacion.setId_Tutoria(tutoriaSeleccionada.getIdTutoria());
        notificacion.setActivo(1);
        notificacion.setId_destinatario(destinatario_estudiante);
        notificacion.setId_tipo_notificacion(aprobacion);
        return notificacion;
        
    }
    
    
    @GetMapping("/requisitos_tutor")
    public String requisitos_tutor(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("parametros",parametros );
        return "requisitos_tutor";
    }
    
    @GetMapping("/perfil")
    public String perfil(Model modelo){
        carreras = carreser.listarCarreras();
        
        if(tutorsesion != null){
            List<AgendamientoTutoria> agendamiento = agentutoser.listar();
            notificaciones = notiser.listarNotificaciones();
            List<Calificacion> calificaciones = caliser.listarCalificaciones();
            List<Notificacion> notiTutor = new ArrayList<>();
            List<Calificacion> caliTutor = new ArrayList<>();

            List<Tutoria> tutorias = tutoriaser.listarTutorias();
            List<Tutoria> tutoriaTutor = new ArrayList<>();
            areas = areaser.listarAreas();
            carreras = carreser.listarCarreras();
            List<Rango> rangos = ranser.listarRangos();

            for(Notificacion n: notificaciones){
                for(AgendamientoTutoria ag : agendamiento){
                    if(ag.getIdAgendamiento() == n.getIdNotificacion() && n.getId_Tutor() == tutorsesion.getIdTutor()){
                        notiTutor.add(n);

                        for(Calificacion c: calificaciones){
                            if(c.getIdCalificacion() == ag.getIdAgendamiento()){
                                caliTutor.add(c);
                            }
                        }
                    }
                }
            }

            for(Notificacion n: notiTutor){
                for(Tutoria t : tutorias){
                    if(t.getIdTutoria() == n.getId_Tutoria()){
                        tutoriaTutor.add(t);
                    }
                }
            }
            
            

            modelo.addAttribute("notificaciones", notiTutor);
            modelo.addAttribute("calificaciones", caliTutor);
            modelo.addAttribute("tutorias", tutoriaTutor);
            modelo.addAttribute("rangos", rangos);



        }
        
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("parametros",parametros );
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("carreras", carreras);
        modelo.addAttribute("areas", areas);
        return "miPerfil";
    }
    @GetMapping("/lista_usuarios")
    public String listaUsuarios(Model modelo){
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("parametros",parametros );
        return "listadoUsuarios";
    }
    @GetMapping("/tutorias_asignadas")
    public String tutoriasAsignadas(Model modelo){
        
        List<Tutoria> tutoriasA = obtenerTutoriasAsignadas();
        estados = estaser.listarEstados();
        modelo.addAttribute("tutorias", tutoriasA);
        modelo.addAttribute("estados", estados);
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("tutoasignadas", tutoriasAsignadas);
        modelo.addAttribute("plataformas", plataformas);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("parametros",parametros );
        
        
        return "tutoriasAsignadas";
    }
    
    public List<Tutoria> obtenerTutoriasAsignadas(){
        
        List<Tutoria> tutoria = new ArrayList<>();
        tutoriasAsignadas = new ArrayList<>();
        
        plataformas = new ArrayList<>();
        
        List<AgendamientoTutoria> tutoasigIterar = agentutoser.listar();
        
        for(AgendamientoTutoria aget : tutoasigIterar){
            Notificacion noti = notiser.encontrarNotificacion(aget.getIdAgendamiento());
            if(ususesion.getId_usuario() == noti.getId_Tutor()){
                tutoriasAsignadas.add(aget);
                Tutoria tuto = tutoriaser.encontrarTutoria(noti.getId_Tutoria());
                tutoria.add(tuto);
                usuarios.add(ususer.encontrarUsuario(tuto.getIdEstudiante()));
                PlataformaReunion pl = plataser.encontrarPlataforma(aget.getIdPlataformaReunion());
                if(pl == null){
                    PlataformaReunion p = new PlataformaReunion();
                    p.setDescripcion("No asignada");
                    plataformas.add(p);
                }
                else{
                    plataformas.add(pl);
                }
                
                
            }
        }
        
        return tutoria;
        
        
    }
    
    
    @GetMapping("/registro")
    public String registro(Usuario usuario, Model modelo){
        carreras = carreser.listarCarreras();
        modelo.addAttribute("carreras", carreras);
        return "registro";
    }
    @GetMapping("/agendar_tutoria")
    public String agendarTutoria(@RequestParam int id, @RequestParam String tipo,Model modelo){
        
        AgendamientoTutoria agentuto = new AgendamientoTutoria();
        if(tipo.equals("notificacion_insertar")){
            notificacionActual = notiser.encontrarNotificacion(id);
            agentuto.setIdAgendamiento(id);
            agentutoser.insertar(agentuto);
        }
        if(tipo.equals("notificacion")){
            agen_id = id;
            notificacionActual = notiser.encontrarNotificacion(id);
            
        }
        else{
            List<Notificacion> noti = notiser.encontrarPorTutoria(id);
            List<AgendamientoTutoria> ag = agentutoser.listar();
            
            for(Notificacion n : noti){
                
                for(AgendamientoTutoria a : ag){
                    if(a.getIdAgendamiento() == n.getIdNotificacion()){
                        notificacionActual = n;
                    }
                }
                
            }
            agen_id = notificacionActual.getIdNotificacion();
           
            
            
        }
        
      
        
        tutoriaSeleccionada = tutoriaser.encontrarTutoria(notificacionActual.getId_Tutoria());
        Tutor tutor = infoTutor(notificacionActual.getId_Tutor());
        
        String carrera = carreraTutor(tutor);
        modelo.addAttribute("agentuto", agentuto);
        tutoriaser.cambiarEstado(2, tutoriaSeleccionada.getIdTutoria());
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("tutoriaSeleccionada", tutoriaSeleccionada);
        modelo.addAttribute("tutor", tutor);
        modelo.addAttribute("carrera", carrera);
        modelo.addAttribute("tutorsesion",tutorsesion);
        modelo.addAttribute("parametros",parametros );
        return "agendamientoTutoria";
    }
    
    
    public Tutor infoTutor(int id){
        
        Tutor tutor = tutoser.encontrarTutor(id);
        Usuario u = ususer.encontrarUsuario(id);
        
        tutor.setNombre(u.getNombre());
        tutor.setApellido(u.getApellido());
        tutor.setId_carrera(u.getId_carrera());
        
        return tutor;
        
    }
    
    public String carreraTutor(Tutor tutor){
        carreras = carreser.listarCarreras();
        String carre = "";
        for(Carrera carrera: carreras){
            if(carrera.getIdCarrera() == tutor.getId_carrera()){
                carre = carrera.getDescripcion();
            }
        }
        return carre;
        
    }
    
    @PostMapping("agregarAgendamiento")
    public String agregarAgendamiento(AgendamientoTutoria agentuto){
        if(!(agentuto.getFechaAgendamiento().equals("")) && !(agentuto.getDatos_adicionales().equals(""))){
            agentuto.setIdAgendamiento(agen_id);
            agentutoser.insertarFecha(agentuto);
            notiser.desactivarNotificacion(notificacionActual.getIdNotificacion());
            notiser.insertarNotificacion(agregarNotificacionInformacion(notificacionActual));
            tutoriaser.cambiarEstado(3, notificacionActual.getId_Tutoria());
            return "redirect:/notificaciones";
        }
        return "redirect:/agendar_tutoria?id=" + notificacionActual.getIdNotificacion() + "&tipo=notificacion";
        
    }
    
    public Notificacion agregarNotificacionInformacion(Notificacion notiactual){
        Tutoria tutoria = tutoriaser.encontrarTutoria(notiactual.getId_Tutoria());
        Usuario usuario = ususer.encontrarUsuario(tutoria.getIdEstudiante());
        Notificacion notificacion = new Notificacion();
        notificacion.setDescripcion("El estudiante " + usuario.getLogin() + " ha aceptado que seas su tutor en el la tutoria '" + tutoria.getTitulo() + "'.");
        notificacion.setId_Tutor(notiactual.getId_Tutor());
        notificacion.setId_Tutoria(notiactual.getId_Tutoria());
        notificacion.setId_destinatario(destinatario_tutor);
        notificacion.setActivo(1);
        notificacion.setId_tipo_notificacion(informacion);
        return notificacion;
        
    }
    
    
    @PostMapping("/insertarUsuario")
    public String insertarUsuario(@Valid Usuario usuario, BindingResult resultado, Model modelo){
        modelo.addAttribute("carreras", carreras);
        
        
        
        if(!(usuario.getPassword().equals(usuario.getRepPassword()))){
            modelo.addAttribute("errorContraseña", "Confirmar que las contraseñas coincidan");
            return "registro";
            
        }
        
        if(resultado.hasErrors()){
            return "registro";
        }
        
        while(semestreRegistro == 0){
            if(semestreRegistro != 0){
                break;
            }
        }
        
        usuario.setActivo(1);
        usuario.setTipo_usuario("usuario");
        usuario.setSemestre(semestreRegistro);
        ususer.insertarUsuario(usuario);
        ususesion = ususer.encontrarUsuarioporLogin(usuario.getLogin(), usuario.getPassword());
        estuser.insertarEstudiante(ususesion.getId_usuario());
        
        
        return "redirect:/tutorias";
    }
    
    
    @PostMapping("/obtenerCarrera")
    public @ResponseBody ResponseEntity obtenerCarrera(@RequestParam(value="idCarrera") int id_carrera){
        
        Carrera carrera = carreser.encontrarCarrera(id_carrera);
        
        semestres = new ArrayList<>();
        
        for(int i = carrera.getMinSemestre(); i<= carrera.getMaxSemestre(); i++){
            semestres.add(i);
        }
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping("/obtenerSemestre")
    public @ResponseBody ResponseEntity obtenerSemestre(@RequestParam(value="semestre") int semestre){
        
        semestreRegistro = semestre;
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
    
    
    
    @GetMapping("/listaSemestre")
    public String listaSemestre(Model modelo){
        modelo.addAttribute("semestres", semestres);
        return "semestreFrag :: listaSemestre";
        
    }
    
    
    @PostMapping("/comprobarUsuario")
    public String comprobarUsuario(@Valid Usuario usuario, BindingResult resultado, Model modelo){
        
      
        
        if(resultado.getFieldErrorCount("login") > 0 && resultado.getFieldErrorCount("password") > 0){
            return "inicioSesion";
        }
      
        if(resultado.getFieldErrorCount("login") == 0 && resultado.getFieldErrorCount("password") > 0){
            return "inicioSesion";
        }
      
        if(resultado.getFieldErrorCount("login") > 0 && resultado.getFieldErrorCount("password") == 0){
            return "inicioSesion";
        }
      
        ususesion = ususer.encontrarUsuarioporLogin(usuario.getLogin(), usuario.getPassword());
        
        if(ususesion == null){
            modelo.addAttribute("errorSesion", "Usuario o Contraseña invalido");
            return "inicioSesion";
        }
        
        if(ususesion != null && ususesion.getActivo() == 1){
            tutorsesion = tutoser.encontrarTutor(ususesion.getId_usuario());

            if(tutorsesion != null){
                tutorsesion.setNombre(ususesion.getNombre());
                tutorsesion.setApellido(ususesion.getApellido());
                tutorsesion.setLogin(ususesion.getLogin());
                tutorsesion.setSemestre(ususesion.getSemestre());
                tutorsesion.setId_carrera(ususesion.getId_carrera());
                //tutoriasAsignadas = tutoriaser.listarTutoriasAsignadas(ususesion.getId_usuario());
            }


        }
        return "redirect:/tutorias";
        
        

       
    }

    public void getUsuariosConTutorias(){
        
        if(tutorias != null && !tutorias.isEmpty()){
            for(Tutoria tutoria : tutorias){
                Usuario usuario = ususer.encontrarUsuario(tutoria.getIdEstudiante());
                usuariosConTutorias.add(usuario);
            }
        }
    }
    
    @PostMapping("/insertarTutoria")
    public String insertarTutoria(@Valid Tutoria tutoria, BindingResult resultado, Model modelo) throws ParseException{
        
        carreras = carreser.listarCarreras();
        areas = areaser.listarAreas();
        modelo.addAttribute("areas",areas);
        modelo.addAttribute("carreras",carreras);
        modelo.addAttribute("ususesion", ususesion);
        modelo.addAttribute("parametros",parametros );
        modelo.addAttribute("tutorsesion", tutorsesion);
        
        
        if(resultado.hasErrors()){
            return "solicitud_tutoria";
        }
        
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        Date date = formato.parse(tutoria.getFechaLimite());
        
        Instant da = date.toInstant();
        Instant fechaActual = ZonedDateTime.now().toInstant();
        

             
        
        if(da.isBefore(fechaActual)){
            modelo.addAttribute("errorFecha", "Fecha no puede ser antes de la fecha actual");
            return "solicitud_tutoria";
        }
        
        
        tutoria.setIdEstado(1);
        tutoria.setActivo(1);
        tutoria.setPostulacion_disponible(1);
        tutoria.setIdEstudiante(ususesion.getId_usuario());
        tutoriaser.insertarTutoria(tutoria);
        return "redirect:/tutorias";
    
    }
    
    @GetMapping("edicion_vista_tutor")
    public String edicionVistaTutor(@RequestParam int id, Model modelo){

        
        
        AgendamientoTutoria agentuto = agentutoser.encontrar(id);
        plataformas = plataser.listarPlataformas();
        
        carreras = carreser.listarCarreras();
        
        modelo.addAttribute("id", id);
        modelo.addAttribute("agentuto", agentuto);
        modelo.addAttribute("plataformas", plataformas);
        modelo.addAttribute("tutorsesion", tutorsesion);
        modelo.addAttribute("carreras", carreras);
        modelo.addAttribute("parametros",parametros );
        
        return "edicionTutoriaVistaTutor";
        
    }
    
    @PostMapping("tutor_edicion")
    public String edicionTutor(@RequestParam int id,AgendamientoTutoria agentuto){
        agentuto.setIdAgendamiento(id);
        agentutoser.insertarDatosReunion(agentuto);
        
        return "redirect:/tutorias_asignadas";
    }
    
    
}



