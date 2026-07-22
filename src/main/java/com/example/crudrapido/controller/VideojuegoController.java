package com.example.crudrapido.controller;

import com.example.crudrapido.dto.VideojuegoDTO;
import com.example.crudrapido.models.Videojuego;
import com.example.crudrapido.service.VideojuegoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public ResponseEntity<Page<Videojuego>> listar(Pageable pageable) {
        return ResponseEntity.ok(videojuegoService.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Videojuego v = videojuegoService.buscarPorId(id);
        if (v == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
        return ResponseEntity.ok(v);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody VideojuegoDTO dto) {
        Videojuego creado = videojuegoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @Valid @RequestBody VideojuegoDTO dto) {
        Videojuego actualizado = videojuegoService.actualizar(id, dto);
        if (actualizado == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        boolean eliminado = videojuegoService.eliminar(id);
        if (!eliminado) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
        return ResponseEntity.noContent().build();
    }
}
