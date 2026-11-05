package com.salesianostriana.dam.spring.data.jpa.service;

import com.salesianostriana.dam.spring.data.jpa.model.Proyecto;
import com.salesianostriana.dam.spring.data.jpa.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> listarTodos() {
        return proyectoRepository.findAll();
    }
}