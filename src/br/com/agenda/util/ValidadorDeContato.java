package br.com.agenda.util;

import br.com.agenda.model.Contato;

public abstract class ValidadorDeContato {

	public static boolean validarContato(Contato contato) {
		if (contato.getContato().isBlank() && contato.getDataNascimento() == null) {
			return false;
		}
		return true;
	}
}
