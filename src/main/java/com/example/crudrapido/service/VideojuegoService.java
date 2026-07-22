package com.example.crudrapido.service;


import com.example.crudrapido.dto.VideojuegoDTO;
import com.example.crudrapido.models.*;
import com.example.crudrapido.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoService {
    @Autowired private VideojuegoRepository videojuegoRepository;
    @Autowired private DesarrolladorRepository desarrolladorRepository;

    public Page<Videojuego> listar(Pageable pageable) {
        return videojuegoRepository.findAll(pageable);
    }

    public Videojuego buscarPorId(Integer id) {
        return videojuegoRepository.findById(id).orElse(null);
    }

    public Videojuego crear(VideojuegoDTO dto) {
        Desarrollador dev = desarrolladorRepository.findById(dto.getDesarrolladorId()).orElse(null);
        Videojuego v = new Videojuego();
        v.setTitulo(dto.getTitulo());
        v.setGenero(dto.getGenero());
        v.setAnioLanzamiento(dto.getAnioLanzamiento());
        v.setDesarrollador(dev);
        return videojuegoRepository.save(v);
    }

    public Videojuego actualizar(Integer id, VideojuegoDTO dto) {
        Videojuego v = videojuegoRepository.findById(id).orElse(null);
        if (v == null) return null;
        Desarrollador dev = desarrolladorRepository.findById(dto.getDesarrolladorId()).orElse(null);
        v.setTitulo(dto.getTitulo());
        v.setGenero(dto.getGenero());
        v.setAnioLanzamiento(dto.getAnioLanzamiento());
        v.setDesarrollador(dev);
        return videojuegoRepository.save(v);
    }

    public boolean eliminar(Integer id) {
        if (!videojuegoRepository.existsById(id)) return false;
        videojuegoRepository.deleteById(id);
        return true;
    }
}