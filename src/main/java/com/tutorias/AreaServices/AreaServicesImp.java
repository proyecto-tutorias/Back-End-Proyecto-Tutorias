/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.AreaServices;


import com.tutorias.AreaDao.AreaDao;
import com.tutorias.domain.Area;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AreaServicesImp implements AreaServices{

    @Autowired
    private AreaDao areaDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Area> listaAreas() {
        return (List<Area>)areaDao;
    }

    @Override
    public void borrar(Area area) {
        areaDao.delete(area);
    }

    @Override
    public void insertar(Area area) {
        areaDao.save(area);
    }

    @Override
    @Transactional(readOnly = true)
    public Area encontrarArea(Area area) {
       return areaDao.findById(area.getIdArea()).orElse(null);
    }
    
}
