package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Biblioteca;
import model.entities.Livro;
import model.enums.Genero;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		
		while(true) {
			System.out.println("-------------------------------");
			System.out.println("1 - Adicionar livro");
			System.out.println("2 - Remover livro");
			System.out.println("3 - Pesquisar livro");
			System.out.println("4 - Mostrar todos os livros");
			System.out.println("0 - Sair");
			System.out.println("-------------------------------");
			
			int n = sc.nextInt();
			switch(n) {
				case 1: 
					System.out.println("-------------------------------");
					System.out.print("Título do livro: ");
					sc.nextLine();
					String titulo = sc.nextLine();
					System.out.print("Autor: ");
					String autor = sc.nextLine();
					System.out.print("Editora: ");
					String editora = sc.nextLine();
					System.out.print("Data de publicação (DIA/MÊS/ANO): ");
					LocalDate dataDePublicação = LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					System.out.println("Gêneros disponiveis: ");
					for(Genero x : Genero.values()) {		
						System.out.println(x);					
					}
					System.out.print("Gênero: ");
					Genero genero = Genero.valueOf(sc.next().toUpperCase());
					biblioteca.adicionarLivro(new Livro(titulo,autor,editora,dataDePublicação,genero));
					break;
				case 2: 
					System.out.println("-------------------------------");
					System.out.print("Título do livro ou Autor: ");
					sc.nextLine();
					String remove = sc.nextLine();
					biblioteca.removerLivro(remove);
					break;
				case 3: 
					System.out.println("-------------------------------");
					System.out.print("Título do livro, Autor ou Gênero: ");
					sc.nextLine();
					String pesquisa = sc.nextLine();
					biblioteca.pesquisarLivro(pesquisa);
					break;
				case 4: 
					System.out.println("-------------------------------");
					System.out.println("Todos os livros cadastrados: ");
					biblioteca.mostrarTodosOsLivros();
					break;	
				default: 
					System.out.println("Opção invalida");
			}
			if (n == 0) {
				System.out.println("-------------------------------");
				System.out.println("Saindo... ");
				break;
			}
		}	
		sc.close();
	
	}

}

