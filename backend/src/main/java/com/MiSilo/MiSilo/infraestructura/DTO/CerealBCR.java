package com.MiSilo.MiSilo.infraestructura.DTO;

public class CerealBCR {
    private String nombreCereal;
    private String precioEnPesos;
    private String precioEnDolar;
    private boolean suba;

    public CerealBCR(String nombreCereal, String precioEnPesos, String precioEnDolar, boolean suba) {
        this.nombreCereal = nombreCereal;
        this.precioEnPesos = precioEnPesos;
        this.precioEnDolar = precioEnDolar;
        this.suba = suba;
    }

    public CerealBCR() {
    }

    public String getNombreCereal() {
        return nombreCereal;
    }

    public String getPrecioEnPesos() {
        return precioEnPesos;
    }

    public String getPrecioEnDolar() {
        return precioEnDolar;
    }

    public boolean isSuba() {
        return suba;
    }

    @Override
    public String toString() {
        return "CerealBCR{" +
                "nombreCereal='" + nombreCereal + '\'' +
                ", precioEnPesos='" + precioEnPesos + '\'' +
                ", precioEnDolar='" + precioEnDolar + '\'' +
                ", suba=" + suba +
                '}';
    }
}
