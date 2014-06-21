package org.github.wpiasecki.graviola.modelo;

import org.github.wpiasecki.graviola.db.Coluna;
import org.github.wpiasecki.graviola.db.Tabela;

import android.provider.BaseColumns;

public class Horario implements Tabela {

	public static final String ID = BaseColumns._ID;
	public static final String HORA = "hora";
	public static final String PONTO_ID = "ponto_id";
	
	public final Integer id;
	public final Ponto ponto;
	public final String hora;
	
	public Horario(Integer id, Ponto ponto, String hora) {
		this.id = id;
		this.ponto = ponto;
		this.hora = hora;
	}
	
	public Horario() { this(null, null, null); }

	@Override
	public String getNomeTabela() {
		return "horario";
	}

	@Override
	public Coluna[] getColunas() {
		return new Coluna[] {
			Coluna.pk(ID),
			Coluna.varchar(HORA, 5),
			Coluna.fk(PONTO_ID, "ponto(id)")
		};
	}

}
