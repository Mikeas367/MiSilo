package com.MiSilo.MiSilo.casosDeUso.Silo;

import com.MiSilo.MiSilo.dominio.modelos.Silo;
import com.MiSilo.MiSilo.dominio.repositorios.SiloRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarSiloInteractor implements IBuscarSiloInteractor{
    @Autowired
    private final SiloRepositoryPort siloRepositoryPort;

    public BuscarSiloInteractor(SiloRepositoryPort siloRepositoryPort) {
        this.siloRepositoryPort = siloRepositoryPort;
    }

    @Override
    public Silo buscarSilo(long id) {
        return siloRepositoryPort.buscarSilo(id);
    }
}
