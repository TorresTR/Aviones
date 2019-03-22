package com.udec.ejercicioaviones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que contiene toda la logica del proyecto
 * @author David
 */
public class Logica {
    
    AvionA avionA = new AvionA();
    AvionB avionB = new AvionB();
    AvionC avionC = new AvionC();
    Scanner scanner = new Scanner(System.in);
    public Logica() {
        
        avionA.generarSillasVip();
        avionA.generarSillasNormales();
        avionB.generarListaAvion();
        avionC.generarListaAvion();
        menu();
    }
    
    public void menu(){
            int variableSeleccion=0;
            System.out.println("\n----------------------------------------");
            System.out.println("Bienvenido al menu de aviones");
            System.out.println("Selecciones una opcion: ");
            System.out.println("1.Ver Avion Mixto");
            System.out.println("2.Ver Avion Normal");
            System.out.println("3.Ver Avion Expclusivo");
            System.out.println("4.Salir");
            try {
                variableSeleccion= scanner.nextInt();

                if(variableSeleccion == 1){
                    menuAvionMixto();
                }else if(variableSeleccion == 2){
                    menuAvionNormal();
                }else if(variableSeleccion == 3){
                    menuAvionExclusivo();
                }else if(variableSeleccion == 4){
                    System.exit(0);
                }else{
                    System.out.println("-------------------------------");
                    System.out.println("\n Seleccione una opcion valida");
                    menu();
                }
            } catch (InputMismatchException e) {
                System.out.println("\n <<<-----No seleccionaste un Numero ingreaste un caracter no valido----->>>");
                variableSeleccion=0;
                scanner = new Scanner(System.in);
                menu();
            }
    }
    
    public void menuAvionMixto(){
        int variableSeleccion=0;
        System.out.println("\n---------------------------");
        System.out.println("Avion Mixto: ");
        System.out.println("1.Reservar un Asiento");
        System.out.println("2.Despegar avion");
        System.out.println("3.Volver");
        try{
            variableSeleccion = scanner.nextInt();
            if(variableSeleccion == 1){
                menuReservarAvionMixto();
            }else if(variableSeleccion == 2){
            }else if(variableSeleccion == 3){
                menu();
            }else{
                System.out.println("-------------------------------");
                System.out.println("\n Seleccione una opcion valida");
                menuAvionMixto();
            }
        }catch(InputMismatchException e){
             System.out.println("\n <<<-----No seleccionaste un Numero ingreaste un caracter no valido----->>>");
             variableSeleccion=0;
             scanner = new Scanner(System.in);
             menuAvionMixto();
        }
        
    }
    
    public void menuReservarAvionMixto(){
        int variableSeleccion=0;
        System.out.println("\n---------------------------");
        System.out.println("Reservar silla: ");
        avionA.imprimirVip();
        avionA.imprimirNormales();
        System.out.println("\n---------------------------");
        System.out.println("1.Reserva vip");
        System.out.println("2.Reserva normal");
        System.out.println("3.Volver");
        try {
            variableSeleccion= scanner.nextInt();
            if(variableSeleccion == 1){
                reservaVipMixto();
            }else if(variableSeleccion == 2){
                reservaNormalMixto();
            }else if(variableSeleccion == 3){
                menuAvionMixto();
            }else{
                System.out.println("\n---------------------------");
                System.out.println("Ingrese un valor valido");
                menuReservarAvionMixto();
            }
            
        } catch (InputMismatchException e) {
            System.out.println("\n <<<-----No seleccionaste un Numero ingreaste un caracter no valido----->>>");
             variableSeleccion=0;
             scanner = new Scanner(System.in);
             menuReservarAvionMixto();
        }
    }
    
