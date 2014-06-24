package org.github.wpiasecki.graviola;

import org.github.wpiasecki.graviola.db.HorarioOnibusContentProvider;
import org.github.wpiasecki.graviola.modelo.Linha;
import org.github.wpiasecki.graviola.util.Logger;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {

	Logger log = new Logger(this);
	
	private EditText buscaLinha;
	private ListView listaLinhas;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
        
        
        listaLinhas = (ListView) findViewById(R.id.lista_linhas);
        buscaLinha = (EditText) findViewById(R.id.busca_linha);
        
        carregarLinhas();
        
        listaLinhas.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				log.d("wat");
			}
		});
    }
    
    
    void carregarLinhas() {
    	Cursor cursor = getContentResolver().query(
    			HorarioOnibusContentProvider.URI_LINHAS, 
    			new String[] { Linha.ID, Linha.CODIGO, Linha.NOME }, 
    			null, null, Linha.NOME);
    	
    	String[] from = { Linha.CODIGO, Linha.NOME };
    	int[] to = { R.id.text_codigo_linha, R.id.text_nome_linha };
    	
    	SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(
    			getBaseContext(), R.layout.linha_entry, cursor, from, to);
    	
    	listaLinhas.setAdapter(simpleAdapter);
    }
    
    
    void pesquisar() {
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
