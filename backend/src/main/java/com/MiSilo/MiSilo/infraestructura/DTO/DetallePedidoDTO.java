package com.MiSilo.MiSilo.infraestructura.DTO;

import com.MiSilo.MiSilo.dominio.modelos.TipoDeBolsa;

public class DetallePedidoDTO {
    private TipoDeBolsa tipoDeBolsa;
    private int cantidad;

    public TipoDeBolsa getTipoDeBolsa() {
        return tipoDeBolsa;
    }

    public int getCantidad() {
        return cantidad;
    }
}