package com.MiSilo.MiSilo.casosDeUso.Pedidos;

import com.MiSilo.MiSilo.dominio.modelos.DetallePedido;
import com.MiSilo.MiSilo.dominio.modelos.Pedido;
import com.MiSilo.MiSilo.dominio.modelos.Silo;
import com.MiSilo.MiSilo.dominio.repositorios.PedidoRepositoryPort;
import com.MiSilo.MiSilo.dominio.repositorios.SiloRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NuevoPedidoInteractor implements INuevoPedidoInteractor{
    @Autowired
    private final PedidoRepositoryPort pedidoRepositoryPort;
    @Autowired
    private final SiloRepositoryPort siloRepositoryPort;
    private LocalDateTime fechaHoraActual;
    private Silo silo;

    private void buscarSilo(){
        silo = siloRepositoryPort.buscarSilo(1);
    }

    private void obtenerFechaHoraActual(){
        LocalDateTime time = LocalDateTime.now();
        this.fechaHoraActual = time;
    }
    @Override
    public Pedido nuevoPedido(List<DetallePedido> detallesPedido) {
        buscarSilo();

        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setDetallePedidos(detallesPedido);
        nuevoPedido.calcularTotalKilos();

        obtenerFechaHoraActual();
        nuevoPedido.setFechaPedido(fechaHoraActual);

        silo.sacarContenido(nuevoPedido.getTotalKilos());

        pedidoRepositoryPort.nuevoPedido(nuevoPedido);
        siloRepositoryPort.actualizar(silo);
        return nuevoPedido;
    }

    public NuevoPedidoInteractor(PedidoRepositoryPort pedidoRepositoryPort, SiloRepositoryPort siloRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.siloRepositoryPort = siloRepositoryPort;
    }

}
