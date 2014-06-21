package org.github.wpiasecki.graviola.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.github.wpiasecki.graviola.modelo.Horario;
import org.github.wpiasecki.graviola.modelo.Linha;
import org.github.wpiasecki.graviola.modelo.Ponto;
import org.github.wpiasecki.graviola.util.Logger;
import org.github.wpiasecki.graviola.util.Profiler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Abstração para o acesso ao banco de dados
 * 
 * 
 * @author Wilson Piasecki
 *
 */
public class Banco extends SQLiteOpenHelper {

	public static final String NOME = "graviola.db";
	public static final int DB_VERSION = 1;
	private Context context;
	Logger log = new Logger(this);
	
	public Banco(Context context) {
		super(context, NOME, null, DB_VERSION);
		this.context = context;
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		log.d("onCreate");
		
		for (Tabela t : getTabelas()) {
			
			String nomeColunas = juntarColunas(t.getColunas());
			
			String create = String.format(
					"CREATE TABLE %s (%s)", 
					t.getNomeTabela(), 
					nomeColunas);
			
			db.execSQL(create);
		}
		
		db.beginTransaction();
		carregarSqlEmbarcado(db);
		
		/*
		 * Super intuitivo. Sem isso não estava carregando sequer tabelas
		 * no banco.
		 * 
		 * http://stackoverflow.com/questions/13533619/sqlite-no-such-table
		 */
		db.setTransactionSuccessful();
		db.endTransaction();
		
		Cursor c = db.rawQuery("select count(0) as linhas from linha", new String[] {});
		
		while(c.moveToNext()) {
			log.d("Linhas URBS carregadas. Total linhas: " + 
					c.getLong( c.getColumnIndex("linhas") ));
		}
	}
	
	
	/**
	 * Cria um SQL com o nome das colunas formatado para CREATE TABLE.
	 * 
	 * @param colunas
	 * @return
	 */
	private String juntarColunas(Coluna[] colunas) {
		List<String> nomeColunas = new ArrayList<String>();
		for (Coluna c : colunas) {
			nomeColunas.add(c.getNomeFormatado());
		}
		return StringUtils.join(nomeColunas.toArray(), ", ");
	}
	
	
	/**
	 * Carrega o arquivo onibus.sql que vem com a aplicação
	 * 
	 * @param db banco 
	 */
	private void carregarSqlEmbarcado(SQLiteDatabase db) {
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(context.getAssets().open("onibus.sql")));
			String line;
			
			Profiler p = new Profiler("insert onibus.sql");
			
			while ( (line = reader.readLine() ) != null ) {
				db.execSQL(line, new String[]{});
				p.imprimirLaço();
			}
			p.imprimir();
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Obtém as tabelas que compõe o banco do Graviola-android
	 * @return
	 */
	private Tabela[] getTabelas() {
		return new Tabela[] { new Linha(), new Ponto(), new Horario() };
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		for (Tabela t : getTabelas()) {
			db.execSQL("DROP TABLE " + t.getNomeTabela());
		}
		onCreate(db);
	}

}
