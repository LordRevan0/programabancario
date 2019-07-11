package com.Revan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class lectorDeDatos {

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
