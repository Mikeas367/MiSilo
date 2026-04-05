package com.MiSilo.MiSilo.casosDeUso.Pedidos;

import com.MiSilo.MiSilo.dominio.modelos.DetallePedido;
import com.MiSilo.MiSilo.dominio.modelos.Pedido;

import java.util.List;

public interface INuevoPedidoInteractor {
    Pedido nuevoPedido(List<DetallePedido> detallesPedido);
}
