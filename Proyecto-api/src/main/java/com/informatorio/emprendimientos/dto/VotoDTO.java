package com.informatorio.emprendimientos.dto;

import java.time.LocalDateTime;
import com.informatorio.emprendimientos.entity.Generado;

public class VotoDTO {
    private Generado generado;
    private Long usuarioId;
    private Long emprendimientoId;
    private LocalDateTime fechaDeCreacion;
    private boolean votado;
    
    public Generado getGenerado() {
        return generado;
    }
    public void setGenerado(Generado generado) {
        this.generado = generado;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Long getEmprendimientoId() {
        return emprendimientoId;
    }
    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }
    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public boolean isVotado() {
        return votado;
    }
    public void setVotado(boolean votado) {
        this.votado = votado;
    }
}