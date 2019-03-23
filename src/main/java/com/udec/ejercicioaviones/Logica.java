package com.udec.ejercicioaviones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase que contiene toda la logica del proyecto
 * @author David
 */
public class Logica {
    /**
     * Se llamana a las clases AvionA, AvionB, AvionC para usar los metodos especificos de cada una de las clases
     */
    AvionA avionA = new AvionA();
    AvionB avionB = new AvionB();
    AvionC avionC = new AvionC();
    /**
     * se inicializan variables contador para el menjode del despegue de los aviones
     */
    int estadoA=1,estadoB=1,estadoC=1;
    /**
     * se inicializa el Scanner para caputrar los datos por la consola
     */
    Scanner scanner = new Scanner(System.in);
    
    /**
     * metodo se encarga de inicializar las matricez y luego de unicializadas redirige a el menu donde 
     * se dara inicio al programa
     */
    public Logica() {
        
        avionA.generarSillasVip();
        avionA.generarSillasNormales();
        avionB.generarListaAvion();
        avionC.generarListaAvion();
        menu();
    }
    
    /**
     * metodo que se encarga de mostrar las opciones del menu, y de dar un orden del funcionamiento del menu
     */
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
    
    /**
     * metodo que se encarga del manejo del avion misxto, en el le pregunta si desea reservar o hacer que el avion 
     * despegue
     */
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
                despegarMixto();
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
    
    /**
     * metodo que se encarga de el despuege del avion se guarda en la variable contador el resultado que retorna 
     * que debe ser -1 el cual nos dara la indicacion que el avion, ya despego
     */
    public void despegarMixto(){
        estadoA=avionA.despergarAvionA(estadoA);
        menu();
    }
    
    /**
     * Metodo que se encarga del menu, donde se puede escoger entre reservar sillas vip o reservar sillas normales
     */
    public void menuReservarAvionMixto(){
        if(estadoA == 1){
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
    }else if(estadoA != 1){
            System.out.println("\n<<<<---------El avion ya despego--------->>>>");
            menu();
    }
        
}
    
