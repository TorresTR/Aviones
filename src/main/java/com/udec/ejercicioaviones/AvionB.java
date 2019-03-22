
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
            }
        }
    }
    
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
    
    
    public int buscarSillasNormales(String valor){
       int mensaje=0;
       if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < listaAvion.length; x++) {
                for (int y=0; y < listaAvion[x].length; y++) {
                        if(listaAvion[x][y].equals(valor)){
                            listaAvion[x][y] = "x"; 
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
    
}
