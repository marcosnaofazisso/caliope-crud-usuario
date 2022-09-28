package br.com.caliope;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuario/{id}")
	public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
		return usuarioRepository.findById(id);
	}

	@PostMapping("/usuario")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Object> updateUsuario(@RequestBody Usuario novoUsuario, @PathVariable Long id) {
		Optional<Usuario> findById = usuarioRepository.findById(id);
		if(findById.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Usuario usuarioExistente = findById.get();
		BeanUtils.copyProperties(novoUsuario, usuarioExistente);
		usuarioExistente.setId(id);
		this.insert(usuarioExistente);
		return ResponseEntity.ok(usuarioExistente);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
	
	
	public Usuario insert(Usuario usuario) {
		Usuario saveUsuario = usuarioRepository.save(usuario);
		return saveUsuario;
	}

}
