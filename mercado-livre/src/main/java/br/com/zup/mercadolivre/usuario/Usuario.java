package br.com.zup.mercadolivre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull @PastOrPresent
	private LocalDateTime CriadoEm = LocalDateTime.now();
	@NotBlank @Email
	private String usuario;
	@NotBlank @Size(min=6)
	private String senha;
	
	/*
	 * usuario é uma string do formato email
	 * senha no formato limpo!
	 */
	public Usuario(@NotBlank @Email String usuario, @NotBlank @Size(min = 6) String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public void cryptSenha() {
		this.senha = BCrypt.hashpw(this.senha, BCrypt.gensalt());
	}
}
