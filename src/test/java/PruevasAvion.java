/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.udec.ejercicioaviones.AvionA;
import com.udec.ejercicioaviones.AvionB;
import com.udec.ejercicioaviones.AvionC;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class PruevasAvion {
    
    /**
     * se declaran e inicializan las matrices para poder realizar las pruebas unitarias
     */
    private static String[][] sillasNormales= new String[6][6];
    private static String[][] sillasVip= new String[2][3];
    private static String[][] sillasAvionB= new String[5][3];
    private static String[][] sillasAvionC= new String[3][2];
    
    public PruevasAvion() {
   }
    
    /**
     * se llaman a los metodo que llenan las matrices con los datos para las pruebas 
     */
    @BeforeClass
    public static void setUpClass() {
        generarSillasNormales();
        generarSillasVip();
        generarSillasAvionB();
        generarSillasAvionC();
    }
    
    /**
     * Metodo que se encarga del llenado de la matriz de las sillas normales 
     */
    public static void generarSillasNormales(){
        int cont=6;
        for (int x=0; x < sillasNormales.length; x++) {
            for (int y=0; y < sillasNormales[x].length; y++) {
                    sillasNormales[x][y] = "A"+cont;
                    cont+=1;
                    
            }
        }
    }
    
    /**
     * metodo que sen encarga del llenado de la matriz de las sillas vip
     */
    public static void generarSillasVip(){
        int cont=0;
        for (int x=0; x < sillasVip.length; x++) {
            for (int y=0; y < sillasVip[x].length; y++) {
                    sillasVip[x][y] = "A"+cont;
                    cont+=1;
                    
            }
        }
    }
    
    /**
     * metodo que se encarga del llenado de la matriz del avionB
     */
    public static void generarSillasAvionB(){
        int cont=0;
        for (int x=0; x < sillasAvionB.length; x++) {
            for (int y=0; y < sillasAvionB[x].length; y++) {
                    sillasAvionB[x][y] = "B"+cont;
                    cont+=1;
                    
            }
        }
    }
    
    /**
     * metodo que se encarga del llenado de la matriz del avionC
     */
    public static void generarSillasAvionC(){
        int cont=0;
        for (int x=0; x < sillasAvionC.length; x++) {
            for (int y=0; y < sillasAvionC[x].length; y++) {
                    sillasAvionC[x][y] = "C"+cont;
                    cont+=1;
                    
            }
        }
    }
    @AfterClass
    public static void tearDownClass() {
    }
    
    /*@Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/
    
    /**
     * metodoq se encarga del probar las sillas normales, donde se le envia el dato que se quiere buscar una matriz 
     * previamente llenada, se espera que el valor retornado sea 1 lo que quiere decir que el valor si esta en la matriz 
     */
    @Test
    public void pruebaSillasNormales(){
        AvionA log = new AvionA();
        int esperado = log.buscarSillasNomalesSinCambio("A6",sillasNormales);
        assertEquals(1, esperado);
    }
    
    
    /**
     *metodoq se encarga del probar las sillas vip, donde se le envia el dato que se quiere buscar una matriz 
     * previamente llenada, donde se le envia un dato que no pertenece a la matriz se espera que retorne un valor de 
     * -1
     */
    @Test
    public void PruevaSillasVip(){
        AvionA log = new AvionA();
        int esperado = log.buscarSillasVipSinCambioPruebaUnitaria("A78",sillasVip);
        assertEquals(-1, esperado);
    }
    
    /**
     * metodoq se encarga del probar las sillas del avionB, donde se le envia el dato que se quiere buscar una matriz 
     * previamente llenada, se le envia una "x" lo cual quiere decir que la silla ya fue reservada, en este caso se espera 
     * que retorne un -2
     */
     @Test
    public void PruevaSillasAvionB(){
        AvionB log = new AvionB();
        int esperado = log.buscarSillasNormalesUnitTest("x",sillasAvionB);
        assertEquals(-2, esperado);
    }
    
    /**
     * metodoq se encarga del probar las sillas del avionC, donde se le envia el dato (1) el cual se encarga de verificar 
     * que si entre dentro del if de la funcion, dentro retornara un -1 el cual indicara que el avion ya despego 
     */
    @Test
    public void PruevaSillasAvionC(){
        AvionC log = new AvionC();
        int esperado = log.despergarAvionCUnitTest(1,sillasAvionC);
        assertEquals(-1, esperado);
    }
}