    /**
     * Metodo que se encarga del manejo de las reservas de las sillas vip del avion mixto
     */
    public void reservaVipMixto(){
                
            try{
                String idComparar="mxVip";
                System.out.println("\n-----Reserva vip----- ");
                System.out.println("\nDigite El id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionA.buscarSillasVipSinCambio(numeroSilla);
                validacionReservaMixtoVip(valor);
                System.out.println("Digite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Digite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Digite su Fecha de nacimiento(YYYY-MM-DD): ");
                String fech = scanner.next();
                Date fecha = validacionFechaMixtoVip(fech);
                if(fecha != null){
                    avionA.buscarSillasVip(numeroSilla);
                    Silla asiento = new Silla(5000,numeroSilla);
                    Cliente cl = new Cliente(id, nomb, fecha);
                    asiento.getListaCliente().add(cl);
                    avionA.sillaAvion.add(asiento);
                    continuarMixto();
                }
                
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un Dato valido, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaVipMixto();
            }
    }
    
    /**
     * Metodo que se encarga de la validacion, de si la silla, que quiere reservar, 
     * esta disponible segun el valor retornado
     *     1. se usa para cuando encuentra el valor y la reserva de la silla se puede hacer 
     *    -1. Se usa para cuando el valor que digito la persona no se encuentra en la matriz 
     *    -2. Se usa para validar que la reserva ya fue hecha
     * @param valor= es un entero que retorna de la busqueda en la matriz su valor puede ser 1, -1, -2 
     */
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
    
    /**
     * metodo que Recibe un string y se encarga de hacer el parseo a fecha
     * @param fec= string que se envia con la fecha
     * @return fecha = valor que retorna el cual puede tener dos opciones null cuando se le envian vacios, o la fecha 
     * parseada el formato especificado
     */
    public Date validacionFechaMixtoVip(String fec){
            Date fecha= null;
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            try {
                fecha = formatoDelTexto.parse(fec);
            } catch (ParseException ex) {
                System.out.print("\nFecha incorrecta no lleva el formato valido venta cancelada");   
                scanner = new Scanner(System.in);
                reservaVipMixto();
            }
            
        return fecha;
    }
    
    /**
     * Metodo que se encarga del manejo de las reservas de las sillas Normales del avion mixto
     */
    public void reservaNormalMixto(){
         try{
                String idComparar="mxNorm";
                System.out.println("-----Reserva Normal----- ");
                System.out.println("\nDigite el id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionA.buscarSillasNomalesSinCambio(numeroSilla);
                validacionReservaMixtoNormal(valor);
                System.out.println("Dijite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Dijite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Dijite su Fecha de nacimiento(YYYY-MM-DD): ");
                String fech = scanner.next();
                Date fecha = validacionFechaMixtoNomal(fech);
                if(fecha != null){
                    avionA.buscarSillasNomales(numeroSilla);
                    Silla asiento = new Silla(1000,numeroSilla);
                    Cliente cl = new Cliente(id, nomb, fecha);
                    asiento.getListaCliente().add(cl);
                    avionA.sillaAvion.add(asiento);
                    continuarMixto();
                }
                
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaNormalMixto();
            }
    }
    
    /**
     * Metodo que se encarga de la validacion del nombre que solo sean letras, no puede contener numeros
     * se encarga de comparar la cadena caracter por caracter
     * @param cadena= la cadena que contiene el nombre 
     * @param id = la identificacion de la clase que hace el llamado de dicho metodo
     */
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
    
    /**
     * Metodo que se encarga de la validacion, de si la silla, que quiere reservar, 
     * esta disponible segun el valor retornado
     *     1. se usa para cuando encuentra el valor y la reserva de la silla se puede hacer 
     *    -1. Se usa para cuando el valor que digito la persona no se encuentra en la matriz 
     *    -2. Se usa para validar que la reserva ya fue hecha
     * @param valor= es un entero que retorna de la busqueda en la matriz su valor puede ser 1, -1, -2 
     */
    public void validacionReservaMixtoNormal(int valor){
            if(valor == 1){
                System.out.println("------Reserva exitosa--------");
            }else if(valor == -1){
                System.out.println("----------El valor a reserva no se encuentra, Reserva cancelada---------");
                reservaNormalMixto();
            }else if(valor == -2){
                System.out.println("----------Lo sentimos la reserva ya existe no se puede reservar la silla---------");
                reservaNormalMixto();
            }
    }
    
    /**
     * metodo que Recibe un string y se encarga de hacer el parseo a fecha
     * @param fec= string que se envia con la fecha
     * @return fecha = valor que retorna el cual puede tener dos opciones null cuando se le envian vacios, o la fecha 
     * parseada el formato especificado
     */
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
    
    /**
     * Metodo que se encarga de preguntar si desea continuar reservando asientos del avion misxto
     * si desea continuar sera retornado al metodo menuReservarAvionMixto() si su respuesta es no 
     * se retornara a el menu menuAvionMixto()
     */
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
    
    /**
     * metodo que se encarga del manejo del avion Normal, en el le pregunta si desea reservar o hacer que el avion 
     * despegue
     */
    public void menuAvionNormal(){
        if(estadoC == 1){
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
                        despegarNormal();
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
        }else if(estadoC != 1){
            System.out.println("\n<<<<---------El avion ya despego--------->>>>");
            menu();
        }
        
    }
    
    /**
     * metodo que se encarga de el despuege del avion se guarda en la variable contador el resultado que retorna 
     * que debe ser -1 el cual nos dara la indicacion que el avion, ya despego
     */
    public void despegarNormal(){
        estadoC=avionC.despergarAvionC(estadoC);
        menu();
    }
    
    /**
     * menu que se encarga de llevarlo al metodo para reservar las sillas del avion
     */
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
    
    /**
     * metodo que se encarga de la reserva de los datos  de la silla 
     */
    public void reservaNormal(){
            try{
                String idComparar="avionNormal";
                System.out.println("-----Reserva Avion Normal----- ");
                System.out.println("\nDigite El id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionB.buscarSillasNormalesSinCambio(numeroSilla);
                validacionReservaAvionB(valor);
                System.out.println("Digite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Digite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Digite su Fecha de nacimiento(YYYY-MM-DD): ");
                String fech = scanner.next();
                Date fecha = validacionFechaNormal(fech);
                if(fecha != null){
                    avionB.buscarSillasNormales(numeroSilla);
                    Silla asiento = new Silla(3000,numeroSilla);
                    Cliente cl = new Cliente(id, nomb, fecha);
                    asiento.getListaCliente().add(cl);
                    avionB.sillaAvion.add(asiento);
                    continuarNormal();
                }
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaNormal();
            }
    }
    
   
    /**
     * Metodo que se encarga de la validacion, de si la silla, que quiere reservar, 
     * esta disponible segun el valor retornado
     *     1. se usa para cuando encuentra el valor y la reserva de la silla se puede hacer 
     *    -1. Se usa para cuando el valor que digito la persona no se encuentra en la matriz 
     *    -2. Se usa para validar que la reserva ya fue hecha
     * @param valor = es un entero que retorna de la busqueda en la matriz su valor puede ser 1, -1, -2 
     */
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
    
    /**
     * Metodo que se encarga de preguntar si desea continuar reservando asientos del avion misxto
     * si desea continuar sera retornado al metodo menuReservarAvionNormal() si su respuesta es no 
     * se retornara a el menu menuAvionNormal()
     */
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
    
    
    
    /**
     * metodo que Recibe un string y se encarga de hacer el parseo a fecha
     * @param fec = string que se envia con la fecha
     * @return fecha = valor que retorna el cual puede tener dos opciones null cuando se le envian vacios, o la fecha 
     * parseada el formato especificado
     */
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
   
    /**
     * menu que se encarga del menu del avion exclusivo, donde se puede reservar un asiento o despegar un avion 
     */
    public void menuAvionExclusivo(){
        if(estadoB == 1){
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
                    despegarExclusivo();
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
        }else if (estadoB != 1){
            System.out.println("\n<<<<---------El avion ya despego--------->>>>");
            menu();
        }
    }
    
    /**
     * metodo que se encarga de el despuege del avion se guarda en la variable contador el resultado que retorna 
     * que debe ser -1 el cual nos dara la indicacion que el avion, ya despego
     */
    public void despegarExclusivo(){
        estadoB=avionB.despergarAvionB(estadoB);
        menu();
    }
    
    /**
     * menu que se encarga de la reserva de asientos del avion
     */
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
    
    
    /**
     * metodo que se encarga de pedir todos los datos para la guardar la reserva del avion exclusivo
     */
    public void reservaExclusivo(){
            try{
                String idComparar="avionExclusivo";
                System.out.println("-----Reserva Avion Exclusivo----- ");
                System.out.println("\nDigite El id de la silla: ");
                String numeroSilla = scanner.next();
                int valor = avionC.buscarSillasExclusivasSinCambio(numeroSilla);
                validacionReservaAvionExclusivo(valor);
                System.out.println("Digite la su Identificacion: ");
                int id = scanner.nextInt();
                System.out.println("Digite la su nombre: ");
                String nomb = scanner.next();
                excepcionSolocadena(nomb, idComparar);
                System.out.println("Digite su Fecha de nacimiento(YYYY-MM-DD): ");
                String fech = scanner.next();
                Date fecha = validacionFechaExclusiva(fech);
                if(fecha != null){
                    avionC.buscarSillasExclusivas(numeroSilla);
                    Silla asiento = new Silla(3000,numeroSilla);
                    Cliente cl = new Cliente(id, nomb, fecha);
                    asiento.getListaCliente().add(cl);
                    avionC.sillaAvion.add(asiento);
                    continuarNormal();
                }
                
            }catch(InputMismatchException e){
                System.out.println("\n <<<-----Profavor ingrese un numero, venta cancelada----->>>");
                scanner = new Scanner(System.in);
                reservaNormal();
            }
    }
    
    /**
     * Metodo que se encarga de la validacion, de si la silla, que quiere reservar, 
     * esta disponible segun el valor retornado
     *     1. se usa para cuando encuentra el valor y la reserva de la silla se puede hacer 
     *    -1. Se usa para cuando el valor que digito la persona no se encuentra en la matriz 
     *    -2. Se usa para validar que la reserva ya fue hecha
     * @param valor = es un entero que retorna de la busqueda en la matriz su valor puede ser 1, -1, -2 
     */
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
    
    /**
     * metodo que Recibe un string y se encarga de hacer el parseo a fecha
     * @param fec = string que se envia con la fecha
     * @return fecha = valor que retorna el cual puede tener dos opciones null cuando se le envian vacios, o la fecha 
     * parseada el formato especificado
     */
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
    
    /**
     * Metodo que se encarga de preguntar si desea continuar reservando asientos del avion misxto
     * si desea continuar sera retornado al metodo menuReservarAvionExclusivo() si su respuesta es no 
     * se retornara a el menu menuAvionExclusivo()
     */
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
