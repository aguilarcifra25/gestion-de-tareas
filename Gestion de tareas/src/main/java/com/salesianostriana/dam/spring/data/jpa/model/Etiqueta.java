package com.salesianostriana.dam.spring.data.jpa.model;

import jakarta.persistence.*;
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
