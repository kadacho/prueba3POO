package com.martin.viviendas.controller;

import com.martin.viviendas.model.Casa;
import com.martin.viviendas.model.Departamento;
import com.martin.viviendas.model.Vivienda;
import com.martin.viviendas.model.ViviendaStorage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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

    public void setListaViviendas(ObservableList<Vivienda> listaViviendas) {
        this.listaViviendas = listaViviendas;
    }

    @FXML
    public void agregarVivienda() {
        try {
            String tipo = viviendaTipo.getValue();
            String codigo = txtCodigo.getText();
            double superficie = Double.parseDouble(txtSuperficie.getText().trim());
            int habitaciones = Integer.parseInt(txtHabitaciones.getText().trim());
            boolean tienePatio = "Si".equals(comboTienePatio.getValue());
            int numeroPiso = 0;
            if ("Departamento".equals(tipo) && !txtPiso.getText().trim().isEmpty()) {
                numeroPiso = Integer.parseInt(txtPiso.getText().trim());
            }
            boolean alDia = "Si".equals(comboAlDia.getValue());
            cerrarVentana();
            if ("Casa".equals(tipo)) {
                listaViviendas.add(new Casa(codigo, superficie, habitaciones, tienePatio));
            } else if ("Departamento".equals(tipo)) {
                listaViviendas.add(new Departamento(codigo, superficie, habitaciones, numeroPiso, alDia));
            }
            ViviendaStorage.guardarViviendas(listaViviendas);
        } catch (IllegalArgumentException e) {
            System.out.println("Error");
        }

    }


    private void cerrarVentana() {
        if (botonAgregar != null && botonAgregar.getScene() != null) {
            botonAgregar.getScene().getWindow().hide();
        }
    }

    private void actualizarCamposPorTipo(String tipo) {
        boolean esCasa = "Casa".equals(tipo);
        boolean esDepto = "Departamento".equals(tipo);

        setVisibleManaged(comboTienePatio, esCasa);
        if (!esCasa) {
            comboTienePatio.setValue(null);
        }

        setVisibleManaged(comboAlDia, esDepto);
        setVisibleManaged(txtPiso, esDepto);
        if (!esDepto) {
            comboAlDia.setValue(null);
            txtPiso.clear();
        }
    }

    private void setVisibleManaged(javafx.scene.Node node, boolean visible) {
        node.setVisible(visible);
        node.setManaged(visible);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viviendaTipo.getItems().setAll("Casa", "Departamento");
        comboTienePatio.getItems().setAll("Si", "No");
        comboAlDia.getItems().setAll("Si", "No");

        viviendaTipo.valueProperty().addListener((obs, oldVal, nuevoTipo) -> actualizarCamposPorTipo(nuevoTipo));
        actualizarCamposPorTipo(null);
    }


}
