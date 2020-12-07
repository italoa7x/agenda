package br.com.agenda.model;

import java.util.HashMap;
import java.util.Map;

import br.com.agenda.util.ValidadorDeContato;

public class Agenda {
	private Map<Integer, Contato> contados = new HashMap<Integer, Contato>();

	public void cadastrarNovoContato(Contato contato) {

		if (contatoExistente(contato)) {
			System.out.println("o número informado já foi cadastrado. Tente outro");
			return;
		} else {
			// valida se possui dados no contato
			if (ValidadorDeContato.validarContato(contato)) {
				// adiciona um novo contato
				this.contados.put(this.contados.size() + 1, contato);
				System.out.println("contato salvo com sucesso!");
			}

		}
	}

	public void consultarContato(String contatoPraBuscar) {

		// se o contato passado para buscar for nulo, retorna um NULL
		if (contatoPraBuscar.isBlank()) {
			System.out.println("contato inválido!");
			return;
		}
		// procura na lista de contatos o contato que se deseja verificar os dados
		this.contados.forEach((chave, contato) -> {
			if (contato.getContato().equals(contatoPraBuscar)) {
				System.out.println("contato encontrado\n" + contato.toString());
			}

		});

	}

	public void listarContatos() {
		if(this.contados.isEmpty()) {
			System.out.println("não há contatos para exibir. Agenda vazia.");
		}
		// itera sobre a lista de contatos e os exibe
		System.out.println("---------------------------------");
		this.contados.forEach((k, v) -> {
			System.out.println("código: " + k + "\n" + v.toString());
			System.out.println("---------------------------------");
		});
	}

	public void alterarContato(String contatoAntigo, Contato novoContato) {
		if (contatoAntigo.isBlank()) {
			System.out.println("contato invalido. Tente novamente");
			return;
		}
		// é buscado na lista de contatos, o contato que se deseja atualizar
		this.contados.forEach((chave, contato) -> {
			// acha o contato desejado
			if (contato.getContato().equals(contatoAntigo)) {
				// atualiza os dados
				novoContato.setDataNascimento(contato.getDataNascimento());
				this.contados.put(chave, novoContato);
				System.out.println("contato atualizado");
			}
		});

	}

	public void excluirContato(Integer codigoContato) {
		if (codigoContato < 0) {
			System.out.println("contato inválido. tente novamente!");
			return;
		}
		// busca o contato pra excluir
		this.contados.remove(codigoContato);
	}

	public void excluirTodosContatos() {
		if(this.contados.isEmpty()) {
			System.out.println("não há contatos para excluir.");
			return;
		}
		this.contados.clear();
		System.out.println("todos os contatos foram excluidos");
	}

	// lista os contatos aniversariantes em um determinado mês
	public void exibirContatosAniversariante(int mes) {
		if (mes < 1 || mes > 12) {
			System.out.println("informe um mês válido");
			return;
		}
		this.contados.forEach((chave, cont) -> {
			if (cont.getDataNascimento().getMes() == mes) {
				System.out.println(cont.toString());
			}
		});
	}

	// verifica o contato já existe na lista
	private boolean contatoExistente(Contato contato) {
		return this.contados.values().stream().anyMatch(cont -> {
			if (cont.getContato().equals(contato.getContato())) {
				return true;
			}
			return false;
		});
	}
}
