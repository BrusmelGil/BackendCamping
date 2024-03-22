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
   * Mapping of the GET operation endpoint
   * HTTP Status code: 200 OK
   * @return ArrayList of the database records, in JSON format
   */
  @GetMapping(
      produces = "application/json"
  )
  public ResponseEntity<ArrayList<Evento>> get() {
    return ResponseEntity.status(HttpStatus.OK).body(EventoService.get());
  }

  /**
   * Mapping of the POST operation endpoint
   * HTTP Status code: 201 CREATED or 409 CONFLICT
   * @param Evento request body of the object to insert, in JSON format
   * @return the object inserted in the database, in JSON format
   */
  @PostMapping(
      consumes = "application/json"
  )
  public ResponseEntity<Evento> post(@RequestBody Evento Evento) {
    if(EventoService.getByKey(Evento.getId()).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    } else {
      if(this.EventoService.post(Evento) != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Evento);
      }
      else {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
      }
    }
  }

  /**
   * Mapping of the PUT operation endpoint
   * HTTP Status code: 200 CREATED or 404 CONFLICT
   * @param Evento request body of the object to update, in JSON format
   * @param id path variable of the Primary Key of the object to be updated
   * @return the object updated in the database, in JSON format
   */
  @PutMapping(
      value = "{id}",
      consumes = "application/json"
  )
  public ResponseEntity<Evento> put(@RequestBody Evento Evento, @PathVariable("id") Integer id) {
    if(!EventoService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.EventoService.put(Evento, id);
      return ResponseEntity.status(HttpStatus.OK).body(Evento);
    }
  }

  /**
   * Mapping of the DELETE operation endpoint
   * HTTP Status code: 204 NO CONTENT or 404 NOT FOUND
   * @param id path variable of the Primary Key of the object to be deleted
   * @return empty response body
   */
  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
    if(!EventoService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.EventoService.delete(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
  }

  /**
   * Mapping of the GET BY KEY operation endpoint
   * HTTP Status code: 200 OK or 404 NOT FOUND
   * @param Evento request body of the object to insert, in JSON format
   * @param id path variable of the Primary Key of the object to be retrieved
   * @return the object retrieved by its Primary Key from the database, in JSON format
   */
  @GetMapping(
      value = "{id}",
      produces = "application/json"
  )
  public ResponseEntity<Evento> getByKey(@PathVariable("id") Integer id) {
    if(!EventoService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.EventoService.getByKey(id);
      return ResponseEntity.status(HttpStatus.OK).body(this.EventoService.getByKey(id).get());
    }
  }
}
