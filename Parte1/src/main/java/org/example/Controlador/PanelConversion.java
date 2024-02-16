package org.example.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Modelo.ConvertidorMonedas;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelConversion implements Initializable {


    @FXML
    private ComboBox <String> CB_Base;
    @FXML
    private TextField TF_Valor;
    @FXML
    private ComboBox <String> CB_Cambio;
    private ConvertidorMonedas convertidor;
    @FXML
    private Button BTN_ACEPTARySALIR;
    @FXML
    private Button BTN_SALIR;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        convertidor =new ConvertidorMonedas();
        cargarComboBox();

    }


    @FXML
    public void BTN_AceptarySalir(ActionEvent actionEvent) {
        convertidor.setMonedaBase(CB_Base.getValue());
        convertidor.setMonedaTarget(CB_Cambio.getValue());
        convertidor.setValorDelCambio(TF_Valor.getText().toString());
        Stage miStage = (Stage) this.BTN_SALIR.getScene().getWindow();
        miStage.close();
    }

    @FXML
    public void BTN_Salir(ActionEvent actionEvent) {
        Stage miStage = (Stage) this.BTN_SALIR.getScene().getWindow();
        miStage.close();
    }

    private void cargarComboBox(){
        CB_Base.getItems().addAll(convertidor.getTargetCurrencies());
        CB_Cambio.getItems().addAll(convertidor.getTargetCurrencies());
        CB_Base.setOnAction(event -> actualizarValor());
        CB_Cambio.setOnAction(event -> actualizarValor());
    }
    private void actualizarValor(){
        if(CB_Base.getValue()!=null && CB_Cambio.getValue()!=null){
            TF_Valor.setText(convertidor.getExchangeRate(CB_Base.getValue(),CB_Cambio.getValue()));
        }
    }
}
