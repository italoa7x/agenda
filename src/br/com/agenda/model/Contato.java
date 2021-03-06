package br.com.agenda.model;

import java.text.ParseException;

public class Contato {
	private String contato;
	private DataNascimento dataNascimento;
	private String nome;
	private String email;
	private String contatoComercial;

	public Contato(String nome, String contato, String contatoComercial, String email, DataNascimento dataNascimento)
			throws ParseException {
		super();
		this.contatoComercial = contatoComercial;
		this.email = email;
		this.nome = nome;
		this.contato = contato;
		// converte a data passada em String pra um Date
		this.dataNascimento = dataNascimento;
	}

	public String getContatoComercial() {
		return contatoComercial;
	}

	public void setContatoComercial(String contatoComercial) {
		this.contatoComercial = contatoComercial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public DataNascimento getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(DataNascimento dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + "\nContato: " + contato + "\nContato comercial: " + this.contatoComercial
				+ "\nE-mail: " + this.email + "\nData de nascimento: " + dataNascimento.getDia() + "/"
				+ dataNascimento.getMes() + "/" + dataNascimento.getAno();
	}

}
