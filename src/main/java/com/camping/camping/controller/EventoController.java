package com.camping.camping.controller;

import com.camping.camping.dto.Evento;
import com.camping.camping.service.EventoService;
import java.lang.Integer;
import java.lang.Void;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("evento")
public class EventoController {
  @Autowired
  private EventoService EventoService;

  /**
   * @return
   */
  @GetMapping(produces = "application/json")
  public ResponseEntity<ArrayList<Evento>> get() {
    return ResponseEntity.status(HttpStatus.OK).body(EventoService.get());
  }

  /**
   * @param Evento
   * @return 
   */
  @PostMapping(consumes = "application/json")
  public ResponseEntity<Evento> post(@RequestBody Evento Evento) {
    if (EventoService.getByKey(Evento.getId()).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    } else {
      if (this.EventoService.post(Evento) != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Evento);
      } else {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
      }
    }
  }

  /**
   * @param Evento 
   * @param id   
   * @return
   */
  @PutMapping(value = "{id}", consumes = "application/json")
  public ResponseEntity<Evento> put(@RequestBody Evento Evento, @PathVariable("id") Integer id) {
    if (!EventoService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.EventoService.put(Evento, id);
      return ResponseEntity.status(HttpStatus.OK).body(Evento);
    }
  }

  /**
   * @param id 
   * @return 
   */
  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
    if (!EventoService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.EventoService.delete(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
  }

  /**
   * @param Evento 
   * @param id 
   * @return 
   */
  @GetMapping(value = "{id}", produces = "application/json")
  public ResponseEntity<Evento> getByKey(@PathVariable("id") Integer id) {
    if (!EventoService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.EventoService.getByKey(id);
      return ResponseEntity.status(HttpStatus.OK).body(this.EventoService.getByKey(id).get());
    }
  }
}
