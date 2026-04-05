package com.MiSilo.MiSilo.infraestructura.mappers;

import com.MiSilo.MiSilo.dominio.modelos.DetallePedido;
import com.MiSilo.MiSilo.dominio.modelos.Pedido;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.pedido.DetallePedidoEntidad;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.pedido.PedidoEntidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoMapper {

    public static PedidoEntidad toEntity(Pedido dominio) {
        LocalDateTime fechaPedido = dominio.getFechaPedido();
        double totalKilos = dominio.getTotalKilos();
        List<DetallePedido> detalle = dominio.getDetallePedidos();

        List<DetallePedidoEntidad> detallesEntidad = DetallePedidoMapper.fromListOfDomainToListOfEntidad(detalle);

        return new PedidoEntidad(fechaPedido, totalKilos, detallesEntidad);
    }

    public static Pedido toDomain(PedidoEntidad entidad) {
        LocalDateTime fechaPedido = entidad.getFechaPedido();
        double totalKilos = entidad.getTotalKilos();
        List<DetallePedidoEntidad> detalleEntidad = entidad.getItems();
        long id = entidad.getId();

        List<DetallePedido> detalles = DetallePedidoMapper.fromListOfEntidadToListOfDominio(detalleEntidad);

        Pedido dominio = new Pedido(detalles, fechaPedido);
        dominio.setTotalKilos(totalKilos);
        dominio.setId(id);
        return dominio;
    }

    public static List<Pedido> fromListOfEntidadToDomain(List<PedidoEntidad> pedidosEntidad){
        List<Pedido> pedidosDominio = new ArrayList<>();
        for(PedidoEntidad pedidoEntidad : pedidosEntidad){
            pedidosDominio.add(toDomain(pedidoEntidad));
        }
        return pedidosDominio;
    }
}