    public void reservaVipMixto(){
            try{
                String idComparar="mxVip";
                System.out.println("-----Reserva vip----- ");
                System.out.println("\nDigite El id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionA.buscarSillasVip(numeroSilla);
                validacionReservaMixtoVip(valor);
                System.out.println("Digite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Digite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Digite su Fecha de nacimiento: ");
                String fech = scanner.next();
                Date fecha = validacionFechaMixtoVip(fech);
                Silla asiento = new Silla(5000,numeroSilla);
                Cliente cl = new Cliente(id, nomb, fecha);
                asiento.getListaCliente().add(cl);
                avionA.sillaAvion.add(asiento);
                continuarMixto();
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaVipMixto();
            }
    }
    
    public void validacionReservaMixtoVip(int valor){
           if(valor == 1){
                System.out.println("------Reserva exitosa--------");
            }else if(valor == -1){
                System.out.println("----------El valor a reserva no se encuentra, Reserva cancelada---------");
                reservaVipMixto();
            }else if(valor == -2){
                System.out.println("----------Lo sentimos la reserva ya existe no se puede reservar la silla---------");
                reservaVipMixto();
            }
           
    }
    
    public Date validacionFechaMixtoVip(String fec){
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha= null;
            try {
                fecha = formatoDelTexto.parse(fec);
            } catch (ParseException ex) {
                System.out.print("\nFecha incorrecta no lleva el formato valido venta cancelada");   
                reservaVipMixto();
            }
        return fecha;
    }
    
    public void reservaNormalMixto(){
         try{
                String idComparar="mxNorm";
                System.out.println("-----Reserva Normal----- ");
                System.out.println("\nDigite el id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionA.buscarSillasNomales(numeroSilla);
                validacionReservaMixtoNormal(valor);
                System.out.println("Dijite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Dijite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Dijite su Fecha de nacimiento: ");
                String fech = scanner.next();
                Date fecha = validacionFechaMixtoNomal(fech);
                Silla asiento = new Silla(1000,numeroSilla);
                Cliente cl = new Cliente(id, nomb, fecha);
                asiento.getListaCliente().add(cl);
                avionA.sillaAvion.add(asiento);
                continuarMixto();
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaNormalMixto();
            }
    }
    
    public  void excepcionSolocadena(String cadena, String id){
        char letra='0';
        for(int i=0; i<cadena.length();i++){
            letra = cadena.charAt(i);
            if(Character.isDigit(letra)){ 
                if(id.equals("mxVip")){
                    System.out.println("<<---ingrese solo letras, reserva cancelada--->>");
                    reservaVipMixto();
                }else if (id.equals("mxNorm")){
                    System.out.println("<<---ingrese solo letras, reserva cancelada--->>");
                    reservaNormalMixto();
                }else if(id.equals("avionNormal")){
                    System.out.println("<<---ingrese solo letras, reserva cancelada--->>");
                    reservaNormal();
                }else if(id.equals("avionExclusivo")){
                    System.out.println("<<---ingrese solo letras, reserva cancelada--->>");
                    reservaExclusivo();
                }
                
            }
        }
}
    
    public void validacionReservaMixtoNormal(int valor){
            if(valor == 1){
                System.out.println("------Reserva exitosa--------");
            }else if(valor == -1){
                System.out.println("----------El valor a reserva no se encuentra, Reserva cancelada---------");
                reservaVipMixto();
            }else if(valor == -2){
                System.out.println("----------Lo sentimos la reserva ya existe no se puede reservar la silla---------");
                reservaVipMixto();
            }
    }
    
    public Date validacionFechaMixtoNomal(String fec){
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha= null;
            try {
                fecha = formatoDelTexto.parse(fec);
            } catch (ParseException ex) {
                System.out.print("\nFecha incorrecta no lleva el formato valido venta cancelada");   
                reservaVipMixto();
            }
        return fecha;
    }
    
    public void continuarMixto(){
        System.out.println("\n----------------");
        System.out.println("Desea Continuar Reservando?(s/n): ");
        String conti = scanner.next();
        if(conti.charAt(0) == 's'){
            menuReservarAvionMixto();
        }else if(conti.charAt(0) == 'n'){
            menuAvionMixto();
        }else if(conti.charAt(0) != 's' || conti.charAt(0) != 'n' ){
             System.out.println("ingrese un caracter valido");
             continuarMixto();
        }
    }
    
    public void menuAvionNormal(){
        int variableSeleccion=0;
        System.out.println("\n------Avion Normal------");
        System.out.println("Avion Normal: ");
        System.out.println("1.Reservar un Asiento");
        System.out.println("2.Despegar avion");
        System.out.println("3.volver");
        try{
                variableSeleccion = scanner.nextInt();
                if(variableSeleccion == 1){
                    menuReservarAvionNormal();
                }else if(variableSeleccion == 2){
                }else if(variableSeleccion == 3){
                    menu();
                }else{
                    System.out.println("-------------------------------");
                    System.out.println("\n Seleccione una opcion valida");
                    menuAvionNormal();
                }
        }catch(InputMismatchException e){
             System.out.println("\n <<<-----No seleccionaste un Numero ingreaste un caracter no valido----->>>");
             variableSeleccion=0;
             scanner = new Scanner(System.in);
             menuAvionNormal();
        }
    }
    
    public void menuReservarAvionNormal(){
        int variableSeleccion=0;
        System.out.println("\n---------------------------");
        System.out.println("Reservar silla Avion Normal: ");
        avionB.imprimirListaAvion();
        System.out.println("\n---------------------------");
        System.out.println("1.Reservar Asiento");
        System.out.println("2.Volver");
        try {
            variableSeleccion= scanner.nextInt();
            if(variableSeleccion == 1){
                reservaNormal();
            }else if(variableSeleccion == 2){
                menuAvionNormal();
            }else{
                System.out.println("\n---------------------------");
                System.out.println("Ingrese un valor valido");
                menuReservarAvionNormal();
            }
            
        } catch (InputMismatchException e) {
            System.out.println("\n <<<-----No seleccionaste un Numero ingreaste un caracter no valido----->>>");
             variableSeleccion=0;
             scanner = new Scanner(System.in);
             menuReservarAvionMixto();
        }
    }
    
    public void reservaNormal(){
            try{
                String idComparar="avionNormal";
                System.out.println("-----Reserva Avion Normal----- ");
                System.out.println("\nDigite El id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionB.buscarSillasNormales(numeroSilla);
                validacionReservaAvionB(valor);
                System.out.println("Digite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Digite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Digite su Fecha de nacimiento: ");
                String fech = scanner.next();
                Date fecha = validacionFechaNormal(fech);
                Silla asiento = new Silla(3000,numeroSilla);
                Cliente cl = new Cliente(id, nomb, fecha);
                asiento.getListaCliente().add(cl);
                avionB.sillaAvion.add(asiento);
                continuarNormal();
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaNormal();
            }
    }
    
    public void validacionReservaAvionB(int valor){
           if(valor == 1){
                System.out.println("------Reserva exitosa--------");
            }else if(valor == -1){
                System.out.println("----------El valor a reserva no se encuentra, Reserva cancelada---------");
                reservaNormal();
            }else if(valor == -2){
                System.out.println("----------Lo sentimos la reserva ya existe no se puede reservar la silla---------");
                reservaNormal();
            }
           
    }
    
    public void continuarNormal(){
        System.out.println("\n----------------");
        System.out.println("Desea Continuar Reservando?(s/n): ");
        String conti = scanner.next();
        if(conti.charAt(0) == 's'){
            menuReservarAvionNormal();
        }else if(conti.charAt(0) == 'n'){
            menuAvionNormal();
        }else if(conti.charAt(0) != 's' || conti.charAt(0) != 'n' ){
             System.out.println("ingrese un caracter valido");
             continuarNormal();
        }
    }
    
    public Date validacionFechaNormal(String fec){
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha= null;
            try {
                fecha = formatoDelTexto.parse(fec);
            } catch (ParseException ex) {
                System.out.print("\nFecha incorrecta no lleva el formato valido venta cancelada");   
                reservaNormal();
            }
        return fecha;
    }
   
    public void menuAvionExclusivo(){
        System.out.println("\n------------Avion exclusivo---------------");
        System.out.println("Avion Exclusivo: ");
        System.out.println("1.Reservar un Asiento");
        System.out.println("2.Despegar avion");
        System.out.println("3.Volver");
        try {
            int variableSeleccion = scanner.nextInt();
            if(variableSeleccion == 1){
                menuReservarAvionExclusivo();
            }else if(variableSeleccion == 2){
            }else if(variableSeleccion == 3){
                menu();
            }else{
                System.out.println("-------------------------------");
                System.out.println("\n Seleccione una opcion valida");
                menuAvionExclusivo();
            }
        }catch (InputMismatchException e) {
            System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
            scanner = new Scanner(System.in);
            menuAvionExclusivo();
        }
        
    }
    
    public void menuReservarAvionExclusivo(){
        int variableSeleccion=0;
        System.out.println("\n---------------------------");
        System.out.println("Reservar silla Avion Exclusivo: ");
        avionC.imprimirListaAvion();
        System.out.println("\n---------------------------");
        System.out.println("1.Reservar Asiento");
        System.out.println("2.Volver");
        try {
            variableSeleccion= scanner.nextInt();
            if(variableSeleccion == 1){
                reservaExclusivo();
            }else if(variableSeleccion == 2){
                menuAvionExclusivo();
            }else{
                System.out.println("\n---------------------------");
                System.out.println("Ingrese un valor valido");
                menuReservarAvionNormal();
            }
            
        } catch (InputMismatchException e) {
            System.out.println("\n <<<-----No seleccionaste un Numero ingreaste un caracter no valido----->>>");
             variableSeleccion=0;
             scanner = new Scanner(System.in);
             menuReservarAvionExclusivo();
        }
    }
    
    public void reservaExclusivo(){
            try{
                String idComparar="avionExclusivo";
                System.out.println("-----Reserva Avion Exclusivo----- ");
                System.out.println("\nDigite El id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionC.buscarSillasExclusivas(numeroSilla);
                validacionReservaAvionExclusivo(valor);
                System.out.println("Digite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Digite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Digite su Fecha de nacimiento: ");
                String fech = scanner.next();
                Date fecha = validacionFechaExclusiva(fech);
                Silla asiento = new Silla(3000,numeroSilla);
                Cliente cl = new Cliente(id, nomb, fecha);
                asiento.getListaCliente().add(cl);
                avionC.sillaAvion.add(asiento);
                continuarNormal();
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaNormal();
            }
    }
    
    public void validacionReservaAvionExclusivo(int valor){
           if(valor == 1){
                System.out.println("------Reserva exitosa--------");
            }else if(valor == -1){
                System.out.println("----------El valor a reserva no se encuentra, Reserva cancelada---------");
                reservaExclusivo();
            }else if(valor == -2){
                System.out.println("----------Lo sentimos la reserva ya existe no se puede reservar la silla---------");
                reservaExclusivo();
            }
           
    }
    
    public Date validacionFechaExclusiva(String fec){
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha= null;
            try {
                fecha = formatoDelTexto.parse(fec);
            } catch (ParseException ex) {
                System.out.print("\nFecha incorrecta no lleva el formato valido venta cancelada");   
                reservaExclusivo();
            }
        return fecha;
    }
    
     public void continuarExclusivo(){
        System.out.println("\n----------------");
        System.out.println("Desea Continuar Reservando?(s/n): ");
        String conti = scanner.next();
        if(conti.charAt(0) == 's'){
            menuReservarAvionExclusivo();
        }else if(conti.charAt(0) == 'n'){
            menuAvionExclusivo();
        }else if(conti.charAt(0) != 's' || conti.charAt(0) != 'n' ){
             System.out.println("ingrese un caracter valido");
             continuarExclusivo();
        }
    }
    
    
}
