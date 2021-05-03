package br.com.zup.mercadolivre.usuario;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioCadastro {
	
	@Autowired
	UsuarioRepository usuarioRepo;

	@PostMapping @Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioRequest usuarioReq) {
		Usuario usuario = usuarioReq.converter();
		usuarioRepo.save(usuario);
		return ResponseEntity.ok().build();
	}
}
