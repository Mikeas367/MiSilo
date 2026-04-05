package com.MiSilo.MiSilo.infraestructura.rest;

import com.MiSilo.MiSilo.casosDeUso.Pedidos.IBuscarPedidosInteractor;
import com.MiSilo.MiSilo.casosDeUso.Pedidos.INuevoPedidoInteractor;
import com.MiSilo.MiSilo.dominio.modelos.DetallePedido;
import com.MiSilo.MiSilo.dominio.modelos.Pedido;
import com.MiSilo.MiSilo.infraestructura.DTO.DetallePedidoDTO;
import com.MiSilo.MiSilo.infraestructura.mappers.DetallePedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedidos")
public class PedidoRestController {

    @Autowired
    private final INuevoPedidoInteractor nuevoPedidoInteractor;
    @Autowired
    private final IBuscarPedidosInteractor buscarPedidosInteractor;

    public PedidoRestController(INuevoPedidoInteractor nuevoPedidoInteractor, IBuscarPedidosInteractor buscarPedidosInteractor) {
        this.nuevoPedidoInteractor = nuevoPedidoInteractor;
        this.buscarPedidosInteractor = buscarPedidosInteractor;
    }

    @PostMapping("/nuevo-pedido")
    public Pedido nuevoPedido(@RequestBody List<DetallePedidoDTO> detallesPedido){
        List<DetallePedido> detalles = DetallePedidoMapper.listOfDetallePedidoDTOToDetallePedido(detallesPedido);
        return  nuevoPedidoInteractor.nuevoPedido(detalles);
    }

    @GetMapping
    public List<Pedido> obtenerPedidos(){
        return buscarPedidosInteractor.buscarPedidos();
    }
}
