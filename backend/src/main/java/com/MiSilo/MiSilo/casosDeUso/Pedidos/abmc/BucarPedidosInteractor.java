package com.MiSilo.MiSilo.casosDeUso.Pedidos.abmc;

import com.MiSilo.MiSilo.dominio.modelos.Pedido;
import com.MiSilo.MiSilo.dominio.repositorios.PedidoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BucarPedidosInteractor implements IBuscarPedidosInteractor{
    @Autowired
    private final PedidoRepositoryPort pedidoRepositoryPort;

    public BucarPedidosInteractor(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }


    @Override
    public List<Pedido> buscarPedidos() {
        return pedidoRepositoryPort.buscarTodosPedidos();
    }
}
