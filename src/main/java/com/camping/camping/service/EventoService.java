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
   * @return
   */
  public ArrayList<Evento> get() {
    return (ArrayList<Evento>)this.EventoRepository.findAll();
  }

  /**
   * @param evento 
   * @return 
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
   * @param evento 
   * @param id 
   * @return 
   */
  public Evento put(Evento evento, Integer id) {
    return EventoRepository.save(evento);
  }

  /**
   * @param id
   */
  public void delete(Integer id) {
    EventoRepository.deleteById(id);
  }

  /**
   * @param id 
   * @return 
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
