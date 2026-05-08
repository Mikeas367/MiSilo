package com.MiSilo.MiSilo.infraestructura.rest;

import com.MiSilo.MiSilo.casosDeUso.PecioPizarra.IPrecioPizarraInteractor;
import com.MiSilo.MiSilo.infraestructura.DTO.CerealBCR;
import com.MiSilo.MiSilo.infraestructura.DTO.PrecioPizarra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/precio-pizarra")
public class PrecioPizarraRestController {

    @Autowired
    private final IPrecioPizarraInteractor precioPizarraInteractor;


    public PrecioPizarraRestController(IPrecioPizarraInteractor precioPizarraInteractor) {
        this.precioPizarraInteractor = precioPizarraInteractor;
    }

    @GetMapping
    private PrecioPizarra obtenerPreciosPizarra() {
        return precioPizarraInteractor.obtenerPreciosPizarra();
    }


}
