package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.enums.Genero;

public class Livro {
	
	
	
	private String titulo;
	private String autor;
	private String editora;
	private LocalDate dataDePublicação;
	private Genero genero;
	
	public Livro(String titulo, String autor, String editora, LocalDate dataDePublicação, Genero genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.dataDePublicação = dataDePublicação;
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public LocalDate getDataDePublicação() {
		return dataDePublicação;
	}

	public void setDataDePublicação(LocalDate dataDePublicação) {
		this.dataDePublicação = dataDePublicação;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Título: " + getTitulo() + " | ");
		str.append("Autor: " + getAutor() + " | ");
		str.append("Editora: " + getEditora() + " | ");
		str.append("Data de publicação: " + dataDePublicação.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " | ");
		str.append("Gênero: " + getGenero());
		return str.toString();
	}

}
