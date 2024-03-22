package com.camping.camping.repository;

import com.camping.camping.dto.Evento;
import java.lang.Integer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Integer> {
}
