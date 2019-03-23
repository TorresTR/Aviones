
package com.udec.ejercicioaviones;

/**
 *
 * @author David
 */
public class AvionB extends ClaseAvionPadre{
    /**
     * Se declara una matris donde se guardara el tamaño (sus filas y columnas)
     */
    private String listaAvion[][];
    
    /**
     * varibale contador que se inicializa en 0 para, poder almacenar lo vendido de los pasajes del avion 
     */
    private int totalpasajes=0;
    
    /**
     * se inicializa la matriz, en este caso de [5]*[3]
     */
    public AvionB() {
        this.listaAvion = new String[5][3];
    }

    /**
     * Retorna el valor de la matriz
     * @return 
     */
    public String[][] getListaAvion() {
        return listaAvion;
    }

    /**
     * permite asignar valores a la matriz 
     * @param listaAvion 
     */
    public void setListaAvion(String[][] listaAvion) {
        this.listaAvion = listaAvion;
    }
    
    /**
     * metodo que genera la lista del avion y llena la matriz con datos 
     */
    public void generarListaAvion(){
        int cont=0;
         for (int x=0; x < listaAvion.length; x++) {
            for (int y=0; y < listaAvion[x].length; y++) {
                    listaAvion[x][y] ="B"+cont;
                    cont++;
            }
        }
    }
    
    /**
     * metodo que se encarga de imprimir la matriz del avion 
     */
    public void imprimirListaAvion(){
        System.out.println("-----Sillas Avion Normal-------");
        for (int x=0; x < listaAvion.length; x++) {
            System.out.print("|");
            for (int y=0; y < listaAvion[x].length; y++) {
               System.out.print (listaAvion[x][y]);
                if (y!=listaAvion[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
        System.out.println("------------------");
    }
    
    
    /**
     * metodo que se encarga de buscar la silla que se quiere reservar y pasa su valor dentro de la matriz
     * por una x
     * @param valor 
     */
    public void buscarSillasNormales(String valor){
       for (int x=0; x < listaAvion.length; x++) {
            for (int y=0; y < listaAvion[x].length; y++) {
                    if(listaAvion[x][y].equals(valor)){
                        listaAvion[x][y] = "x"; 
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
    public int buscarSillasNormalesSinCambio(String valor){
       int mensaje=0;
       if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < listaAvion.length; x++) {
                for (int y=0; y < listaAvion[x].length; y++) {
                        if(listaAvion[x][y].equals(valor)){
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
     * metodo que se encarga de hacer las pruebas unitarias, este metodo recibe 2 parametros 
     * @param valor = el valor que se quiere buscar dentro de la matriz 
     * @param mat = una matriz que se envia previamente llena desde la clase de pruebas unitarias 
     * @return los valor a retornar pueden ser:
     *                          -2. cuando el valor que se quiere buscar ya fue cmabiado por una x
     *                          -1. cuando el valor que se quiere buscar no se encuentra en la matriz
     *                           1. cuando el valor que se quiere retornar esta en la matriz y esta disponible para su reserva
     */
    public int buscarSillasNormalesUnitTest(String valor, String[][] mat ){
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
    public int despergarAvionB(int estado){
        
        if(estado==1){
            for(Silla s : sillaAvion){
                totalpasajes+=s.getPrecio();
            }
            for (int x=0; x < listaAvion.length; x++) {
                for (int y=0; y < listaAvion[x].length; y++) {
                    listaAvion[x][y] = null;
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
