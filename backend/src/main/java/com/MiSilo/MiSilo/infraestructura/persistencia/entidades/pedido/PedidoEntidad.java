package com.MiSilo.MiSilo.infraestructura.persistencia.entidades.pedido;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime fechaPedido;
    private double totalKilos;
    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetallePedidoEntidad> items = new ArrayList<>();


    public void agregarItems(List<DetallePedidoEntidad> detallesPedidoEntidad) {
        for (DetallePedidoEntidad detallePedidoEntidad : detallesPedidoEntidad){
            items.add(detallePedidoEntidad);
            detallePedidoEntidad.setPedido(this);
        }
    }

    public PedidoEntidad(LocalDateTime fechaPedido, double totalKilos, List<DetallePedidoEntidad> items) {
        this.fechaPedido = fechaPedido;
        this.totalKilos = totalKilos;
        agregarItems(items);
    }

    public PedidoEntidad() {
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public double getTotalKilos() {
        return totalKilos;
    }

    public List<DetallePedidoEntidad> getItems() {
        return items;
    }

    public void setItems(List<DetallePedidoEntidad> items) {
        this.items = items;
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
}
