package com.MiSilo.MiSilo.infraestructura.DTO;

import java.util.ArrayList;
import java.util.List;

public class PrecioPizarra {
    private String fechaPizarra;
    private List<CerealBCR> listaCereal;


    public PrecioPizarra(String fechaPizarra, List<CerealBCR> listaCereal) {
        this.fechaPizarra = fechaPizarra;
        this.listaCereal = listaCereal;
    }

    public String getFechaPizarra() {
        return fechaPizarra;
    }

    public List<CerealBCR> getListaCereal() {
        return listaCereal;
    }
}
