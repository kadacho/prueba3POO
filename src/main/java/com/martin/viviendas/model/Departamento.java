package com.martin.viviendas.model;

public class Departamento extends Vivienda {
    private Integer numeroPiso;
    private boolean alDia;

    public Departamento() {
    }

    public Departamento(String codigoPropiedad, Double superficie, Integer numeroHabitaciones, Integer numeroPiso, boolean alDia) {
        super(codigoPropiedad, superficie, numeroHabitaciones);
        this.numeroPiso = numeroPiso;
        this.alDia = alDia;
    }

    public Integer getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(Integer numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public boolean isAlDia() {
        return alDia;
    }

    public void setAlDia(boolean alDia) {
        this.alDia = alDia;
    }
}
