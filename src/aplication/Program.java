package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Biblioteca;
import model.entities.BibliotecaException;
import model.entities.Livro;
import model.enums.Genero;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();

		while (true) {
			try {
				System.out.println("-------------------------------");
				System.out.println("1 - Adicionar livro");
				System.out.println("2 - Remover livro");
				System.out.println("3 - Pesquisar livro");
				System.out.println("4 - Mostrar todos os livros");
				System.out.println("0 - Sair");
				System.out.println("-------------------------------");

				int n = sc.nextInt();
				switch (n) {
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
					LocalDate dataDePublicação = LocalDate.parse(sc.nextLine(),
							DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					System.out.println("Gêneros disponiveis: ");
					for (Genero x : Genero.values()) {
						System.out.println(x);
					}
					System.out.print("Gênero: ");
					Genero genero = Genero.valueOf(sc.next().toUpperCase());
					biblioteca.adicionarLivro(new Livro(titulo, autor, editora, dataDePublicação, genero));
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
					System.out.print("Pesquisar por Título do livro e Autor ou Gênero? ");
					sc.nextLine();
					String pesquisa = sc.nextLine();
					if (pesquisa.equals("GÊNERO".toLowerCase())) {
						System.out.print("Qual o Gênero: ");
						genero = Genero.valueOf(sc.nextLine().toUpperCase());
						System.out.println(biblioteca.pesquisarLivro(genero));
					} else {
						System.out.print("Qual o Título ou Autor: ");
						String tituloOuAutor = sc.nextLine();
						System.out.println(biblioteca.pesquisarLivro(tituloOuAutor));
					}
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
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (BibliotecaException e) {
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Este genero não existe");
			} catch (DateTimeParseException e) {
				System.out.println("Data inválida");
			}
		}
		sc.close();

	}

}
