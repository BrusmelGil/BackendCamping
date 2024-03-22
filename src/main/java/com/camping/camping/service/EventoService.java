package com.camping.camping.service;

import com.camping.camping.dto.Evento;
import com.camping.camping.repository.EventoRepository;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
  @Autowired
  private EventoRepository EventoRepository;

  /**
   * Applies the logic of the GET request, invoking the repository
   * in order to retrieve the list of records stored in the database
   * @return the whole list of objects present in the database
   */
  public ArrayList<Evento> get() {
    return (ArrayList<Evento>)this.EventoRepository.findAll();
  }

  /**
   * Applies the logic of the POST request, invoking the repository
   * in order to insert in the database the object passed through parameter
   * @param evento object that is being created
   * @return the saved object, returned by the save() method in the repository
   */
  public Evento post(Evento evento) {
    if(!isConflict(evento.getDesde(), evento.getHasta())) {
      return EventoRepository.save(evento);
    }
    else {
      return null;
    }
  }

  /**
   * Applies the logic of the PUT request, invoking the repository
   * in order to update in the database the object passed through parameter
   * @param evento object that is being updated
   * @param id Primary Key of the object to update
   * @return the saved object, returned by the save() method in the repository
   */
  public Evento put(Evento evento, Integer id) {
    return EventoRepository.save(evento);
  }

  /**
   * Applies the logic of the DELETE request, invoking the repository
   * in order to delete from the database the specified object
   * @param id Primary Key of the object to delete
   */
  public void delete(Integer id) {
    EventoRepository.deleteById(id);
  }

  /**
   * Applies the logic of the GET BY KEY request, invoking the repository
   * in order to retrieve from the database the specified object
   * @param id Primary Key of the object to retrieve
   * @return the entity whose Primary Key matches the given key, or Optional#empty() if none found
   */
  public Optional<Evento> getByKey(Integer id) {
    return EventoRepository.findById(id);
  }

  private boolean isConflict(Date fechaDesde, Date fechaHasta) {
    ArrayList<Evento> eventos = this.get();
    for (Evento evento : eventos) {
      if(evento.getDesde().before(fechaHasta) && evento.getHasta().after(fechaDesde)) {
        return true;
      }
    }
    return false;
  }

}
