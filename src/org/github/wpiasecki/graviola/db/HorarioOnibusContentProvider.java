package org.github.wpiasecki.graviola.db;

import org.github.wpiasecki.graviola.modelo.Linha;
import org.github.wpiasecki.graviola.util.Logger;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class HorarioOnibusContentProvider extends ContentProvider {

	public static final String AUTHORITY = "org.github.wpiasecki.graviola.db.HorarioOnibusContentProvider";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
	public static final Uri URI_LINHAS = Uri.parse("content://" + AUTHORITY + "/linhas");
	public static final String JSON = "text/json";
	private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	
	static {
		uriMatcher.addURI(AUTHORITY, "/linhas", UriQuery.LINHAS);
		uriMatcher.addURI(AUTHORITY, "/linha/#", UriQuery.LINHA);
	}
	
	Logger log = new Logger(this);
	
	Banco getBanco() {
		return new Banco(getContext());
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		getBanco().getWritableDatabase();
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public String getType(Uri uri) {
		return JSON;
	}

	
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	
	@Override
	public boolean onCreate() {
		return false;
	}
	
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
		
		Banco banco = getBanco();
		
		SQLiteDatabase db = banco.getReadableDatabase();
		
		Cursor c = db.rawQuery("select count(0) as linhas from linha", new String[] {});
		
		while(c.moveToNext()) {
			log.d("Linhas URBS carregadas. Total linhas: " + 
					c.getLong( c.getColumnIndex("linhas") ));
		}
		
		builder.setTables(Linha.TABELA);
		
		switch (uriMatcher.match(uri)) {
		case UriQuery.LINHAS:
			return builder.query(
					db, 
					projection, 
					selection, 
					selectionArgs, 
					null, 
					null, 
					Linha.NOME);

		case UriQuery.LINHA:
			break;
			
		default:
			break;
		}
		
		return null;
	}

	
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
