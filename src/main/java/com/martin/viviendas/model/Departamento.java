package com.martin.viviendas.model;

public class Departamento extends Vivienda {
    private Integer numeroPiso;
    private boolean alDia;
    private boolean tieneEstacionamiento;

    public Departamento() {
    }

    public Departamento(String codigoPropiedad, Integer superficie, Integer numeroHabitaciones, Integer numeroPiso, boolean alDia, boolean tieneEstacionamiento) {
        super(codigoPropiedad, superficie, numeroHabitaciones);
        this.numeroPiso = numeroPiso;
        this.alDia = alDia;
        this.tieneEstacionamiento = tieneEstacionamiento;
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

    public boolean isTieneEstacionamiento() {
        return tieneEstacionamiento;
    }

    public void setTieneEstacionamiento(boolean tieneEstacionamiento) {
        this.tieneEstacionamiento = tieneEstacionamiento;
    }
}
