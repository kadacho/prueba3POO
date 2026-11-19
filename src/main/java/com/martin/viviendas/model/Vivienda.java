package com.martin.viviendas.model;

public class Vivienda {
    private String codigoPropiedad;
    private Integer superficie;
    private Integer numeroHabitaciones;

    public Vivienda() {
    }

    public Vivienda(String codigoPropiedad, Integer superficie, Integer numeroHabitaciones) {
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

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
}
