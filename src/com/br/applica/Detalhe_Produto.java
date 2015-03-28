package com.br.applica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalhe_Produto extends Activity implements OnClickListener{
	
	TextView txtNomeProduto,txtDetalhesProduto;
	Button btnReservarProduto;
	ImageView imgProduto1,imgProduto2;
	int id1,id2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.detalhe_produto);
		
				
		
		txtNomeProduto = (TextView)findViewById(R.id.txtNomeProduto);
		txtDetalhesProduto = (TextView)findViewById(R.id.txtDetalhesProduto);
		btnReservarProduto = (Button)findViewById(R.id.btnReservarProduto);
		imgProduto1 = (ImageView)findViewById(R.id.imgProduto1);
		imgProduto2 = (ImageView)findViewById(R.id.imgProduto2);
		
		
		
		txtNomeProduto.setText(getIntent().getStringExtra("titulo"));
		txtDetalhesProduto.setText(getIntent().getStringExtra("descricao"));
		
		id1 = getIntent().getIntExtra("img1",0);
		id2 = getIntent().getIntExtra("img2",0);
		
		imgProduto1.setImageResource(id1);
		imgProduto2.setImageResource(id2);
	
		btnReservarProduto.setOnClickListener(this);
		
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		
		case R.id.btnReservarProduto:			
			Intent reservarProduto = new Intent(this,Reserva_Produto.class);	
			reservarProduto.putExtra("id_img", id1);
			reservarProduto.putExtra("nome_produto", txtNomeProduto.getText().toString());
			startActivity(reservarProduto);	
			this.finish();
			break;
		
		
		
		}
		
		
	}

}
