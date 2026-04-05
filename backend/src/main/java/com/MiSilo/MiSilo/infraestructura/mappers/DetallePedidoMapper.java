package com.MiSilo.MiSilo.infraestructura.mappers;

import com.MiSilo.MiSilo.dominio.modelos.DetallePedido;
import com.MiSilo.MiSilo.dominio.modelos.TipoDeBolsa;
import com.MiSilo.MiSilo.infraestructura.DTO.DetallePedidoDTO;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.pedido.DetallePedidoEntidad;

import java.util.ArrayList;
import java.util.List;

public class DetallePedidoMapper {

    public static DetallePedido fromDetallePedidoDTOToDetallePedido(DetallePedidoDTO detallePedidoDTO){
        TipoDeBolsa tipoDeBolsa = detallePedidoDTO.getTipoDeBolsa();
        int cantidad = detallePedidoDTO.getCantidad();
        return new DetallePedido(tipoDeBolsa, cantidad);
    }

    public static List<DetallePedido> listOfDetallePedidoDTOToDetallePedido(List<DetallePedidoDTO> detallesPedido) {
        List<DetallePedido> detalles = new ArrayList<>();
        for(DetallePedidoDTO detallePedidoDTO : detallesPedido){
            DetallePedido detalle = fromDetallePedidoDTOToDetallePedido(detallePedidoDTO);
            detalles.add(detalle);
        }
        return detalles;
    }

    public static DetallePedidoEntidad fromDomainToEntidad(DetallePedido detallePedido){
        int cantidad = detallePedido.getCantidad();
        double subTotal = detallePedido.getSubTotalKilos();
        TipoDeBolsa tipoDeBolsa = detallePedido.getTipoDeBolsa();

        return new DetallePedidoEntidad(tipoDeBolsa, cantidad, subTotal);
    }

    public static List<DetallePedidoEntidad> fromListOfDomainToListOfEntidad(List<DetallePedido> detalles){
        List<DetallePedidoEntidad> detallesEntidad = new ArrayList<>();
        for( DetallePedido detallePedido : detalles){
            detallesEntidad.add(fromDomainToEntidad(detallePedido));
        }
        return detallesEntidad;
    }

    public static List<DetallePedido> fromListOfEntidadToListOfDominio(List<DetallePedidoEntidad> detallesEntidad){
        List<DetallePedido> detallesDominio = new ArrayList<>();
        for( DetallePedidoEntidad detallePedido : detallesEntidad){
            detallesDominio.add(fromEntidadToDomain(detallePedido));
        }
        return detallesDominio;
    }

    public static DetallePedido fromEntidadToDomain(DetallePedidoEntidad detallePedidoEntidad){
        int cantidad = detallePedidoEntidad.getCantidad();
        double subTotal = detallePedidoEntidad.getSubTotal();
        TipoDeBolsa tipoDeBolsa = detallePedidoEntidad.getTipoDeBolsa();
        DetallePedido dp = new DetallePedido(tipoDeBolsa, cantidad);
        dp.setSubTotalKilos(subTotal);

        return dp;
    }



}
