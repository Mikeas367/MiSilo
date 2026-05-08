package com.MiSilo.MiSilo.casosDeUso.Pedidos.abmc;

import com.MiSilo.MiSilo.dominio.modelos.Pedido;

import java.util.List;

public interface IBuscarPedidosInteractor {
    List<Pedido> buscarPedidos();
}
