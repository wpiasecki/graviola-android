package org.github.wpiasecki.graviola.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class HorarioOnibusContentProvider extends ContentProvider {

	public static final String AUTHORITY = "org.github.wpiasecki.graviola.HorarioOnibusProvider";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
	public static final String JSON = "text/json";
	
	Banco banco = new Banco(getContext());
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		banco.getWritableDatabase();
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
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
		
		builder.setTables(Linha.TABELA);
		
		Cursor cursor = builder.query(
				banco.getReadableDatabase(), 
				projection, 
				selection, 
				selectionArgs, 
				null, 
				null, 
				sortOrder);
		
		return cursor;
	}

	
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
