/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;


public class Rango {

    private int idRango;
    private String descripcion;
    


    public Rango() {
    }

    public Rango(int idRango, String descripcion) {
        this.idRango = idRango;
        this.descripcion = descripcion;
    }


    /**
     * @return the idRango
     */
    public int getIdRango() {
        return idRango;
    }

    /**
     * @param idRango the idRango to set
     */
    public void setIdRango(int idRango) {
        this.idRango = idRango;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
