package com.MiSilo.MiSilo.infraestructura.persistencia.mysql.pedidos;

import com.MiSilo.MiSilo.infraestructura.persistencia.entidades.pedido.PedidoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJPARepository extends JpaRepository<PedidoEntidad, Long> {
}
