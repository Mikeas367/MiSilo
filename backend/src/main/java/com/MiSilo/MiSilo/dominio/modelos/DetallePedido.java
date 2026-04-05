package com.MiSilo.MiSilo.dominio.modelos;

public class DetallePedido {
    private final TipoDeBolsa tipoDeBolsa;
    private int cantidad;
    private double subTotalKilos;

    public DetallePedido(TipoDeBolsa tipoDeBolsa, int cantidad) {
        this.tipoDeBolsa = tipoDeBolsa;
        this.cantidad = cantidad;
    }

    public void calcularSubTotalKilos(){
        this.subTotalKilos = this.cantidad * tipoDeBolsa.getPeso();
    }

    public double getSubTotalKilos() {
        return subTotalKilos;
    }

    public TipoDeBolsa getTipoDeBolsa() {
        return tipoDeBolsa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setSubTotalKilos(double subTotalKilos) {
        this.subTotalKilos = subTotalKilos;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "tipoDeBolsa=" + tipoDeBolsa +
                ", cantidad=" + cantidad +
                ", subTotalKilos=" + subTotalKilos +
                '}';
    }
}
