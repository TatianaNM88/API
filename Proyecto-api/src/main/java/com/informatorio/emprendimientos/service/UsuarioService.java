package com.informatorio.emprendimientos.service;

import java.time.LocalDateTime;
import java.util.List;
import com.informatorio.emprendimientos.entity.Usuario;
import com.informatorio.emprendimientos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario eliminar(Long id, Usuario usuario) {
        Usuario usuarioEliminado = usuarioRepository.getById(id);
        usuarioEliminado.setActivo(false);
        return usuarioRepository.save(usuarioEliminado);
    }
    public Usuario modificar(Long id, Usuario usuario) {
        Usuario usuarioModificado = usuarioRepository.getById(id);
        if (!usuario.getNombre().trim().isEmpty()) { usuarioModificado.setNombre(usuario.getNombre()); }
        if (!usuario.getApellido().trim().isEmpty()) { usuarioModificado.setApellido(usuario.getApellido()); }
        if (!usuario.getEmail().trim().isEmpty()) { usuarioModificado.setEmail(usuario.getEmail()); }
        if (!usuario.getPassword().trim().isEmpty()) { usuarioModificado.setPassword(usuario.getPassword()); }
        if (!usuario.getCiudad().trim().isEmpty()) { usuarioModificado.setCiudad(usuario.getCiudad()); }
        if (!usuario.getProvincia().trim().isEmpty()) { usuarioModificado.setProvincia(usuario.getProvincia()); }
        if (!usuario.getPais().trim().isEmpty()) { usuarioModificado.setPais(usuario.getPais()); }
        if (usuario.getTipo() != null) { usuarioModificado.setTipo(usuario.getTipo()); }
        usuarioModificado.setUltimaModificacion(LocalDateTime.now());
        return usuarioRepository.save(usuarioModificado);
    }
    public List<Usuario> obtenerTodos(LocalDateTime fechaDeCreacion, String ciudad) {
        if (fechaDeCreacion != null) {return usuarioRepository.findByFechaDeCreacion(fechaDeCreacion);
        } else if (ciudad != null) { return usuarioRepository.findByCiudad(ciudad);
        } else { return usuarioRepository.findAll(); }
    }
}