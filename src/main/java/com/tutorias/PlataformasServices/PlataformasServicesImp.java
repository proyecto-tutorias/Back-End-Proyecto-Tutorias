/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.PlataformasServices;

import com.tutorias.PlataformasDao.PlataformasDao;
import com.tutorias.domain.PlataformaReunion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlataformasServicesImp implements PlataformasServices{

    @Autowired
    private PlataformasDao plataformasDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<PlataformaReunion> listaPlataformas() {
        return (List<PlataformaReunion>)plataformasDao.findAll();
    }

    @Override
    public void borrar(PlataformaReunion plataforma) {
        plataformasDao.delete(plataforma);
    }

    @Override
    public void insertar(PlataformaReunion plataforma) {
        plataformasDao.save(plataforma);
    }

    @Override
    @Transactional(readOnly = true)
    public PlataformaReunion encontrarPlataforma(PlataformaReunion plataforma) {
       return plataformasDao.findById(plataforma.IdPlataformaReunion()).orElse(null);
    }
    
}
