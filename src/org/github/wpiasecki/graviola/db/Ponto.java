package org.github.wpiasecki.graviola.db;

import java.util.Date;
import java.util.List;

import android.provider.BaseColumns;

public class Ponto implements Tabela {

	public final Integer id;
	public final String nome;
	public final Integer tipoDia;
	public final Date validoAPartirDe;
	public final Linha linha;
	public final List<Horario> horarios;
	
	public Ponto(Integer id, String nome, Integer tipoDia,
			Date validoAPartirDe, Linha linha, List<Horario> horarios) {
		this.id = id;
		this.nome = nome;
		this.tipoDia = tipoDia;
		this.validoAPartirDe = validoAPartirDe;
		this.linha = linha;
		this.horarios = horarios;
	}

	Ponto() { this(null, null, null, null, null, null); }
	
	public String getNomeTabela() {
		return "ponto";
	}

	public Coluna[] getColunas() {
		return new Coluna[] { 
			Coluna.integer(BaseColumns._ID),
			Coluna.varchar("nome", 100), 
			Coluna.integer("tipo_dia"),
			Coluna.date("valido_a_partir_de"),
			Coluna.integer("linha_id"),
		};
	}

}
