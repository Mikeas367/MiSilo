package com.MiSilo.MiSilo.infraestructura.persistencia.entidades.pedido;

import com.MiSilo.MiSilo.dominio.modelos.TipoDeBolsa;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedidos")
public class DetallePedidoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDeBolsa tipoDeBolsa;

    private int cantidad;
    private double subTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoEntidad pedido;

    public DetallePedidoEntidad() {
    }

    public DetallePedidoEntidad(TipoDeBolsa tipoDeBolsa, int cantidad, double subTotal) {
        this.tipoDeBolsa = tipoDeBolsa;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public void setPedido(PedidoEntidad pedido) {
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public TipoDeBolsa getTipoDeBolsa() {
        return tipoDeBolsa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public PedidoEntidad getPedido() {
        return pedido;
    }
}
