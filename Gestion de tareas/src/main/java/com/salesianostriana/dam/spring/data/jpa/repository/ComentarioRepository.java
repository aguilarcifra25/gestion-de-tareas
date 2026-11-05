package com.salesianostriana.dam.spring.data.jpa.repository;

import com.salesianostriana.dam.spring.data.jpa.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository  extends JpaRepository<Comentario, Long> {
}
