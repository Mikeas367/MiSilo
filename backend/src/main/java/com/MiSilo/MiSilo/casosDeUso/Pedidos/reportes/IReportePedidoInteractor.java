package com.MiSilo.MiSilo.casosDeUso.Pedidos.reportes;

import com.MiSilo.MiSilo.dominio.modelos.Pedido;

import java.util.List;

public interface IReportePedidoInteractor {

    List<Pedido> reportePedidosKilosTotalesPorMes();
}
