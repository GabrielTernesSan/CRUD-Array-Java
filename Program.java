
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws ParseException {
		int opcao;
		// Loop while
		int cont = 0;

		// Leitor
		Scanner sc = new Scanner(System.in);

		/* Declarações */
		String nome;
		String telefone;
		String nascimento;
		String op;
		double notaFinal;
		String cadastro;
		String ultimaAlteracao;

		// Array de usuários
		List<Pessoa> cadastrados = new ArrayList<>();

		while (cont == 0) {
			System.out.println("===============MENU===============");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Exibir Cadastrados");
			System.out.println("3 - Atualizar Cadastro");
			System.out.println("4 - Deletar usuário");
			System.out.println("5 - Encerrar Programa");
			opcao = sc.nextInt();

			// 1 - Cadastrar
			// ------------------------------------------------------------------------------------------------------
			if (opcao == 1) {
				// Consome o ENTER
				sc.nextLine();

				// Cadastro
				System.out.print("Nome: ");
				nome = sc.nextLine();
				System.out.print("Telefone: ");
				telefone = sc.next();
				System.out.println("Data de Nascimento: ");
				nascimento = sc.next();

				// Data
				System.out.println("Data de Cadastro: ");
				cadastro = sc.next();
				ultimaAlteracao = cadastro;

				// Consome o ENTER
				sc.nextLine();

				// Aluno / Pessoa
				do {
					System.out.print("Você deseja cadastrar uma PESSOA(P) ou um ALUNO(A)? ");
					op = sc.next();

					if (op.toUpperCase().equals("P")) {
						Pessoa pes = new Pessoa(nome, telefone, nascimento, cadastro, ultimaAlteracao);
						cadastrados.add(pes);
						break;
					}

					else if (op.toUpperCase().equals("A")) {
						System.out.println("Nota final: ");
						notaFinal = sc.nextDouble();
						Aluno al = new Aluno(nome, telefone, nascimento, cadastro, ultimaAlteracao, notaFinal);
						cadastrados.add(al);
						break;
					}

					else {
						System.out.println();
						System.out.println("Dados inválidos! Por favor digite novamente!");
						System.out.println();
					}
				} while (op != "P" || op != "A");
			}

			// 2 - Exibir Cadastrados
			// ------------------------------------------------------------------------------------------------------
			else if (opcao == 2) {
				for (Pessoa pessoa : cadastrados) {
					System.out.println(pessoa);
				}
			}

			// 3 - Atualizar Cadastro
			// ------------------------------------------------------------------------------------------------------
			else if (opcao == 3) {
				sc.nextLine();
				int index = 0;
				System.out.print("Nome: ");
				nome = sc.nextLine();

				// pego o índice
				for (Pessoa pessoa : cadastrados) {
					if (pessoa.getNome().equals(nome)) {
						System.out.println("Atualize os dados! ");
						index = cadastrados.indexOf(pessoa);
					}
				}
				
				System.out.print("Nome atualizado: ");
				nome = sc.nextLine();
				System.out.print("Telefone atualizado: ");
				telefone = sc.next();
				System.out.println("Data de Nascimento atualizada: ");
				nascimento = sc.next();
				System.out.print("Data de hoje: ");
				ultimaAlteracao = sc.next();

				cadastrados.get(index).setNome(nome);
				cadastrados.get(index).setNascimento(nascimento);
				cadastrados.get(index).setTelefone(telefone);
				cadastrados.get(index).setUltimaAlteracao(ultimaAlteracao);
			}

			// 4 - Deletar usuário
			// ------------------------------------------------------------------------------------------------------
			else if (opcao == 4) {
				sc.nextLine();
				int index = 500;
				System.out.print("Nome: ");
				nome = sc.nextLine();

				for (Pessoa pessoa : cadastrados) {
					if (pessoa.getNome().equals(nome)) {
						index = cadastrados.indexOf(pessoa);
					}
				}

				cadastrados.remove(index);

			}

			// 5 - Encerrar Programa
			// ------------------------------------------------------------------------------------------------------
			else if (opcao == 5) {
				cont++;
			}
			
			else if (opcao > 5 || opcao < 0) {
				System.out.println("Opção inválida!");
			}
		}
		sc.close();
	}
}