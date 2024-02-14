package org.example.Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operaciones_Matematicas {

    public static double sumar(double valor1,double valor2){
        try {
            return redondear(valor1 + valor2);
        } catch (NumberFormatException e) {
            System.err.println("Error: Debes proporcionar dos valores enteros como parámetros.");
            return -1;
        }
    }

    public static double restar(double valor1,double valor2){
        try {
            return redondear(valor1 - valor2);
        } catch (NumberFormatException e) {
            System.err.println("Error: Debes proporcionar dos valores enteros como parámetros.");
            return -1;
        }
    }

    public static double multiplicar(double valor1,double valor2){
        try {
            return redondear(valor1 * valor2);
        } catch (NumberFormatException e) {
            System.err.println("Error: Debes proporcionar dos valores enteros como parámetros.");
            return -1;
        }
    }

    public static double dividir(double valor1,double valor2){
        try {
            return redondear(valor1 / valor2);
        } catch (NumberFormatException e) {
            System.err.println("Error: Debes proporcionar dos valores enteros como parámetros.");
            return -1;
        }
    }

    private static double redondear(double valor) {
        //newScale cuantos decimales quieres!
        BigDecimal bd = new BigDecimal(valor).setScale(6, RoundingMode.UP);
        return bd.doubleValue();
    }

    public static boolean esNumero(String texto) {
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
