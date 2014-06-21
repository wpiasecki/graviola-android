package org.github.wpiasecki.graviola.util;

public class Profiler {

	String nome;
	long t0;
	int vezes;
	int contador = 0;
	
	public Profiler(String nome, Integer vezes) {
		this.nome = nome;
		this.vezes = vezes;
		iniciar();
	}
	
	public Profiler(String nome) {
		this(nome, 100);
	}
	
	public void iniciar() {
		t0 = System.currentTimeMillis();
	}
	
	String agora() {
		return (System.currentTimeMillis() - t0) / 1000 + "ms";
	}
	
	public void imprimir() {
		imprimir("");
	}
	
	void imprimir(String adicional) {
		System.out.println("["+nome+"] " + adicional + " executado em " + agora() );
	}
	
	public void imprimirLaço() {
		if (++contador % vezes == 0) {
			imprimir(contador + " iterações ");
		}
	}
}
