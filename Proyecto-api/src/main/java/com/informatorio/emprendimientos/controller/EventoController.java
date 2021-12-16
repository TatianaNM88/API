package com.informatorio.emprendimientos.controller;

import javax.validation.Valid;
import com.informatorio.emprendimientos.entity.Evento;
import com.informatorio.emprendimientos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/eventos")
public class EventoController {
    private final EventoService eventoService;
    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<?> crearEvento(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<>(eventoService.guardar(evento), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}/eliminar")
    public Evento eliminarEvento(@PathVariable("id") Long id, Evento evento) {
        return this.eventoService.eliminar(id, evento);
    }
    @PutMapping(value = "/actualizar-estado")
    public void actualizarEvento() { this.eventoService.actualizar(); }
    @GetMapping(value = "/{id}/ranking")
    public ResponseEntity<?> rankingDelEvento(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoService.rankear(id), HttpStatus.OK);
    }
}