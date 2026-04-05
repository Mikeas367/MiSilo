package com.MiSilo.MiSilo.dominio.modelos;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private long id;
    private List<DetallePedido> detallePedidos;
    private LocalDateTime fechaPedido;
    private double totalKilos;

    public void calcularTotalKilos(){
        for(DetallePedido dp : detallePedidos){
            dp.calcularSubTotalKilos();
            this.totalKilos += dp.getSubTotalKilos();
        }
    }


    public Pedido(List<DetallePedido> detallePedidos, LocalDateTime fechaPedido) {
        this.detallePedidos = detallePedidos;
        this.fechaPedido = fechaPedido;
    }

    public Pedido() {
    }

    public long getId() {
        return id;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public double getTotalKilos() {
        return totalKilos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setTotalKilos(double totalKilos) {
        this.totalKilos = totalKilos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", detallePedidos=" + detallePedidos +
                ", fechaPedido=" + fechaPedido +
                ", totalKilos=" + totalKilos +
                '}';
    }
}
