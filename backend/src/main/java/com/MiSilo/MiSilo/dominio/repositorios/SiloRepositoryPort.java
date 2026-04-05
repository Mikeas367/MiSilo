package com.MiSilo.MiSilo.dominio.repositorios;

import com.MiSilo.MiSilo.dominio.modelos.Silo;

public interface SiloRepositoryPort {
    void actualizar(Silo silo);
    Silo buscarSilo(long id);
    long contar();
    void guardar(Silo silo);
}
