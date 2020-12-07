package br.com.agenda.util;

public abstract class EmailValidador {
	public static boolean validar(String email) {
		return email.contains("@") ? true : false;
	}
}
