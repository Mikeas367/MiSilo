package com.MiSilo.MiSilo.dominio.repositorios;

import com.MiSilo.MiSilo.dominio.modelos.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {
    Pedido nuevoPedido(Pedido pedido);
    List<Pedido> buscarTodosPedidos();
}
