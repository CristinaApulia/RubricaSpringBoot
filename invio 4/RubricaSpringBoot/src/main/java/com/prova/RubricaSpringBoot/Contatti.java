package com.prova.RubricaSpringBoot;

public class Contatti {
	String nome;
	String cognome;
	String numero;

	public Contatti(String nome, String cognome, String numero) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Contatti [nome=" + nome + ", cognome=" + cognome + ", numero=" + numero + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
