package org.github.wpiasecki.graviola.db;

import android.provider.BaseColumns;

public class Linha implements Tabela {

	public static final String TABELA = "linha";
	public static final String ID = BaseColumns._ID;
	public static final String NOME = "nome";
	public static final String CODIGO = "codigo";
	
	public final Integer id;
	public final String nome;
	public final String codigo;
	
	public Linha(Integer id, String nome, String codigo) {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
	}

	Linha() { this(null, null, null); }
	
	@Override
	public String getNomeTabela() {
		return TABELA;
	}

	@Override
	public Coluna[] getColunas() {
		return new Coluna[] {
			Coluna.integer(ID),
			Coluna.varchar(NOME, 100),
			Coluna.varchar(CODIGO, 10),
		};
	}
	
}
