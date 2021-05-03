package br.com.zup.mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.mercadolivre.compartilhado.UniqueValue;

public class UsuarioRequest {

	@NotBlank @Email @UniqueValue(domainClass=Usuario.class, fieldName="usuario")
	private String usuario;
	@NotBlank @Size(min=6)
	private String senha;

	public Usuario converter() {
		if (usuario == null || usuario.trim().equals("")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario não pode ser vazio");
		}
		if (senha == null || senha.trim().equals("")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Senha não pode ser vazia");
		}
		Usuario usuarioModel = new Usuario(usuario,senha);
		usuarioModel.cryptSenha();
		return usuarioModel;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}
}
