package org.example.Controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraCientificaController implements Initializable
{

    @FXML
    private Label label_control;
    @FXML
    private Label label_Resultado;

    @FXML
    private Button c_memoriaMas;
    @FXML
    private Button c_memoriaMenos;
    @FXML
    private Button c_signoMasMenos;



    @FXML
    private Button c_dividir;
    @FXML
    private Button c_multiplicar;
    @FXML
    private Button c_sumar;
    @FXML
    private Button c_restar;
    @FXML
    private Button c_potencia;
    @FXML
    private Button c_sen;
    @FXML
    private Button c_tan;
    @FXML
    private Button c_cos;


    @FXML
    private Button c_igual;
    @FXML
    private Button c_limpiar;
    @FXML
    private Label l_memoria;



    @FXML
    private Button b_cinco;
    @FXML
    private Button b_cuatro;
    @FXML
    private Button c_punto;
    @FXML
    private Button b_ocho;
    @FXML
    private Button b_cero;
    @FXML
    private Button b_dos;
    @FXML
    private Button b_siete;
    @FXML
    private Button b_seis;
    @FXML
    private Button b_nueve;
    @FXML
    private Button b_tres;
    @FXML
    private Button b_uno;

    private char operacionActual = ' ';
    private double valorPrevio = 0;
    @FXML
    private AnchorPane ventanaCientifica;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        c_sumar.setOnAction(e -> realizarOperacion('+'));
        c_restar.setOnAction(e -> realizarOperacion('-'));
        c_multiplicar.setOnAction(e -> realizarOperacion('*'));
        c_dividir.setOnAction(e -> realizarOperacion('/'));
        c_potencia.setOnAction(e -> realizarOperacion('P'));
        c_sen.setOnAction(e -> realizarOperacion('S'));
        c_tan.setOnAction(e -> realizarOperacion('T'));
        c_cos.setOnAction(e -> realizarOperacion('C'));
        c_igual.setOnAction(e -> calcularResultado());
        c_limpiar.setOnAction(e -> limpiar());
    }

    @FXML
    public void click_seis(ActionEvent actionEvent) {
    }

    @FXML
    public void click_punto(ActionEvent actionEvent) {
    }

    @FXML
    public void click_siete(ActionEvent actionEvent) {
    }

    @FXML
    public void click_resultado(ActionEvent actionEvent) {
    }

    @FXML
    public void click_memoriaGuardar(ActionEvent actionEvent) {
    }

    @FXML
    public void click_signoMasMenos(ActionEvent actionEvent) {
    }

    @FXML
    public void click_memoriaRecuperar(ActionEvent actionEvent) {
    }

    @FXML
    public void click_sumar(ActionEvent actionEvent) {
    }

    @FXML
    public void click_resetear(ActionEvent actionEvent) {
    }

    @FXML
    public void click_tres(ActionEvent actionEvent) {
    }

    @FXML
    public void click_cinco(ActionEvent actionEvent) {
    }

    @FXML
    public void click_dos(ActionEvent actionEvent) {
    }

    @FXML
    public void click_nueve(ActionEvent actionEvent) {
    }

    @FXML
    public void click_dividir(ActionEvent actionEvent) {
    }

    @FXML
    public void click_cuatro(ActionEvent actionEvent) {
    }

    @FXML
    public void click_uno(ActionEvent actionEvent) {
    }

    @FXML
    public void click_restar(ActionEvent actionEvent) {
    }

    @FXML
    public void click_ocho(ActionEvent actionEvent) {
    }

    @FXML
    public void click_cero(ActionEvent actionEvent) {
    }

    @FXML
    public void click_multiplicar(ActionEvent actionEvent) {
    }


    private void realizarOperacion(char operacion) {
        operacionActual = operacion;
        valorPrevio = Double.parseDouble(label_Resultado.getText());
        label_control.setText(label_Resultado.getText() + " " + operacion);
        label_Resultado.setText("");
    }

    private void calcularResultado() {
        double valorActual = Double.parseDouble(label_Resultado.getText());
        double resultado = 0;
        try {
            switch (operacionActual) {
                case 'P':
                    resultado = Math.pow(valorPrevio, valorActual);
                    break;
                case 'S':
                    resultado = Math.sin(Math.toRadians(valorActual));
                    break;
                case 'T':
                    resultado = Math.tan(Math.toRadians(valorActual));
                    break;
                case 'C':
                    resultado = Math.cos(Math.toRadians(valorActual));
                    break;
                case '+':
                    resultado = valorPrevio + valorActual;
                    break;
                case '-':
                    resultado = valorPrevio - valorActual;
                    break;
                case '*':
                    resultado = valorPrevio * valorActual;
                    break;
                case '/':
                    if (valorActual == 0) throw new ArithmeticException("División por cero");
                    resultado = valorPrevio / valorActual;
                    break;
            }
            label_Resultado.setText(String.valueOf(resultado));
        } catch (ArithmeticException e) {
            label_Resultado.setText("Error");
            // Manejo adicional de errores aquí
        } finally {
            valorPrevio = 0; // Restablecer para la próxima operación
            operacionActual = ' ';
        }
    }

    private void limpiar() {
        label_Resultado.setText("");
        label_control.setText("");
        valorPrevio = 0;
        operacionActual = ' ';
    }

    @FXML
    public void porTeclado(Event event) {
    }

    public double getTamañoPreferidoAncho() {
        return ventanaCientifica.getPrefWidth();
    }

    public double getTamañoPreferidoAlto() {
        return ventanaCientifica.getPrefHeight();
    }

    @FXML
    public void CventanaNormal(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/Vista/calculadoraController.fxml"));
        AnchorPane panel = loader.load();

        CalculadoraController normalController = loader.getController();

        panel.setPrefWidth(normalController.getTamañoPreferidoAncho());
        panel.setPrefHeight(normalController.getTamañoPreferidoAlto());

        Scene nuevaScene = new Scene(panel);

        Stage stage = (Stage) ventanaCientifica.getScene().getWindow();  // Obtiene la Stage actual
        stage.setScene(nuevaScene);

        stage.show();
    }
}