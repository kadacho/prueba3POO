package com.martin.viviendas.model;

public abstract class Vivienda implements ConEstacionamiento {
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
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
}
