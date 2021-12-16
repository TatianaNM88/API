package com.informatorio.emprendimientos.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Generado generado;
    private Long emprendimientoId;
    private Long usuarioId;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Generado getGenerado() {
        return generado;
    }
    public void setGenerado(Generado generado) {
        this.generado = generado;
    }
    public Long getEmprendimientoId() {
        return emprendimientoId;
    }
    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    @Override
    public String toString() {
        return "Voto [emprendimientoId=" + emprendimientoId + ", fechaDeCreacion=" + fechaDeCreacion + ", generado="
                + generado + ", id=" + id + ", usuarioId=" + usuarioId + "]";
    }
}