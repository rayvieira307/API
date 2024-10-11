package br.org.serratec.trabalhoindividual.trabalho.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Publicacao {

	@Column
	@NotNull
	@NotBlank(message = "Autor não pode estar vazio :)")
	private String autor;
	
	@NotNull
	private LocalDate dataPublicacao;
	
	@NotNull
	@NotBlank(message = "O campo editora não pode estar vazio :)")
	private String editora;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}
