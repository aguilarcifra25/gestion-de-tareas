package com.salesianostriana.dam.spring.data.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
<<<<<<<< HEAD:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Proyecto.java
public class Proyecto {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "proyecto")
    @Builder.Default
    @ToString.Exclude
    private List<Tarea> tareas = new ArrayList<>();

    /*
    Métodos helper - Tarea
     */

    public Proyecto addTarea(Tarea t) {
        tareas.add(t);
        t.setProyecto(this);
        return this;
    }

    public Proyecto removeTarea(Tarea t) {
        tareas.remove(t);
        t.setProyecto(null);
        return this;
    }

========
public class Comentario {
    @Id @GeneratedValue
    private Long id;

    private String texto;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    @ToString.Exclude
    private Tarea tarea;
>>>>>>>> feature/comentarios-etiquetas:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Comentario.java


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
<<<<<<<< HEAD:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Proyecto.java
        Proyecto proyecto = (Proyecto) o;
        return getId() != null && Objects.equals(getId(), proyecto.getId());
========
        Comentario comentario = (Comentario) o;
        return getId() != null && Objects.equals(getId(), comentario.getId());
>>>>>>>> feature/comentarios-etiquetas:Gestion de tareas/src/main/java/com/salesianostriana/dam/spring/data/jpa/model/Comentario.java
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
