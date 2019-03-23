package com.udec.ejercicioaviones;

/**
 *
 * @author David
 */
public class AvionC extends ClaseAvionPadre{
    
    /**
     * varible que contiene la matriz 
     */
    private String listaAvionC[][];

    /**
     * variable contador que guardara el total de las sillas vendidas del avion 
     */
    private int totalpasajes=0;
    
    /**
     * constructor donde se inicializa la matriz
     */
    public AvionC() {
        this.listaAvionC=new String[3][2];
    }

    /**
     * Retorna los datos de la matriz 
     * @return 
     */
    public String[][] getListaAcionC() {
        return listaAvionC;
    }

    /**
     * permite asignar valores a la matriz
     * @param listaAcionC 
     */
    public void setListaAcionC(String[][] listaAcionC) {
        this.listaAvionC = listaAcionC;
    }
    
    /**
     * metodo que genera la lista del avion y llena la matriz con datos 
     */
    public void generarListaAvion(){
        int cont=0;
         for (int x=0; x < listaAvionC.length; x++) {
            for (int y=0; y < listaAvionC[x].length; y++) {
                    listaAvionC[x][y] = "Ex"+cont;
                    cont++;
            }
        }
        
        
    
    }
    
    /**
     * metodo que imprime la lista una vez ya este llena 
     */
    public void imprimirListaAvion(){
        for (int x=0; x < listaAvionC.length; x++) {
            System.out.print("|");
            for (int y=0; y < listaAvionC[x].length; y++) {
                System.out.print (listaAvionC[x][y]);
                if (y!=listaAvionC[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }
    
    /**
     * metodo que se encarga de buscar las sillas del avion, si el valor s eencuentra cambia el valor por una x
     * @param valor 
     */
    public void buscarSillasExclusivas(String valor){
        
            for (int x=0; x < listaAvionC.length; x++) {
                for (int y=0; y < listaAvionC[x].length; y++) {
                        if(listaAvionC[x][y].equals(valor)){
                            listaAvionC[x][y] = "x"; 
                        }
                }
            }
      
    }
    
    /**
     * metodo que se encarga de buscar en la matriz el valo de la silla que se quiere reservar 
     * si lo encuentra retorna un mensaje 
     * @param valor = el dato de la silla que se quiere reservar 
     * @return los valor a retornar pueden ser:
     *                          -2. cuando el valor que se quiere buscar ya fue cmabiado por una x
     *                          -1. cuando el valor que se quiere buscar no se encuentra en la matriz
     *                           1. cuando el valor que se quiere retornar esta en la matriz y esta disponible para su reserva
     */
    public int buscarSillasExclusivasSinCambio(String valor){
        int mensaje=0;
       if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < listaAvionC.length; x++) {
                for (int y=0; y < listaAvionC[x].length; y++) {
                        if(listaAvionC[x][y].equals(valor)){
                            mensaje=1;
                            return mensaje;
                        }else{
                            mensaje=-1;
                        }
                }
            }
       }
       return mensaje;
    }
    
    
    /**
     * metodo que se encarga de cambiar el estado de despegue del un avion, este metodo recibe un estado int 
     * segudo utiliza la variable contador encargada de almacenar el precio de las sillas vendidas, los campos dentro de
     * la matriz los vuelve null y seguido retorna un estado de -1 
     * @param estado un valor entero que recibe siempre sera 1 
     * @return retorna siempre un -1 y estado
     */
    public int despergarAvionC(int estado){
        
        if(estado==1){
            for(Silla s : sillaAvion){
                totalpasajes+=s.getPrecio();
            }
            for (int x=0; x < listaAvionC.length; x++) {
                for (int y=0; y < listaAvionC[x].length; y++) {
                    listaAvionC[x][y] = null;
                }
            }
            System.out.println("El total de los pasajes es: "+totalpasajes);
            System.out.println("El avion ya despego");
            estado=-1;
            return estado;
        }
        
        return estado;
    }
    
    /**
     * metodo que recibe 2 parametros 
     * @param estado = siempre sera por defecto 1
     * @param mat = una matriz previamente creeada en las pruebas unitarias
     * @return retornara el valor del -1 indicando que el avion ya despego
     */
    public int despergarAvionCUnitTest(int estado,String[][] mat){
        
        if(estado==1){
            
            for (int x=0; x < mat.length; x++) {
                for (int y=0; y < mat[x].length; y++) {
                    mat[x][y] = null;
                }
            }
            System.out.println("El avion ya despego");
            estado=-1;
            return estado;
        }
        
        return estado;
    }
    
}
