package com.example.crudrapido.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VideojuegoDTO {
    private Integer id;
    @NotBlank(message = "El título es obligatorio")
    private String titulo;
    @NotBlank(message = "El género es obligatorio")
    private String genero;
    @NotNull(message = "El año de lanzamiento es obligatorio")
    private Integer anioLanzamiento;
    @NotNull(message = "El id del desarrollador es obligatorio")
    private Integer desarrolladorId;
    private String desarrolladorNombre;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(Integer anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }
    public Integer getDesarrolladorId() { return desarrolladorId; }
    public void setDesarrolladorId(Integer desarrolladorId) { this.desarrolladorId = desarrolladorId; }
    public String getDesarrolladorNombre() { return desarrolladorNombre; }
    public void setDesarrolladorNombre(String desarrolladorNombre) { this.desarrolladorNombre = desarrolladorNombre; }
}