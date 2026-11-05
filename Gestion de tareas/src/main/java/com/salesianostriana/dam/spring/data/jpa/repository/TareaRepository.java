package com.salesianostriana.dam.spring.data.jpa.repository;

import com.salesianostriana.dam.spring.data.jpa.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
