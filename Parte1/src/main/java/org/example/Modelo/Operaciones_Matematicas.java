package org.example.Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operaciones_Matematicas {
    static double resultado;
    public static String operacion(String operacion) {
        String[] partes = operacion.split("[/*\\-+]");
        if (partes.length >= 2) {
            resultado = Double.parseDouble(partes[0]);
            // Iterar sobre los operadores y números restantes
            for (int i = 1; i < partes.length; i++) {
                // recorro parte  para saber cuanto ocupa para saber si el siguiente valor es operador
                char operador = operacion.charAt(partes[i - 1].length());

                double numero = Double.parseDouble(partes[i]);

                switch (operador) {
                    case '+':
                        resultado += numero;
                        break;
                    case '-':
                        resultado -= numero;
                        break;
                    case '*':
                        resultado *= numero;
                        break;
                    case '^':
                        resultado = Math.pow(resultado, numero);
                        break;
                    case '/':
                        if (numero != 0) {
                            resultado /= numero;
                        } else {
                            operacion = "Division por Cero";
                            return operacion;

                        }
                        break;
                }

            }

        } else {
            operacion = "Error! Formato incorrecto.";
            return operacion;
        }
        operacion= String.valueOf(resultado);
        return operacion;
    }

    public static String control_trigo(String operacion){
        double result=0;
        if(!operacion.isEmpty()){
            String[] numeros= operacion.split("-");

            switch(numeros[1]){
                case "sin":
                    result = Math.sin(Math.toRadians(Integer.parseInt(numeros[0])));
                    operacion=String.valueOf(result);
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(Integer.parseInt(numeros[0])));
                    operacion=String.valueOf(result);
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(Integer.parseInt(numeros[0])));
                    operacion=String.valueOf(result);
                    break;
                default:
                    result = 0;
                    operacion=String.valueOf(result);
                    break;
            }
        }else{
            return "Introduce un digito";
        }
        return operacion;
    }

}


