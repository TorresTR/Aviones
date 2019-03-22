package com.udec.ejercicioaviones;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Silla {
    
    /**
     * variable que contiene el precio de la silla del avion
     */
     private float precio;
    
     private String numeroSilla;
     
     /**
      * lista de cliente que se asignan a la silla del avion
      */
     private List<Cliente> listaCliente ;

    public Silla(float precio,String numeroSilla) {
        this.precio = precio;
        this.numeroSilla = numeroSilla;
        this.listaCliente =  new ArrayList<Cliente>();
    }

    /**
     * Retorna el valor de la silla
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * permite asignar un valor a la silla
     * @param precio 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    

    /**
     * Retorna la lista de cliente 
     * @return listaCliente
     */
    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    /**
     * permite asginar datos a la lista de cliente
     * @param listaCliente 
     */
    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
     
     
    
}
