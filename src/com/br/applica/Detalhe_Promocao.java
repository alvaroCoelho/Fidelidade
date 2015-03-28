package com.br.applica;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalhe_Promocao extends Activity{
	
	TextView txtTituloPromocao,txtDetalhesPromocao;
	ImageView imgPromocao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhe_promocao);
		
		txtTituloPromocao = (TextView)findViewById(R.id.txtTituloPromocao);
		txtDetalhesPromocao = (TextView)findViewById(R.id.txtTextoPromocao);
		imgPromocao = (ImageView)findViewById(R.id.imgPromocao);
		
		txtTituloPromocao.setText(getIntent().getStringExtra("titulo"));
		txtDetalhesPromocao.setText(getIntent().getStringExtra("descricao"));
		
		int id1 = getIntent().getIntExtra("img1",0);
		imgPromocao.setImageResource(id1);
		
	}

}
