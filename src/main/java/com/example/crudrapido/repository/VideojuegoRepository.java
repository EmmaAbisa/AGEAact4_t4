package com.example.crudrapido.repository;

import com.example.crudrapido.models.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {}