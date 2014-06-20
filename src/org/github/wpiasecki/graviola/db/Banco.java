package org.github.wpiasecki.graviola.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Banco extends SQLiteOpenHelper {

	public static final String NOME = "graviola";
	public static final int DB_VERSION = 1;
	
	
	public Banco(Context context) {
		super(context, NOME, null, DB_VERSION);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		for (Tabela t : getTabelas()) {
			
			/*
			 * Que saudades do groovy :-(
			 */
			List<String> colunas = new ArrayList<String>();
			for (Coluna c : t.getColunas()) {
				colunas.add(c.getNomeFormatado());
			}
			String nomeColunas = StringUtils.join(colunas.toArray(), ", ");
			
			String create = String.format(
					"CREATE TABLE %s (%s)", 
					t.getNomeTabela(), 
					nomeColunas);
			
			db.execSQL(create);
		}
	}
	
	
	private Tabela[] getTabelas() {
		return new Tabela[] { new Linha(), new Ponto(), new Horario() };
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
