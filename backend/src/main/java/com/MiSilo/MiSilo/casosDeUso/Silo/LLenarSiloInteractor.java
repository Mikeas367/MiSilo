package com.MiSilo.MiSilo.casosDeUso.Silo;

import com.MiSilo.MiSilo.dominio.modelos.Silo;
import com.MiSilo.MiSilo.dominio.repositorios.SiloRepositoryPort;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LLenarSiloInteractor implements ILlenarSiloInteractor{
    private final SiloRepositoryPort siloRepositoryPort;
    private LocalDateTime fechaHoraActual;

    public LLenarSiloInteractor(SiloRepositoryPort siloRepositoryPort) {
        this.siloRepositoryPort = siloRepositoryPort;
    }

    private void obtenerFechaHoraActual(){
        LocalDateTime time = LocalDateTime.now();
        this.fechaHoraActual = time;
    }

    @Override
    public void llenarSilo(long id, double cantidadAIngresar) {
        System.out.println("El Id que me llega del RestController " + id);
        if(cantidadAIngresar < 0){
            throw new RuntimeException("Debe ingresar una cantidad positiva");
        }

        Silo silo = siloRepositoryPort.buscarSilo(id);

        silo.llenarSilo(cantidadAIngresar);
        obtenerFechaHoraActual();
        silo.setFechaUltimoLLenado(fechaHoraActual);
        siloRepositoryPort.actualizar(silo);
    }
}
