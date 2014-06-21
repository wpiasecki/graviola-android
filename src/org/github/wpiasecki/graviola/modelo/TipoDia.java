package org.github.wpiasecki.graviola.modelo;

public enum TipoDia {

	DIA_UTIL( 1, "Dia útil" ),
	SABADO( 2, "Sábado" ),
	DOMINGO_FERIADO( 3, "Domingo/feriado" );
	
	private Integer codigo;
	private String nome;

	private TipoDia(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
}
