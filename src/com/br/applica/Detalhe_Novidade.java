package com.br.applica;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalhe_Novidade extends Activity {
	
	TextView txtTitulo_novidade,txtTexto_novidade;
	ImageView imgNovidade;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhe_novidade);
		
		txtTitulo_novidade = (TextView)findViewById(R.id.txtTituloNovidade);
		txtTexto_novidade = (TextView)findViewById(R.id.txtTextoNovidade);
		imgNovidade = (ImageView)findViewById(R.id.imgNovidade);
		
		txtTitulo_novidade.setText(getIntent().getStringExtra("titulo"));
		txtTexto_novidade.setText(getIntent().getStringExtra("descricao"));
		
		int id1 = getIntent().getIntExtra("img1",0);
	
		
		imgNovidade.setImageResource(id1);
		
		
		
	}
	
}
