package com.udec.ejercicioaviones;

import java.util.Date;

/**
 *
 * @author David
 */
public class Cliente {
    
    private int identifiacion;
    
    private String nombre;
    
    private Date fechaNacimiento;

    public Cliente(int identifiacion, String nombre, Date fechaNacimiento) {
        this.identifiacion = identifiacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(int identifiacion) {
        this.identifiacion = identifiacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
