package org.github.wpiasecki.graviola.modelo;

import java.util.Date;
import java.util.List;

import org.github.wpiasecki.graviola.db.Coluna;
import org.github.wpiasecki.graviola.db.Tabela;

import android.provider.BaseColumns;

public class Ponto implements Tabela {

	public static final String ID = BaseColumns._ID;
	public static final String NOME = "nome";
	public static final String TIPO_DIA = "tipo_dia";
	public static final String VALIDO_A_PARTIR_DE = "valido_a_partir_de";
	public static final String LINHA_ID = "linha_id";
	
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

	public Ponto() { this(null, null, null, null, null, null); }
	
	public String getNomeTabela() {
		return "ponto";
	}

	public Coluna[] getColunas() {
		return new Coluna[] { 
			Coluna.pk     (ID),
			Coluna.varchar(NOME, 100), 
			Coluna.integer(TIPO_DIA),
			Coluna.date   (VALIDO_A_PARTIR_DE),
			Coluna.fk     (LINHA_ID, "linha(id)"),
		};
	}

}
