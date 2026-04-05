package com.MiSilo.MiSilo.infraestructura.configurations;

import com.MiSilo.MiSilo.dominio.modelos.Silo;
import com.MiSilo.MiSilo.dominio.repositorios.SiloRepositoryPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(SiloRepositoryPort siloRepositoryPort) {
        return args -> {
            // Verificamos si la tabla está vacía para no duplicar el registro inicial
            if (siloRepositoryPort.contar() == 0) {
                Silo siloInicial = new Silo(1, 60000, 0, LocalDateTime.now());

                siloRepositoryPort.guardar(siloInicial);
                System.out.println("Base de datos nueva detectada: Registro de silo inicial creado.");
            }
        };
    }
}