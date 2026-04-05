package com.MiSilo.MiSilo.infraestructura.persistencia.mysql.silo;

import com.MiSilo.MiSilo.dominio.modelos.Silo;
import com.MiSilo.MiSilo.dominio.repositorios.SiloRepositoryPort;
import com.MiSilo.MiSilo.infraestructura.mappers.SiloMapper;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.SiloEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SiloRepositoryAdapter implements SiloRepositoryPort {
    @Autowired
    private SiloJPARepository siloJPARepository;

    @Override
    public Silo buscarSilo(long id) {
        SiloEntidad siloEnDb = siloJPARepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el silo con ID: " + id));
        System.out.println("ESTE ES EL SILO QUE TRAIGO DE LA DB: " + siloEnDb.getId());
        Silo silo = SiloMapper.SiloEntidadToSilo(siloEnDb);
        return silo;
    }

    @Override
    public void actualizar(Silo silo) {
        long id = silo.getId();
        double contenidoEnSilo = silo.getContenidoEnSilo();
        LocalDateTime fechaUltimoLLenado = silo.getFechaUltimoLLenado();

        SiloEntidad entidad = siloJPARepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el silo con ID: " + id));

        entidad.setContenidoEnSilo(contenidoEnSilo);
        entidad.setFechaUltimoLLenado(fechaUltimoLLenado);

        siloJPARepository.save(entidad);
    }

    public long contar() {
        return siloJPARepository.count();
    }

    @Override
    public void guardar(Silo silo) {
        siloJPARepository.save(SiloMapper.fromDominioToEntidad(silo));
    }


}
