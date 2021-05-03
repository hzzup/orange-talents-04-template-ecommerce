package br.com.zup.mercadolivre.categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaCadastro {
	
	@Autowired
	CategoriaRepository categoriaRepo;

	@PostMapping @Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest categoriaReq) {
		Categoria novaCategoria = categoriaReq.converter(categoriaRepo);
		categoriaRepo.save(novaCategoria);
		return ResponseEntity.ok().build();
	}
	
}
