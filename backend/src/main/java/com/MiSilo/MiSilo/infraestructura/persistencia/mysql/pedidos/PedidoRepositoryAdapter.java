package com.MiSilo.MiSilo.infraestructura.persistencia.mysql.pedidos;

import com.MiSilo.MiSilo.dominio.modelos.Pedido;
import com.MiSilo.MiSilo.dominio.repositorios.PedidoRepositoryPort;
import com.MiSilo.MiSilo.infraestructura.mappers.PedidoMapper;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.pedido.PedidoEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {
    @Autowired
    private final PedidoJPARepository pedidoJPARepository;

    public PedidoRepositoryAdapter(PedidoJPARepository pedidoJPARepository) {
        this.pedidoJPARepository = pedidoJPARepository;
    }

    @Override
    public Pedido nuevoPedido(Pedido pedido) {

        PedidoEntidad pedidoEntidad = PedidoMapper.toEntity(pedido);
        pedidoJPARepository.save(pedidoEntidad);
        return pedido;
    }

    @Override
    public List<Pedido> buscarTodosPedidos() {
        List<PedidoEntidad> pedidoEntidades = pedidoJPARepository.findAll();

        return PedidoMapper.fromListOfEntidadToDomain(pedidoEntidades);
    }
}
