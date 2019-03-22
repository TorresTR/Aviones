package com.udec.ejercicioaviones;

/**
 *
 * @author David
 */
public class AvionC extends ClaseAvionPadre{
    
    /**
     * varible que contiene la matriz 
     */
    private int listaAvionC[][];

    private  int cont=0,cont2=0;
    /**
     * constructor donde se inicializa la matriz
     */
    public AvionC() {
        this.listaAvionC=new int[3][2];
    }

    /**
     * Retorna los datos de la matriz 
     * @return 
     */
    public int[][] getListaAcionC() {
        return listaAvionC;
    }

    /**
     * permite asignar valores a la matriz
     * @param listaAcionC 
     */
    public void setListaAcionC(int[][] listaAcionC) {
        this.listaAvionC = listaAcionC;
    }
    
    /**
     * metodo que genera la lista del avion y llena la matriz con datos 
     */
    public void generarListaAvion(){
         for (int x=0; x < listaAvionC.length; x++) {
            for (int y=0; y < listaAvionC[x].length; y++) {
                    listaAvionC[x][y] = 0;
                    cont2=listaAvionC[x].length;
            }
        }
        
        
    
    }
    
    public void imprimirListaAvion(){
        for (int x=0; x < listaAvionC.length; x++) {
            cont+=1;
            System.out.print(cont);
            System.out.print("|");
            for (int y=0; y < listaAvionC[x].length; y++) {
                cont2+=1;
                System.out.print (listaAvionC[x][y]);
                if (y!=listaAvionC[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }
}
