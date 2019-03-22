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
    
    public int buscarSillasNomales(String valor){
        int mensaje=0;
       if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < sillasNormales.length; x++) {
                for (int y=0; y < sillasNormales[x].length; y++) {
                        if(sillasNormales[x][y].equals(valor)){
                            sillasNormales[x][y] = "x"; 
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
    
    
    public int buscarSillasVip(String valor){
        int mensaje=0;
      if(valor.equals("x")){
           mensaje=-2;
       }else{
            for (int x=0; x < sillasVip.length; x++) {
                for (int y=0; y < sillasVip[x].length; y++) {
                        if(sillasVip[x][y].equals(valor)){
                            sillasVip[x][y] = "x"; 
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
