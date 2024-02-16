package org.example.Modelo;

public class Operaciones_Matematicas {
    static double resultado;
    public static String operacion(String operacion) {
        String[] partes = operacion.split("[/*\\-+^]");
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
        operacion= comprobarNumeroEntero(resultado);
        return operacion;
    }

    public static String control_trigo(String operacion){
        double result=0;
        if(!operacion.isEmpty()){
            String[] numeros= operacion.split("-");

            switch(numeros[1]){
                case "sen":
                    result = Math.sin(Math.toRadians(Integer.parseInt(numeros[0])));
                    operacion=redondear(result);
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(Integer.parseInt(numeros[0])));
                    operacion=redondear(result);
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(Integer.parseInt(numeros[0])));
                    operacion=redondear(result);
                    break;
                default:
                    result = 0;
                    operacion=redondear(result);
                    break;
            }
        }else{
            return "Introduce un digito";
        }
        return operacion;
    }


    public static String comprobarNumeroEntero(double numero){
        String aux="";
        if (numero % 1 == 0) {
            aux=String.valueOf((int) numero);
        } else {
            aux=redondear(numero);
        }
        return aux;
    }

    public static String redondear(double numero){
        int decimales = 9;
        double factor = Math.pow(10, decimales);
        double numeroRedondeado = Math.round(numero * factor) / factor;

        return String.format("%.9f", numeroRedondeado);
    }
}


