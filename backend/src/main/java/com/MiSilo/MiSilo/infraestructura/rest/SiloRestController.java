package com.MiSilo.MiSilo.infraestructura.rest;

import com.MiSilo.MiSilo.casosDeUso.Silo.ILlenarSiloInteractor;
import com.MiSilo.MiSilo.casosDeUso.Silo.IBuscarSiloInteractor;
import com.MiSilo.MiSilo.dominio.modelos.Silo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/silo")
public class SiloRestController {
    @Autowired
    private ILlenarSiloInteractor llenarSiloInteractor;

    @Autowired
    private IBuscarSiloInteractor buscarSiloInteractor;

    @PutMapping("/llenar-silo/{kilos}")
    public void llenarSilo(@PathVariable double kilos){
        llenarSiloInteractor.llenarSilo(1, kilos);
    }

    @GetMapping()
    public Silo obtenerSilo(){
        return buscarSiloInteractor.buscarSilo(1);
    }
}
