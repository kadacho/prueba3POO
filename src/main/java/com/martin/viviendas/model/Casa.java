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

    @Override
    public Double calcularCostoArriendo() {
        Double costo = 250000.0;
        if (tienePatio) {
            return costo * 1.1;
        }
        return costo;
    }

    @Override
    public double getCostoArriendo() {
        return calcularCostoArriendo();
    }

    @Override
    public String getTipo() {
        return "Casa";
    }
}
