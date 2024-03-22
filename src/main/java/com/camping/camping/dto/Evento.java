package com.camping.camping.dto;

import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "evento")
public class Evento {

  @Id
  private Integer id;

  private String titulo;

  private String descripcion;

  private Double precio;

  private Date desde;

  private Date hasta;

  public Evento() {
  }

  public Evento(Integer id, String titulo, String descripcion, Double precio, Date desde,
      Date hasta) {
    this.id = id;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.precio = precio;
    this.desde = desde;
    this.hasta = hasta;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Double getPrecio() {
    return this.precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public Date getDesde() {
    return this.desde;
  }

  public void setDesde(Date desde) {
    this.desde = desde;
  }

  public Date getHasta() {
    return this.hasta;
  }

  public void setHasta(Date hasta) {
    this.hasta = hasta;
  }

  /**
   * Returns a string representation of the object
   */
  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      " titulo='" + getTitulo() + "'" +
      " descripcion='" + getDescripcion() + "'" +
      " precio='" + getPrecio() + "'" +
      " desde='" + getDesde() + "'" +
      " hasta='" + getHasta() + "'" +
    "}";
  }

  /**
   * Returns a hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, titulo, descripcion, precio, desde, hasta);
  }

  /**
   * Indicates whether some other object is "equal to" this one
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return false;
    } 
    if (!(o instanceof Evento)) {
      return false;
    }
    Evento Evento = (Evento) o;
    return Objects.equals(id, Evento.id) && Objects.equals(titulo, Evento.titulo) && Objects.equals(descripcion, Evento.descripcion) && Objects.equals(precio, Evento.precio) && Objects.equals(desde, Evento.desde) && Objects.equals(hasta, Evento.hasta);
  }
}
