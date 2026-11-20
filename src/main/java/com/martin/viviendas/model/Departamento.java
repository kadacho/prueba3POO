package com.martin.viviendas.model;

public class Departamento extends Vivienda implements ConEstacionamiento {
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

    @Override
    public Double calcularCostoArriendo() {
        Double costo = 180000.0;
        if (!alDia) {
            return costo * 1.15;
        }
        return costo;
    }

    @Override
    public double getCostoArriendo() {
        return calcularCostoArriendo();
    }

    @Override
    public String getTipo() {
        return "Departamento";
    }
}
