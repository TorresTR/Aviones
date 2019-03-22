package com.udec.ejercicioaviones;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public abstract class ClaseAvionPadre {
    
    /**
     * lista de las sillas del avion
     */
    protected List<Silla> sillaAvion;

    /**
     * constructor que inicaliza las sillas del avion
     */
    public ClaseAvionPadre() {
        this.sillaAvion = new ArrayList<Silla>();
    }

   

    /**
     * Retorna la lista con  las sillas del avion
     * @return 
     */
    public List<Silla> getSillaAvion() {
        return sillaAvion;
    }

    /**
     * permite asignar valores a la lista de las sillas del avion
     * @param sillaAvion 
     */
    public void setSillaAvion(List<Silla> sillaAvion) {
        this.sillaAvion = sillaAvion;
    }
    
    
    
}
