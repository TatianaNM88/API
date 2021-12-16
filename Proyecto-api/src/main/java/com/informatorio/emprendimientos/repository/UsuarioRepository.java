package com.informatorio.emprendimientos.repository;

import java.time.LocalDateTime;
import java.util.List;
import com.informatorio.emprendimientos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByCiudad(String ciudad);
    @Query("from Usuario where fechaDeCreacion >= ?1")
    List<Usuario> findByFechaDeCreacion(LocalDateTime fechaDeCreacion);
}