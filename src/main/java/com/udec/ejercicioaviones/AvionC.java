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
    
    public int buscarSillasExclusivas(String valor){
        int mensaje=0;
       if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < listaAvionC.length; x++) {
                for (int y=0; y < listaAvionC[x].length; y++) {
                        if(listaAvionC[x][y].equals(valor)){
                            listaAvionC[x][y] = "x"; 
                            mensaje=1;
                            break;
                        }else{
                            mensaje=-1;
                        }
                }
            }
       }
       return mensaje;
    }
    
}
