package edu.pe.idat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pe.idat.model.User;

public interface UsuarioRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);;
}
