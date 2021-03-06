package it.polito.tdp.lab04.model;

public class Corso {

	String codins ;
	int numeroCrediti ;
	String nome ;
	int periodoDidattico;
	
	public Corso() {
		super();
	}
	
	public Corso(String codins, int numeroCrediti, String nome, int periodoDidattico) {
		super();
		this.codins = codins;
		this.numeroCrediti = numeroCrediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}

	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public int getNumeroCrediti() {
		return numeroCrediti;
	}
	public void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPeriodoDidattico() {
		return periodoDidattico;
	}
	public void setPeriodoDidattico(int periodoDidattico) {
		this.periodoDidattico = periodoDidattico;
	}
	
	public String toString() {
		return nome;
	}
	
	public String toStringcompleto() {
		String m = String.format("%-20s", codins);
		String c = String.format("%-30s", numeroCrediti);
		String n = String.format("%-30s", nome);
		String cd = String.format("%-30s", periodoDidattico);
		return m +c +n + cd + "\n";
	}
}
