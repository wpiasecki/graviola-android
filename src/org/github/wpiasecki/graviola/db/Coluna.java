package org.github.wpiasecki.graviola.db;

public class Coluna {

	public final String nome;
	public final Class<?> tipo;
	public final Integer tamanho;
	
	private Coluna(String nome, Class<?> tipo, Integer tamanho) {
		this.nome = nome;
		this.tipo = tipo;
		this.tamanho = tamanho;
	}
	
	private Coluna(String nome, Class<?> tipo) {
		this.nome = nome;
		this.tipo = tipo;
		this.tamanho = null;
	}
	
	public static Coluna varchar(String nome, Integer tamanho) {
		return new Coluna(nome, String.class, tamanho);
	}
	
	public static Coluna integer(String nome) {
		return new Coluna(nome, Integer.class);
	}
	
	public String getNomeFormatado() {
		if (tipo.equals(String.class)) {
			return nome + " " + tipo + "(" + tamanho + ")" ;
		} 
		else {
			return nome + " " + tipo ;
		}
	}
	
}
