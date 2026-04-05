package com.MiSilo.MiSilo.casosDeUso.Pedidos;

import com.MiSilo.MiSilo.dominio.modelos.Pedido;

import java.util.List;

public interface IBuscarPedidosInteractor {
    List<Pedido> buscarPedidos();
}
