package com.martin.viviendas.model;

public class CreaViviendas {

    public Vivienda crearVivienda(String tipo, String codigo, Double superficie, Integer habitaciones, boolean tienePatio, Integer numeroPiso, boolean alDia) {

        if (tipo.equals("Casa")) {
            return new Casa(codigo, superficie, habitaciones, tienePatio);
        }

        return new Departamento(codigo, superficie, habitaciones, numeroPiso, alDia);
    }
}
