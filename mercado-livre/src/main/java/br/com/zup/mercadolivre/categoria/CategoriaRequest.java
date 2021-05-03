package br.com.zup.mercadolivre.categoria;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.mercadolivre.compartilhado.UniqueValue;

public class CategoriaRequest {

	@NotBlank @UniqueValue(domainClass=Categoria.class,fieldName="nome")
	private String nome;
	
	private Long idCategoriaMae;

	public Categoria converter(CategoriaRepository categoriaRepo) {
		if(idCategoriaMae!=null) {
			Optional<Categoria> categoriaMae = categoriaRepo.findById(idCategoriaMae);
			if(categoriaMae.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Categoria não encontrada");
			}
			return new Categoria(nome,categoriaMae.get());
		}
		return new Categoria(nome);
	}

	public String getNome() {
		return nome;
	}

	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}
}
