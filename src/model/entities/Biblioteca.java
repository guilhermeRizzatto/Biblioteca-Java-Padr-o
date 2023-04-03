package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enums.Genero;

public class Biblioteca {

	private List<Livro> list = new ArrayList<>();

	public Biblioteca() {
	}

	public List<Livro> getList() {
		return list;
	}

	public void adicionarLivro(Livro livro) {
		list.add(livro);
	}

	public void removerLivro(String autorOuTitulo) {
		for (int i = 0; i < list.size(); i++) {
			Livro livro = list.get(i);
			if (livro.getTitulo().equals(autorOuTitulo) || livro.getAutor().equals(autorOuTitulo)) {
				list.remove(i);
				break;
			}
		}
	}

	public void pesquisarLivro(String criterioDePesquisa) {
		for (int i = 0; i < list.size(); i++) {
			Livro livro = list.get(i);
			if (livro.getTitulo().equals(criterioDePesquisa) 
				|| livro.getAutor().equals(criterioDePesquisa) 
				|| livro.getGenero().equals(Genero.valueOf(criterioDePesquisa.toUpperCase()))) {
				System.out.println(livro);
			}					
		}
	}


	public void mostrarTodosOsLivros() {
		for (Livro x : list) {
			System.out.println(x);
		}
	}

}
