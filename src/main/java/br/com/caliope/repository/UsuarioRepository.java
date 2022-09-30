package br.com.caliope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caliope.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
