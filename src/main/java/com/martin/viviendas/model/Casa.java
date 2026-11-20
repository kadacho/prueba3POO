package com.martin.viviendas.model;

public class Casa extends Vivienda {
    private boolean tienePatio;

    public Casa() {
    }

    public Casa(String codigoPropiedad, Double superficie, Integer numeroHabitaciones, boolean tienePatio) {
        super(codigoPropiedad, superficie, numeroHabitaciones);
        this.tienePatio = tienePatio;
    }

    public boolean isTienePatio() {
        return tienePatio;
    }

    public void setTienePatio(boolean tienePatio) {
        this.tienePatio = tienePatio;
    }
}
