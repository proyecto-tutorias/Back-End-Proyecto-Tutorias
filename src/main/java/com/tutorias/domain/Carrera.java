/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorias.domain;





public class Carrera {
    
    private int idCarrera;
    private String descripcion;
    private int minSemestre;
    private int maxSemestre;

    /**
     * @return the idCarrera
     */
    public int getIdCarrera() {
        return idCarrera;
    }

    /**
     * @param idCarrera the idCarrera to set
     */
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
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

    /**
     * @return the minSemestre
     */
    public int getMinSemestre() {
        return minSemestre;
    }

    /**
     * @param minSemestre the minSemestre to set
     */
    public void setMinSemestre(int minSemestre) {
        this.minSemestre = minSemestre;
    }

    /**
     * @return the maxSemestre
     */
    public int getMaxSemestre() {
        return maxSemestre;
    }

    /**
     * @param maxSemestre the maxSemestre to set
     */
    public void setMaxSemestre(int maxSemestre) {
        this.maxSemestre = maxSemestre;
    }

}