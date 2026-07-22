package com.example.crudrapido.service;

import com.example.crudrapido.models.Usuario;
import com.example.crudrapido.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrar(String username, String rawPassword) {
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(rawPassword));
        return usuarioRepository.save(u);
    }

    public boolean validarCredenciales(String username, String rawPassword) {
        return usuarioRepository.findByUsername(username)
                .map(u -> passwordEncoder.matches(rawPassword, u.getPassword()))
                .orElse(false);
    }
}