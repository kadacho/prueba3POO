package com.martin.viviendas.controller;

import com.martin.viviendas.model.Casa;
import com.martin.viviendas.model.Vivienda;
import com.martin.viviendas.model.ViviendaStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViviendasController implements Initializable {
    @FXML
    private TableView<Vivienda> tablaViviendas;
    @FXML
    private TableColumn<Vivienda, String> colTipo;
    @FXML
    private TableColumn<Vivienda, String> colCodigo;
    @FXML
    private TableColumn<Vivienda, Integer> colSuperficie;
    @FXML
    private TableColumn<Vivienda, Integer> colHabitaciones;
    @FXML
    private TableColumn<Vivienda, Integer> colCosto;

    public ObservableList<Vivienda> listaViviendas;

    private void cargarDatos() {
        listaViviendas = FXCollections.observableArrayList(ViviendaStorage.cargarViviendas());
        tablaViviendas.setItems(listaViviendas);;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaViviendas = FXCollections.observableArrayList();
        colTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));
        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigoPropiedad"));
        colSuperficie.setCellValueFactory(
                new PropertyValueFactory<>("superficie"));
        colHabitaciones.setCellValueFactory(
                new PropertyValueFactory<>("numeroHabitaciones"));
        colCosto.setCellValueFactory(
                new PropertyValueFactory<>("CostoArriendo"));
        tablaViviendas.setItems(listaViviendas);
        cargarDatos();
    }

    @FXML
    private void eliminarVivienda() {
        Vivienda juegoSeleccionado = tablaViviendas.getSelectionModel().getSelectedItem();
        listaViviendas.remove(juegoSeleccionado);
        ViviendaStorage.guardarViviendas(listaViviendas);
    }


    @FXML
    private void irFormulario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/martin/viviendas/agregar/ventana-agregar.fxml"));
            Parent root = loader.load();

            AgregarVivienda controller = loader.getController();
            controller.setListaViviendas(listaViviendas);

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Formulario");
            nuevaVentana.setScene(new Scene(root));

            Stage ventanaPrincipal = (Stage) ((Node) event.getSource()).getScene().getWindow();
            nuevaVentana.initOwner(ventanaPrincipal);
            nuevaVentana.initModality(Modality.WINDOW_MODAL);

            nuevaVentana.showAndWait();
            tablaViviendas.refresh();
        } catch (IOException e) {
            System.err.println("Error al cargar ventana-agregar.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }


}

