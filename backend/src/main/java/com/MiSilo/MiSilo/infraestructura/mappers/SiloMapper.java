package com.MiSilo.MiSilo.infraestructura.mappers;

import com.MiSilo.MiSilo.dominio.modelos.Silo;
import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.SiloEntidad;

import java.time.LocalDateTime;

public class SiloMapper {

    public static Silo SiloEntidadToSilo(SiloEntidad siloEnDb) {
        long id = siloEnDb.getId();
        double kilosMax = siloEnDb.getKilosMax();
        double kilosContenido = siloEnDb.getContenidoEnSilo();
        LocalDateTime ultimaFechaLLenado = siloEnDb.getfechaUltimoLLenado();
        return new Silo(id, kilosMax, kilosContenido, ultimaFechaLLenado);
    }

    public static SiloEntidad fromDominioToEntidad(Silo silo) {
        return new SiloEntidad(silo.getKilosMax(), silo.getContenidoEnSilo(), silo.getFechaUltimoLLenado());
    }
}
