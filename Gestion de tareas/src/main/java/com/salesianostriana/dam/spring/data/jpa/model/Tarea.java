package com.salesianostriana.dam.spring.data.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
<<<<<<<< HEAD:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Tarea.java
public class Tarea {

    @Id @GeneratedValue
    private Long id;

    private String titulo;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;
========
public class Etiqueta {
    @Id @GeneratedValue
    private Long id;

    private String nombre;
>>>>>>>> feature/comentarios-etiquetas:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Etiqueta.java

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tarea_etiqueta",
            joinColumns = @JoinColumn(name = "tarea_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    @Builder.Default
    @ToString.Exclude
    private Set<Etiqueta> etiquetas = new HashSet<>();


    /*
    Métodos helper - Comentario
     */

    public Tarea addComentario(Comentario c) {
        comentarios.add(c);
        c.setTarea(this);
        return this;
    }

    public Tarea removeComentario(Comentario c) {
        comentarios.remove(c);
        c.setTarea(null);
        return this;
    }

    // --- Métodos Helper / Auxiliares etiqueta---
    public void addEtiqueta(Etiqueta etiqueta) {
        this.etiquetas.add(etiqueta);
        etiqueta.getTareas().add(this);
    }

    public void removeEtiqueta(Etiqueta etiqueta) {
        this.etiquetas.remove(etiqueta);
        etiqueta.getTareas().remove(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
<<<<<<<< HEAD:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Tarea.java
        Tarea tarea = (Tarea) o;
        return getId() != null && Objects.equals(getId(), tarea.getId());
========
        Etiqueta etiqueta = (Etiqueta) o;
        return getId() != null && Objects.equals(getId(), etiqueta.getId());
>>>>>>>> feature/comentarios-etiquetas:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Etiqueta.java
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
<<<<<<<< HEAD:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Tarea.java

}
========
}
>>>>>>>> feature/comentarios-etiquetas:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Etiqueta.java
