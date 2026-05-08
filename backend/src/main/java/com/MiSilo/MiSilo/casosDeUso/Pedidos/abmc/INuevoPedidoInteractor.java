package com.MiSilo.MiSilo.casosDeUso.Pedidos.abmc;

import com.MiSilo.MiSilo.dominio.modelos.DetallePedido;
import com.MiSilo.MiSilo.dominio.modelos.Pedido;

import java.util.List;

public interface INuevoPedidoInteractor {
    Pedido nuevoPedido(List<DetallePedido> detallesPedido);
}
