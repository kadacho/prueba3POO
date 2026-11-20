package com.martin.viviendas.model;

public abstract class Vivienda {
    private String codigoPropiedad;
    private Double superficie;
    private Integer numeroHabitaciones;

    public Vivienda() {
    }

    public Vivienda(String codigoPropiedad, Double superficie, Integer numeroHabitaciones) {
        this.codigoPropiedad = codigoPropiedad;
        this.superficie = superficie;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(String codigoPropiedad) {
        this.codigoPropiedad = codigoPropiedad;
    }

    public Double getSuperficie() {
        if (superficie > 20 && superficie < 500)
            return superficie;
        throw new IllegalArgumentException();
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public Integer getNumeroHabitaciones() {
        if (numeroHabitaciones>1)
            return numeroHabitaciones;
        throw new IllegalArgumentException();
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Double calcularCostoArriendo() {
        return 0.0;
    }

    public String verificarCodigo() {
        if (codigoPropiedad.isBlank()) {
            return codigoPropiedad;
        }
        throw new IllegalArgumentException();
    }

    public double getCostoArriendo() {
        return calcularCostoArriendo();
    }

    public String getTipo() {
        return "Vivienda";
    }
}
