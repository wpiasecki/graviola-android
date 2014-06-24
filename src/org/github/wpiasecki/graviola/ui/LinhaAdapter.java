package org.github.wpiasecki.graviola.ui;

import org.github.wpiasecki.graviola.modelo.Linha;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

public class LinhaAdapter extends CursorAdapter {

	SimpleCursorAdapter s;
	
	public LinhaAdapter(Context context, Cursor c) {
		super(context, c, true);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
