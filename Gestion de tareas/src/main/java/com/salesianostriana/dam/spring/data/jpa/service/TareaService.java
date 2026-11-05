package com.salesianostriana.dam.spring.data.jpa.service;

import com.salesianostriana.dam.spring.data.jpa.model.Etiqueta;
import com.salesianostriana.dam.spring.data.jpa.model.Tarea;
import com.salesianostriana.dam.spring.data.jpa.repository.TareaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;

    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> listarTodos() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public String mostrarDetalle(Long id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe la tarea con id " + id));

        // Las colecciones son LAZY: se pueden recorrer aquí porque seguimos dentro de la transacción
        String etiquetas = tarea.getEtiquetas().stream()
                .map(Etiqueta::getNombre)
                .collect(Collectors.joining(", "));

        return "Título: " + tarea.getTitulo()
                + " | Comentarios: " + tarea.getComentarios().size()
                + " | Etiquetas: " + (etiquetas.isEmpty() ? "ninguna" : etiquetas);
    }
}