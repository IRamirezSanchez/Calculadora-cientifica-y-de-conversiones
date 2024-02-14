package org.example.Controlador;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import org.example.Modelo.Operaciones_Matematicas;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraController
{

    @FXML
    private Button c_multiplicar;
    @FXML
    private Button b_tres;
    @FXML
    private Button b_siete;
    @FXML
    private Button b_uno;
    @FXML
    private Button c_dividir;
    @FXML
    private Button b_cuatro;
    @FXML
    private Label label_control;
    @FXML
    private Button c_sumar;
    @FXML
    private Button b_ocho;
    @FXML
    private Button b_seis;
    @FXML
    private Button c_restar;
    @FXML
    private Button b_cinco;
    @FXML
    private Button c_limpiar;
    @FXML
    private Label label_Resultado;
    @FXML
    private Button b_cero;
    @FXML
    private Button b_dos;
    @FXML
    private Button c_igual;
    private String operacion;
    private String enMemoria;
    private String enMemoria2;
    @FXML
    private Button b_nueve;
    @FXML
    private Button c_memoriaMas;
    @FXML
    private Button c_punto;
    @FXML
    private Button c_signoMasMenos;
    @FXML
    private Button c_memoriaMenos;
    boolean flag;
    @FXML
    private Label l_memoria;

    @javafx.fxml.FXML
    public void initialize() {
        operacion= "";
        enMemoria= "";
        flag=false;
        controlOperador(true);

    }

    private void mostrarMensajeError(String mensaje) {
        label_control.setText(mensaje);
        label_control.setVisible(true);
        label_Resultado.setText("");
    }

    @FXML
    public void click_cero(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "0");controlOperador(false);}

    @FXML
    public void click_uno(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "1");controlOperador(false);}

    @FXML
    public void click_dos(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "2");controlOperador(false);}

    @FXML
    public void click_tres(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "3");controlOperador(false);}

    @FXML
    public void click_cuatro(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "4");controlOperador(false);}

    @FXML
    public void click_cinco(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "5");controlOperador(false);}

    @FXML
    public void click_seis(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "6");controlOperador(false);}

    @FXML
    public void click_siete(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "7");controlOperador(false);}

    @FXML
    public void click_ocho(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "8");controlOperador(false);}

    @FXML
    public void click_nueve(ActionEvent actionEvent) {label_Resultado.setText(operacion+= "9");controlOperador(false);}

    @FXML
    public void click_sumar(ActionEvent actionEvent) {
        label_Resultado.setText(operacion += "+");
        if(operacion.equals("+")){
            operacion="";
        }else {
            controlBotones(false);
        }
        controlOperador(true);
    }

    @FXML
    public void click_dividir(ActionEvent actionEvent) {
        label_Resultado.setText(operacion+= "/");
        if(operacion.equals("/")){
            operacion="";
        }else {
            controlBotones(false);
        }
        controlOperador(true);
    }

    @FXML
    public void click_restar(ActionEvent actionEvent) {
        label_Resultado.setText(operacion+= "-");
        if(operacion.equals("-")){
            operacion="";
        }else {
            controlBotones(false);
        }
        controlOperador(true);
    }

    @FXML
    public void click_multiplicar(ActionEvent actionEvent) {
        label_Resultado.setText(operacion+= "*");
        if(operacion.equals("*")){
            operacion="";
        }else {
            controlBotones(false);
        }
        controlOperador(true);
    }

    @FXML
    public void click_punto(ActionEvent actionEvent) {
        if (!operacion.isEmpty() && !operacion.endsWith(".") && !operacion.matches(".*[+\\-*/]\\d*\\.\\d*$")) {
            operacion += ".";
            label_Resultado.setText(operacion);
        }
    }

    @FXML
    public void click_memoriaGuardar(ActionEvent actionEvent) {
        enMemoria2=operacion;
        double resultadoAux=Double.parseDouble(enMemoria2);
        if (resultadoAux % 1 == 0) {
            l_memoria.setText(String.valueOf((int) resultadoAux));
        } else {
            l_memoria.setText(String.valueOf(resultadoAux));
        }
    }

    @FXML
    public void click_signoMasMenos(ActionEvent actionEvent) {
        if (!operacion.startsWith("+") && !operacion.startsWith("-")) {
            if (flag) {
                operacion = "-" + operacion;
                flag = false;
            } else {
                operacion = "+" + operacion;
                flag = true;
            }
        } else {
            if (operacion.startsWith("+")) {
                operacion = operacion.replace("+", "-");
            } else if (operacion.startsWith("-")) {
                operacion = operacion.replace("-", "+");
            }
        }

        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_memoriaRecuperar(ActionEvent actionEvent) {
        try {
            if (enMemoria2 != null) {
                label_Resultado.setText(operacion = operacion + enMemoria2);
                l_memoria.setText("");
                controlOperador(false);
            }
        }catch(NullPointerException e){
            e.getMessage();
        }
    }

    @FXML
    public void click_resultado(ActionEvent actionEvent) {
        String [] partes = operacion.split("[/*\\-+]");
        if (partes.length >= 2) {
            double resultado = Double.parseDouble(partes[0]);
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
                            case '/':
                                // Manejar la división por cero
                                if (numero != 0) {
                                    resultado /= numero;
                                } else {
                                    mostrarMensajeError("Error: División por cero.");
                                    controlBotones(true);
                                    return;
                                }
                                break;
                        }

            }
            if (resultado % 1 == 0) {
                label_Resultado.setText(String.valueOf((int) resultado));
                enMemoria=String.valueOf((int)resultado);
            } else {
                label_Resultado.setText(String.valueOf(resultado));
                enMemoria=String.valueOf(resultado);
            }
            controlBotones(true);
            label_control.setVisible(false);
            enMemoria=String.valueOf(resultado);
            operacion=enMemoria;
            enMemoria="";
        } else {
            mostrarMensajeError("Error! Formato incorrecto.");
        }


    }

    @FXML
    public void click_resetear(ActionEvent actionEvent) {
        label_control.setVisible(false);
        label_Resultado.setText(operacion="");
        controlBotones(false);
        controlOperador(true);
    }

    private void controlBotones(boolean aux){
        b_cero.setDisable(aux);
        b_uno.setDisable(aux);
        b_dos.setDisable(aux);
        b_tres.setDisable(aux);
        b_cuatro.setDisable(aux);
        b_cinco.setDisable(aux);
        b_seis.setDisable(aux);
        b_siete.setDisable(aux);
        b_ocho.setDisable(aux);
        b_nueve.setDisable(aux);
    }

    private void controlOperador(boolean aux){
        c_dividir.setDisable(aux);
        c_igual.setDisable(aux);
        c_multiplicar.setDisable(aux);
        c_sumar.setDisable(aux);
        c_restar.setDisable(aux);
        c_signoMasMenos.setDisable(aux);
    }


}