package com.MiSilo.MiSilo.casosDeUso.Pedidos.reportes;

import com.MiSilo.MiSilo.dominio.modelos.Pedido;
import com.MiSilo.MiSilo.dominio.repositorios.PedidoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportePedidoInteractor implements IReportePedidoInteractor {
    @Autowired
    private final PedidoRepositoryPort pedidoRepositoryPort;

    public ReportePedidoInteractor(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public List<Pedido> reportePedidosKilosTotalesPorMes() {
        return List.of();
    }
}
