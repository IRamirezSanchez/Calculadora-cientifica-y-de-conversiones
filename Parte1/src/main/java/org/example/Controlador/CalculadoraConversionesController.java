package org.example.Controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.Modelo.ConvertidorMonedas;
import org.example.Modelo.Operaciones_Matematicas;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CalculadoraConversionesController implements Initializable {


    @FXML
    private Button c_igual;
    @FXML
    private Label l_memoria;
    @FXML
    private Button b_tres;
    @FXML
    private Button b_siete;
    @FXML
    private Button b_uno;
    @FXML
    private ChoiceBox CB_dos;
    @FXML
    private Button b_cuatro;
    @FXML
    private Button c_punto;
    @FXML
    private Label label_control;
    @FXML
    private Button b_ocho;
    @FXML
    private Button b_seis;
    @FXML
    private Button b_nueve;
    @FXML
    private Button b_cinco;
    @FXML
    private ChoiceBox CB_uno;
    @FXML
    private Button c_limpiar;
    @FXML
    private Label label_Resultado;
    @FXML
    private Button b_cero;
    @FXML
    private Button b_dos;
    @FXML
    private ChoiceBox CB_tres;
    @FXML
    private AnchorPane ventanaConversiones;
    private String operacion;
    private String memoria;
    private ConvertidorMonedas convertidor;
    private List<String> opciones;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operacion="";
        memoria="";
        convertidor= new ConvertidorMonedas();
        opciones=List.of("Monedas", "Longitud", "Tiempo");
    }

    public double getTamañoPreferidoAncho() {
        return ventanaConversiones.getPrefWidth();
    }

    public double getTamañoPreferidoAlto() {
        return ventanaConversiones.getPrefHeight();
    }

    @FXML
    public void porTeclado(Event event) {
        if (event instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) event;
            String teclaPresionada = keyEvent.getText();
            if (teclaPresionada.matches("[0-9,.]")) {
                operacion += teclaPresionada;
                label_Resultado.setText(operacion);
            } else if (((KeyEvent) event).getCode() == KeyCode.BACK_SPACE) {
                if (!operacion.isEmpty()) {
                    operacion = operacion.substring(0, operacion.length() - 1);
                    label_Resultado.setText(operacion);
                }
            }
        }
    }

    @FXML
    public void CabrirAyuda(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/Vista/panelConversion.fxml"));
        Pane root = (Pane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Ventana Modal");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    public void CventanaNormal(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/Vista/calculadoraController.fxml"));
        AnchorPane panel = loader.load();

        CalculadoraController normalController = loader.getController();

        panel.setPrefWidth(normalController.getTamañoPreferidoAncho());
        panel.setPrefHeight(normalController.getTamañoPreferidoAlto());

        Scene nuevaScene = new Scene(panel);

        Stage stage = (Stage) ventanaConversiones.getScene().getWindow();
        stage.setScene(nuevaScene);

        stage.show();
    }
    @FXML
    public void CventanaCientifica(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/Vista/calculadoraCientificaController.fxml"));
        AnchorPane panel = loader.load();

        CalculadoraCientificaController normalController = loader.getController();

        panel.setPrefWidth(normalController.getTamañoPreferidoAncho());
        panel.setPrefHeight(normalController.getTamañoPreferidoAlto());

        Scene nuevaScene = new Scene(panel);

        Stage stage = (Stage) ventanaConversiones.getScene().getWindow();
        stage.setScene(nuevaScene);

        stage.show();
    }
    @FXML
    public void click_resultado(ActionEvent actionEvent) {
            double numero=Double.parseDouble(operacion);
            double conversor =Double.parseDouble(convertidor.getExchangeRate(String.valueOf(CB_dos.getValue()),String.valueOf(CB_tres.getValue())));
            operacion= String.valueOf(Operaciones_Matematicas.redondear(numero*conversor));
            label_Resultado.setText(operacion);
    }

    @FXML
    public void click_limpiar(ActionEvent actionEvent) {
        operacion="";
        label_Resultado.setText(operacion);
    }

    @FXML
    public void opcionesDisponibles(Event event) {
        CB_uno.getItems().clear();
        CB_uno.getItems().addAll(opciones);

        CB_uno.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Monedas")) {
                CB_dos.getItems().clear();
                CB_tres.getItems().clear();
                CB_dos.getItems().addAll(convertidor.getTargetCurrencies());
                CB_tres.getItems().addAll(convertidor.getTargetCurrencies());
            } else if (newValue.equals("Longitud")) {
                System.out.println("Seleccionado: Longitud");
            } else if (newValue.equals("Tiempo")) {
                System.out.println("Seleccionado: Tiempo");
            } else {
                System.out.println("Selección no reconocida");
            }
        });
    }



    @FXML
    public void click_punto(ActionEvent actionEvent) {
        operacion += '.';
        label_Resultado.setText(operacion);
    }


    @FXML
    public void click_cero(ActionEvent actionEvent) {
        operacion += '0';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_uno(ActionEvent actionEvent) {
        operacion += '1';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_dos(ActionEvent actionEvent) {
        operacion += '2';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_tres(ActionEvent actionEvent) {
        operacion += '3';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_cuatro(ActionEvent actionEvent) {
        operacion += '4';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_cinco(ActionEvent actionEvent) {
        operacion += '5';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_seis(ActionEvent actionEvent) {
        operacion += '6';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_siete(ActionEvent actionEvent) {
        operacion += '7';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_ocho(ActionEvent actionEvent) {
        operacion += '8';
        label_Resultado.setText(operacion);
    }

    @FXML
    public void click_nueve(ActionEvent actionEvent) {
        operacion += '9';
        label_Resultado.setText(operacion);
    }



}
