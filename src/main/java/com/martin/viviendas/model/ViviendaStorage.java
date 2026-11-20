package com.martin.viviendas.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViviendaStorage {
    private static final String ARCHIVO = "viviendas.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarViviendas(List<Vivienda> viviendas) {
        ViviendasData data = new ViviendasData();
        for (Vivienda v : viviendas) {
            if (v instanceof Casa casa) {
                data.casas.add(casa);
            } else if (v instanceof Departamento depto) {
                data.departamentos.add(depto);
            }
        }

        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Vivienda> cargarViviendas() {
        List<Vivienda> resultado = new ArrayList<>();
        try (FileReader reader = new FileReader(ARCHIVO)) {
            ViviendasData data = gson.fromJson(reader, ViviendasData.class);
            if (data != null) {
                if (data.casas != null) {
                    resultado.addAll(data.casas);
                }
                if (data.departamentos != null) {
                    resultado.addAll(data.departamentos);
                }
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("No se encontró el archivo o estuvo vacío, creando lista nueva...");
            return resultado;
        }
    }

    public static class ViviendasData {
        public List<Casa> casas = new ArrayList<>();
        public List<Departamento> departamentos = new ArrayList<>();
    }
}