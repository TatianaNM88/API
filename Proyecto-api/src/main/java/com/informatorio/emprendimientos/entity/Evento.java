package com.informatorio.emprendimientos.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "activo = true")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String detalles;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDeCreacion;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDecierre;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaFinal;
    @Column(name = "estado", nullable = false, columnDefinition = "varchar(32) default 'ABIERTO'")
    @Enumerated(value = EnumType.STRING)
    private Estado estado = Estado.ABIERTO;
    @ManyToMany(mappedBy = "eventos")
    @JsonIgnoreProperties({"descripcion","contenido","fechaDeCreacion","objetivo","publicado","tags"})
    @OrderBy("contadorDeVotos DESC")
    private List<Emprendimiento> emprendimientos;
    private Double premio;
    private Boolean activo = true;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public LocalDate getFechaDecierre() {
        return fechaDecierre;
    }
    public void setFechaDecierre(LocalDate fechaDecierre) {
        this.fechaDecierre = fechaDecierre;
    }
    public LocalDate getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientos;
    }
    public void setEmprendimientos(List<Emprendimiento> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }
    public Double getPremio() {
        return premio;
    }
    public void setPremio(Double premio) {
        this.premio = premio;
    }
    public Boolean isActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    @Override
    public String toString() {
        return "Evento [activo=" + activo + ", detalles=" + detalles + ", emprendimientos=" + emprendimientos
                + ", estado=" + estado + ", fechaDeCreacion=" + fechaDeCreacion + ", fechaDecierre=" + fechaDecierre
                + ", fechaFinal=" + fechaFinal + ", id=" + id + ", nombre=" + nombre + ", premio=" + premio + "]";
    }
}