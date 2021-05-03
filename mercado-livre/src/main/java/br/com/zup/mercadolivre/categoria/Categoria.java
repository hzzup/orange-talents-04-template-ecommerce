package br.com.zup.mercadolivre.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Column(unique=true)
	private String nome;
	
	@ManyToOne 
	private Categoria categoriaMae;

	public Categoria(@NotBlank String nome, Categoria categoriaMae) {
		this.nome = nome;
		this.categoriaMae = categoriaMae;
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}
	
	@Deprecated
	public Categoria() {}
}
