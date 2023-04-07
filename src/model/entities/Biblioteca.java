package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
			if (!livro.getTitulo().equals(autorOuTitulo) || !livro.getAutor().equals(autorOuTitulo)) {
				throw new BibliotecaException("Este livro não existe");				
			}
		}
	}

	public Livro pesquisarLivro(String criterioDePesquisa) {
		List<Livro> livrosFiltrados = list.stream()
				.filter(livro -> livro.getTitulo().equals(criterioDePesquisa) || livro.getAutor().equals(criterioDePesquisa))
				.collect(Collectors.toList());
		for(Livro x : livrosFiltrados) {
			return x;
		}		
		throw new BibliotecaException("Não existe nenhum livro");		
	}	
	
	public Livro pesquisarLivro(Genero genero) {
		List<Livro> livrosFiltrados = list.stream()
				.filter(livro -> livro.getGenero().equals(genero))
				.collect(Collectors.toList());
		for(Livro x : livrosFiltrados) {
			if(!x.getGenero().equals(genero)) {
				throw new IllegalArgumentException("Este gênero não existe");
			}
			return x;
		}					
		throw new BibliotecaException("Não existe nenhum livro");
	}		

	
	public void mostrarTodosOsLivros() {
		for (Livro x : list) {
			System.out.println(x);
		}
	}

}
