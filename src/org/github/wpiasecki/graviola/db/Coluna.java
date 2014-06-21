package org.github.wpiasecki.graviola.db;

import java.util.Date;

import android.provider.BaseColumns;

public class Coluna {

	public final String nome;
	public final Class<?> tipo;
	public final Integer tamanho;
	public final String fk;
	
	class PK {}
	
	private Coluna(String nome, Class<?> tipo, Integer tamanho, String fk) {
		this.nome = nome;
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.fk = fk;
	}
	
	private Coluna(String nome, Class<?> tipo) {
		this(nome, tipo, null, null);
	}
	
	private Coluna(String nome, Class<?> tipo, String fk) {
		this(nome, tipo, null, fk);
	}
	
	public static Coluna varchar(String nome, Integer tamanho) {
		return new Coluna(nome, String.class, tamanho, null);
	}
	
	public static Coluna integer(String nome) {
		return new Coluna(nome, Integer.class);
	}
	
	public static Coluna fk(String nome, String fk) {
		return new Coluna(nome, Integer.class, fk);
	}
	
	public static Coluna pk(String nome) {
		return new Coluna(nome, PK.class);
	}
	
	public String getNomeFormatado() {
		String tamanho = tipo.equals(String.class) ? "(" + this.tamanho + ")" : "";
		String chaveEstrangeira = (fk != null) ? " REFERENCES " + fk : "";
		return nome + " " + getNomeTipo() + tamanho + chaveEstrangeira;
	}
	
	public String getNomeTipo() {
		if (tipo.equals(String.class)) {
			return "VARCHAR";
		} else if (tipo.equals(Integer.class)) {
			return "INTEGER";
		} else if (tipo.equals(Date.class)) {
			return "DATE";
		} else if (tipo.equals(PK.class)) {
			return "INTEGER PRIMARY KEY AUTOINCREMENT";
		} else {
			throw new IllegalArgumentException("Nenhum tipo mapeado para " + tipo);
		}
	}
	
	public static Coluna date(String nome) {
		return new Coluna(nome, Date.class);
	}
	
}
