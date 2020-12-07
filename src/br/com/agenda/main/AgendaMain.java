package br.com.agenda.main;

import java.util.Scanner;

import br.com.agenda.model.Agenda;
import br.com.agenda.model.Contato;
import br.com.agenda.util.EmailValidador;
import br.com.agenda.util.StringToDataNascimento;

public class AgendaMain {

	public static void main(String[] args) {
		// contato que ser� usado pra salvar os contatos
		Contato contato;
		// agenda que ir� tratar das escolhas do usuario
		Agenda agenda = new Agenda();
		// classe usada pra pegar dados do usuario
		Scanner leitor = new Scanner(System.in);
		// guarda a condi��o de parada do sistema
		boolean continua = true;
		try {
			while (continua) {
				System.out.println("1 Cadastrar contato\n2 Consultar\n3 Alterar\n4 Excluir"
						+ "\n5 Exibir aniversariantes do m�s\n6 Exibir contatos\n7 Excluir todos os contatos\n8 Fechar Agenda");

				int opcao = Integer.parseInt(leitor.nextLine());

				switch (opcao) {
				case 1:
					while (true) {
						System.out.println("digite o nome do contato: ");
						String nome = leitor.nextLine();
						System.out.println("digite o telefone: ");
						String telefone = leitor.nextLine();

						System.out.println("digite o contato comercial: ");
						String contatoComercial = leitor.nextLine();

						System.out.println("digite a data de nascimento (dia/mes/ano): ");
						String dataNascimento = leitor.nextLine();

						System.out.println("digite seu e-mail: ");
						String email = leitor.nextLine();
						// se o usuario passar um padrao invalido ir� dar erro
						if (!dataNascimento.contains("/")) {
							System.out.println("digite uma data v�lida");
						}

						if (!EmailValidador.validar(email)) {
							System.out.println("Erro! E-mail inv�lido");
						} else {
							contato = new Contato(nome, telefone, contatoComercial, email,
									StringToDataNascimento.converter(dataNascimento));
							// salva o novo contato
							agenda.cadastrarNovoContato(contato);
							System.out.println("---------------------");
							break;

						}
					}
					break;

				case 2:
					System.out.println("digite o contato que deseja verificar");
					String contatoPraBuscar = leitor.nextLine();
					agenda.consultarContato(contatoPraBuscar);
					System.out.println("---------------------");
					break;
				case 3:
					// pega o contato que ser� atualizado
					System.out.println("digite o contato que ser� atualizado: ");
					String contatoAserAtualizado = leitor.nextLine();

					System.out.println("digite o novo nome: ");
					String novoNome = leitor.nextLine();
					System.out.println("digite o novo contato: ");
					String novoTelefone = leitor.nextLine();

					System.out.println("novo contato comercial: ");
					String novoContatoComercial = leitor.nextLine();

					System.out.println("digite o novo e-mail: ");
					String novoEmail = leitor.nextLine();

					// passa os novos dados
					contato = new Contato();
					contato.setNome(novoNome);
					contato.setContato(novoTelefone);
					contato.setEmail(novoEmail);
					contato.setContatoComercial(novoContatoComercial);

					agenda.alterarContato(contatoAserAtualizado, contato);
					System.out.println("---------------------");
					break;
				case 4:
					while (true) {
						try {
							System.out.println("digite o c�digo do contato: ");
							agenda.excluirContato(Integer.parseInt(leitor.nextLine()));
							System.out.println("contato excluido");
							System.out.println("---------------------");
							break;
						} catch (Exception e) {
							System.out.println("entrada inv�lida! Tenten novamente");
						}
					}
					break;
				case 5:
					System.out.println("digite o m�s dos aniversariantes: ");
					int mes = Integer.parseInt(leitor.nextLine());
					agenda.exibirContatosAniversariante(mes);
					System.out.println("---------------------");
					break;
				case 6:
					agenda.listarContatos();
					break;

				case 7:
					agenda.excluirTodosContatos();
					break;
				case 8:
					System.out.println("Sistema encerrado!");
					continua = false;
					leitor.close();
					break;
				default:
					System.out.println("Op��o inv�lida");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
