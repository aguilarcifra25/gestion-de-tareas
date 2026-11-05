package com.salesianostriana.dam.spring.data.jpa.service;

import com.salesianostriana.dam.spring.data.jpa.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public long contar() {
        return comentarioRepository.count();
    }
}
