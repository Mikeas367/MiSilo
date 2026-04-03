package com.MiSilo.MiSilo.infraestructura.persistencia.mysql.silo;

import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.SiloEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiloJPARepository extends JpaRepository<SiloEntidad, Long> {
}
