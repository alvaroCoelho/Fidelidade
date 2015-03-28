package com.br.applica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	
	Button btnNovidades,btnProdutos,btnPromocoes,btnReservas,btnCheckin,btnContato;
	
	ImageView logo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnNovidades = (Button)findViewById(R.id.btnVoltar);
		btnProdutos = (Button)findViewById(R.id.btnProdutos);
		btnPromocoes = (Button)findViewById(R.id.btnPromocoes);
		btnReservas = (Button)findViewById(R.id.btnReservas);
		btnCheckin = (Button)findViewById(R.id.btnCheckIn);
		btnContato = (Button)findViewById(R.id.btnContatos);
		
		logo = (ImageView)findViewById(R.id.imglogo);
		
		btnNovidades.setOnClickListener(this);
		btnProdutos.setOnClickListener(this);
		btnPromocoes.setOnClickListener(this);
		btnReservas.setOnClickListener(this);
		btnCheckin.setOnClickListener(this);
		btnContato.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnVoltar:			
		Intent novidades = new Intent(this,Novidades.class);	
		startActivity(novidades);		
		break;
		
		case R.id.btnProdutos:			
			Intent produtos = new Intent(this,Produtos.class);	
			startActivity(produtos);		
			break;
			
		case R.id.btnReservas:			
			Intent reservas = new Intent(this,Reservas.class);	
			startActivity(reservas);		
			break;
			
		case R.id.btnCheckIn:			
			Intent checkin = new Intent(this,CheckIn.class);	
			startActivity(checkin);		
			break;
			
		case R.id.btnPromocoes:			
			Intent promocoes = new Intent(this,Promocoes.class);	
			startActivity(promocoes);		
			break;
			
		case R.id.btnContatos:			
			Intent contato = new Intent(this,Contato.class);	
			startActivity(contato);		
			break;
		
		
		}
		
	}
	
	
	
	
	
	
	
	
}
