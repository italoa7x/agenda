package br.com.agenda.util;

import br.com.agenda.model.DataNascimento;

public abstract class StringToDataNascimento {

	public static DataNascimento converter(String dataNascimento) {
		try {
			int diaNascimento = Integer.parseInt(dataNascimento.substring(0, 2));
			int mesNascimento = Integer.parseInt(dataNascimento.substring(3, 5));
			int anoNascimento = Integer.parseInt(dataNascimento.substring(6, 10));

			return new DataNascimento(diaNascimento, mesNascimento, anoNascimento);
		} catch (Exception e) {
			throw new RuntimeException("data invalida");
		}
	}
}
