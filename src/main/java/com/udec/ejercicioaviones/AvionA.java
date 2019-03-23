package com.udec.ejercicioaviones;


/**
 *
 * @author David
 */
public class AvionA extends ClaseAvionPadre{
    /**
     * se crea la matriz de sillas vip
     */
    private String sillasVip[][] ;
    
    /**
     * se crea la matris de sillas normales
     */
    private String sillasNormales[][];

    /**
     * variable que se usara para almacenar el valor del total de sillas vendidas
     */
    private int totalpasajes=0;
    
    /**
     * se inicializan las varibles en este caso, para sillas normales una matriz de [6]*[6] y para las sillas vip
     * una matriz de [2]*[3]
     */
    public AvionA() {
        this.sillasNormales = new String[6][6];
        this.sillasVip= new String[2][3];
    }

    /**
     * Retorna la matriz de las sillas vip
     * @return 
     */
    public String[][] getSillasVip() {
        return sillasVip;
    }
    
    /**
     * Asigna un valor a las sillas vip
     * @param sillasVip 
     */
    public void setSillasVip(String[][] sillasVip) {
        this.sillasVip = sillasVip;
    }

    /**
     * Retorna el valor de las sillas normales
     * @return 
     */
    public String[][] getSillasNormales() {
        return sillasNormales;
    }

    /**
     * permite asignar a la matriz de sillas normales
     * @param sillasNormales 
     */
    public void setSillasNormales(String[][] sillasNormales) {
        this.sillasNormales = sillasNormales;
    }
    
    /**
     * funcion que genera el arreglo de las sillas por defecto
     */
    public void generarSillasVip(){
        int cont=0;
        for (int x=0; x < sillasVip.length; x++) {
            for (int y=0; y < sillasVip[x].length; y++) {
                    sillasVip[x][y] = "A"+cont;
                    cont+=1;
            }
        }
    }
    
    /**
     * metodo que se encarga de imprimir la matriz ya una vez esta llena 
     */
    public void imprimirVip(){
        System.out.println("-----Sillas Vip-------");
        for (int x=0; x < sillasVip.length; x++) {
            System.out.print("|");
            for (int y=0; y < sillasVip[x].length; y++) {
                System.out.print (sillasVip[x][y]);
                if (y!=sillasVip[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
        System.out.println("------------------");
    }
    
    /**
     * funcion que genera los datos para la matriz de sillas normales
     */
    public void generarSillasNormales(){
        int cont=6;
        for (int x=0; x < sillasNormales.length; x++) {
            for (int y=0; y < sillasNormales[x].length; y++) {
                    sillasNormales[x][y] = "A"+cont;
                    cont+=1;
                    
            }
        }
    }
    
    /**
     * metodo que se encarga de imprimir la matriz de sillas normales una vez ya este llena
     */
    public void imprimirNormales(){
        System.out.println("--------Sillas Normales------------");
        for (int x=0; x < sillasNormales.length; x++) {
            System.out.print("|");
            for (int y=0; y < sillasNormales[x].length; y++) {
                
                System.out.print (sillasNormales[x][y]);
                if (y!=sillasNormales[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
        System.out.println("--------------------------------");
    }
    
    /**
     * metodo que se encarga de buscar la silla que se quiere reservar y pasa su valor dentro de la matriz
     * por una x
     * @param valor 
     */
    public void buscarSillasNomales(String valor){
       for (int x=0; x < sillasNormales.length; x++) {
                for (int y=0; y < sillasNormales[x].length; y++) {
                        if(sillasNormales[x][y].equals(valor)){
                            sillasNormales[x][y] = "x"; 
                           
                        }
                }
            }
    }
    
    /**
     *metodo que se encarga de buscar en la matriz el valo de la silla que se quiere reservar 
     * si lo encuentra retorna un mensaje 
     * @param valor = el dato de la silla que se quiere reservar 
     * @return los valor a retornar pueden ser:
     *                          -2. cuando el valor que se quiere buscar ya fue cmabiado por una x
     *                          -1. cuando el valor que se quiere buscar no se encuentra en la matriz
     *                           1. cuando el valor que se quiere retornar esta en la matriz y esta disponible para su reserva
     */
    public int buscarSillasNomalesSinCambio(String valor){
        int mensaje=0;
       if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < sillasNormales.length; x++) {
                for (int y=0; y < sillasNormales[x].length; y++) {
                        if(sillasNormales[x][y].equals(valor)){
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
     * metodo que se una para las pruebas unitarias 
     * @param valor = recibe el valor que s equiere buscar 
     * @param sillas = matriz previamente creada en la clase de pruebas unitarias 
     * @return 
     */
     public int buscarSillasNomalesSinCambio(String valor, String[][] sillas){
        int mensaje=0;
       if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < sillas.length; x++) {
                for (int y=0; y < sillas[x].length; y++) {
                        if(sillas[x][y].equals(valor)){
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
     * metodo que se encarga de buscar la silla que se quiere reservar y pasa su valor dentro de la matriz
     * por una x
     * @param valor 
     */
    public void buscarSillasVip(String valor){
        for (int x=0; x < sillasVip.length; x++) {
                for (int y=0; y < sillasVip[x].length; y++) {
                        if(sillasVip[x][y].equals(valor)){
                            sillasVip[x][y] = "x"; 
                            
                        }
                    
                }
            }
    }
    
    /**
     *metodo que se encarga de buscar en la matriz el valo de la silla que se quiere reservar 
     * si lo encuentra retorna un mensaje 
     * @param valor = el dato de la silla que se quiere reservar 
     * @return los valor a retornar pueden ser:
     *                          -2. cuando el valor que se quiere buscar ya fue cmabiado por una x
     *                          -1. cuando el valor que se quiere buscar no se encuentra en la matriz
     *                           1. cuando el valor que se quiere retornar esta en la matriz y esta disponible para su reserva
     */
    public int buscarSillasVipSinCambio(String valor){
        int mensaje=0;
      if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < sillasVip.length; x++) {
                for (int y=0; y < sillasVip[x].length; y++) {
                        if(sillasVip[x][y].equals(valor)){
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
     * metodo que se una para las pruebas unitarias 
     * @param valor = recibe el valor que s equiere buscar 
     * @param sillas = matriz previamente creada en la clase de pruebas unitarias 
     * @return 
     */
    public int buscarSillasVipSinCambioPruebaUnitaria(String valor, String[][] mat){
        int mensaje=0;
      if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < mat.length; x++) {
                for (int y=0; y < mat[x].length; y++) {
                        if(mat[x][y].equals(valor)){
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
    public int despergarAvionA(int estado){
        
        if(estado==1){
            for(Silla s : sillaAvion){
                totalpasajes+=s.getPrecio();
            }
            for (int x=0; x < sillasVip.length; x++) {
                for (int y=0; y < sillasVip[x].length; y++) {
                    sillasVip[x][y] = null;
                }
            }
            for (int x=0; x < sillasNormales.length; x++) {
                for (int y=0; y < sillasNormales[x].length; y++) {
                    sillasNormales[x][y] = null;
                }
            }
            System.out.println("El total de los pasajes es: "+totalpasajes);
            System.out.println("El avion ya despego");
            estado=-1;
            return estado;
        }
        
        return estado;
    }
    
    
}
