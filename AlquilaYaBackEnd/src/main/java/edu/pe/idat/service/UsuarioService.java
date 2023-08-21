package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.idat.model.User;
import edu.pe.idat.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<User> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<User> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public User guardarUsuario(User usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void eliminarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public User actualizarUsuario(Long id, User usuarioActualizado) {
        Optional<User> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
        	User usuario = usuarioExistente.get();
            usuario.setFirstname(usuarioActualizado.getFirstname());
            usuario.setLastname(usuarioActualizado.getLastname());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setEdad(usuarioActualizado.getEdad());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setSexo(usuarioActualizado.getSexo());

            return usuarioRepository.save(usuario);
        } else {
            // Manejar la situación si no se encuentra el usuario
            throw new RuntimeException("No se encontró el usuario con el ID proporcionado");
        }
    }
    
    
    

}
