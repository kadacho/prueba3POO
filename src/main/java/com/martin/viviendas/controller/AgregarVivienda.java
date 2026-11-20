package com.martin.viviendas.controller;

import com.martin.viviendas.model.Casa;
import com.martin.viviendas.model.CreaViviendas;
import com.martin.viviendas.model.Departamento;
import com.martin.viviendas.model.Vivienda;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AgregarVivienda implements Initializable {
    // vivienda
    @FXML private ComboBox<String> viviendaTipo;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtSuperficie;
    @FXML private TextField txtHabitaciones;

    // casa
    @FXML private ComboBox<String> comboTienePatio;

    // departamento
    @FXML private TextField txtPiso;
    @FXML private ComboBox<String> comboAlDia;

    @FXML private Button botonAgregar;

    private ObservableList<Vivienda> listaViviendas;

    public void setListaViviendas(ObservableList<Vivienda> lista) {
        this.listaViviendas = lista;
    }

    @FXML
    public Vivienda agregarVivienda() {
        //vivienda
        String tipo = viviendaTipo.getValue();
        String codigo = txtCodigo.getText();
        Double superficie = Double.parseDouble(txtSuperficie.getText());
        Integer habitaciones = Integer.parseInt(txtHabitaciones.getText());
        //casa
        boolean tienePatio = "Si".equals(comboTienePatio.getValue());
        //departamento
        Integer numeroPiso = Integer.parseInt(txtPiso.getText());
        boolean alDia = "Si".equals(comboAlDia.getValue());

        CreaViviendas agregar = new CreaViviendas();

        return agregar.crearVivienda(tipo, codigo, superficie, habitaciones, tienePatio, numeroPiso, alDia);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viviendaTipo.getItems().setAll("Casa", "Departamento");
        comboTienePatio.getItems().setAll("Si", "No");
        comboAlDia.getItems().setAll("Si", "No");
    }
}
