package com.Revan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        System.out.println("*****************");
        System.out.println("\tBienvenido");
        System.out.println("*****************");
        while (true){
            System.out.println("1. Crear una cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar informacion de una cuenta");
            System.out.println("5. Mostrar cuentas");
            System.out.println("6. Salir");
            int opcion = lectorDeDatos.solicitarEntero("Ingrese una opcion:");
            switch (opcion){
                case 1:
                    System.out.println("** Creando una Cuenta **");
                    Random rand = new Random();
                    int numeroCuenta = rand.nextInt(1000);
                    System.out.println("Su numero de Cuenta sera: " + numeroCuenta);
                    System.out.println("Especifique el tipo de cuenta desea crear: ");
                    System.out.println("\t1. Cuenta de Ahorro");
                    System.out.println("\t2. Cuenta a Largo Plazo");
                    int tipoCuenta = lectorDeDatos.solicitarEntero("Especifique el tipo de cuenta desea crear: ");
                    System.out.print("Ingrese el saldo inicial: ");
                    double saldo = lectorDeDatos.solicitarDouble("Ingrese el saldo inicial:");
                    if (tipoCuenta == 1){
                        CuentaAhorro nuevaCuenta = new CuentaAhorro();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada!");
                    } else if(tipoCuenta == 2){
                        CuentaLargoPlazo nuevaCuenta = new CuentaLargoPlazo();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada!");
                    } else{
                        System.out.println("Tipo de cuenta no existe");
                    }
                    break;
                case 2:
                    if (cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas creadas --");
                    } else {
                        System.out.println("** Deposito **");
                    }
                    while (true) {
                        System.out.println("Ingrese el numero de cuenta: ");
                        int numCuentaDep = lectorDeDatos.solicitarEntero("Ingrese el numero de cuenta: ");
                        int x = 0;
                        for (Cuenta c : cuentas) {
                            if (numCuentaDep == c.numCuenta) {
                                System.out.println("Ingrese la cantidad que desea depositar: ");
                                double monto = lectorDeDatos.solicitarDouble("Ingrese la cantidad que desea depositar: ");
                                if (c.depositar(monto) == false) {
                                    System.out.println("Ha excedido el saldo maximo de la cuenta");
                                    x = 2;
                                } else {
                                    System.out.println("El deposito se realizo con exito!");
                                    x = 1;
                                }
                            }
                        }
                        if (x == 0){
                            System.out.println("El numero de cuenta no existe");
                        }else if (x == 1){
                            break;
                        }
                    }
                    break;
                case 3:
                    if (cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas creadas --");
                    } else {
                        System.out.println("** Retiro **");
                    }
                    while (true) {
                        System.out.println("Ingrese el numero de cuenta: ");
                        int numCuentaRet = lectorDeDatos.solicitarEntero("Ingrese el numero de cuenta:");
                        int x = 0;
                        for (Cuenta c : cuentas) {
                            if (numCuentaRet == c.numCuenta) {
                                System.out.println("Ingrese la cantidad que desea retirar: ");
                                double monto = lector.nextDouble();
                                if (c.retirar(monto) == false) {
                                    System.out.println("No puede retirar una cantidad mayor al saldo actual");
                                    x = 2;
                                } else {
                                    System.out.println("El retiro se realizo con exito!");
                                    x = 1;
                                }
                            }
                        }
                        if (x == 0){
                            System.out.println("El numero de cuenta no existe");
                        }else if (x == 1){
                            break;
                        }
                    }
                    break;
                case 4:
                    if (cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas creadas --");
                    } else {
                        System.out.println("** Informacion de Cuentas **");
                    }
                    while (true){
                        System.out.println("Ingrese el numero de cuenta: ");
                        int nCuenta = lector.nextInt();
                        int x = 0;
                        for (Cuenta c: cuentas) {
                            String tipo = "";
                            if (nCuenta == c.numCuenta){
                                x = 1;
                                if (c instanceof CuentaAhorro)
                                    tipo = "Cuenta de Ahorro";
                                else if (c instanceof CuentaLargoPlazo)
                                    tipo = "Cuenta a Largo Plazo";

                                System.out.println("N#: " + c.numCuenta);
                                System.out.println("Saldo: " + c.saldo);
                                System.out.println("Tipo de cuenta: " + tipo);
                            }
                        }
                        if (x == 0)
                            System.out.println("El numero de cuenta no existe");

                        if (nCuenta == -1){
                            break;
                        }
                    }
                    break;
                case 5:
                    // numero de cuenta - Tipo de cuenta
                    if (cuentas.isEmpty()) {
                        System.out.println("-- No hay cuentas --");
                    } else {
                        System.out.println("** Mostrando Cuentas **");
                    }
                    for (Cuenta c : cuentas){
                        String tipo = "";
                        if (c instanceof CuentaAhorro)
                            tipo = "Cuenta de Ahorro";
                        else if (c instanceof  CuentaLargoPlazo)
                            tipo = "Cuenta a Largo Plazo";

                        System.out.println("Numero de Cuenta: " + c.numCuenta + " - " + tipo);
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion == 6){
                break;
            }
        }

    }
    public static int solicitarEntero(String mensaje) {
        Scanner lector = new Scanner(System.in);
        System.out.print(mensaje);
    try {
        int numero= lector.nextInt();
        return numero;
    }
    catch (InputMismatchException e){
        System.out.println("el dato ingresado no es valido");
        return solicitarEntero(mensaje);
    }
    }
    public static double solicitarDouble(String mensaje) {
        Scanner lector = new Scanner(System.in);
        System.out.print(mensaje);
        try {
            double numero= lector.nextDouble();
            return numero;
        }
        catch (InputMismatchException e){
            System.out.print("el dato ingresado no es valido");
            return solicitarDouble(mensaje);
        }
    }
    }

