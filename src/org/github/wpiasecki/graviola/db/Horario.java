package org.github.wpiasecki.graviola.db;

public class Horario implements Tabela {

	public final Integer id;
	public final Ponto ponto;
	public final String hora;
	
	public Horario(Integer id, Ponto ponto, String hora) {
		this.id = id;
		this.ponto = ponto;
		this.hora = hora;
	}
	
	Horario() { this(null, null, null); }

	@Override
	public String getNomeTabela() {
		return "horario";
	}

	@Override
	public Coluna[] getColunas() {
		return new Coluna[] {
			Coluna.integer("id"),
			Coluna.varchar("hora", 5),
			Coluna.integer("ponto_id")
		};
	}

}
