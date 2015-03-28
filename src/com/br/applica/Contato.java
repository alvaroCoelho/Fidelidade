package com.br.applica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class Contato extends Activity implements OnClickListener {
	
	Button btnNovidades,btnProdutos,btnPromocoes,btnReservas,btnCheckin,btnVoltar,btnMensagem;
	
	TextView txtTelefones,txtEmail,txtSite;
	
	WebView webMapa;
	
	String mapPath = "https://goo.gl/maps/hUULN";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contato);
		
		btnNovidades = (Button)findViewById(R.id.btnNovidades);
		btnProdutos = (Button)findViewById(R.id.btnProdutos);
		btnPromocoes = (Button)findViewById(R.id.btnPromocoes);
		btnReservas = (Button)findViewById(R.id.btnReservas);
		btnCheckin = (Button)findViewById(R.id.btnCheckIn);
		btnVoltar = (Button)findViewById(R.id.btnVoltar);
		btnMensagem = (Button)findViewById(R.id.btnMensagem);
		
	
		txtTelefones = (TextView)findViewById(R.id.txtTelefones);	
		txtEmail = (TextView)findViewById(R.id.txtEmail);
		txtSite = (TextView)findViewById(R.id.txtSite);
		
		
		webMapa = (WebView)findViewById(R.id.webView1);
		
		
		webMapa.getSettings().setJavaScriptEnabled(true);
		webMapa.setWebViewClient(new WebViewClient());
		webMapa.loadUrl(mapPath);
		
		btnNovidades.setOnClickListener(this);
		btnProdutos.setOnClickListener(this);
		btnPromocoes.setOnClickListener(this);
		btnReservas.setOnClickListener(this);
		btnCheckin.setOnClickListener(this);
		btnVoltar.setOnClickListener(this);
		btnMensagem.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnNovidades:			
		Intent novidades = new Intent(this,Novidades.class);	
		startActivity(novidades);	
		this.finish();
		break;
		
		case R.id.btnProdutos:			
			Intent produtos = new Intent(this,Produtos.class);	
			startActivity(produtos);	
			this.finish();
			break;
			
		case R.id.btnReservas:			
			Intent reservas = new Intent(this,Reservas.class);	
			startActivity(reservas);
			this.finish();
			break;
			
		case R.id.btnCheckIn:			
			Intent checkin = new Intent(this,CheckIn.class);	
			startActivity(checkin);	
			this.finish();
			break;
			
		case R.id.btnPromocoes:			
			Intent promocoes = new Intent(this,Promocoes.class);	
			startActivity(promocoes);	
			this.finish();
			break;
			
		case R.id.btnVoltar:			
			this.finish();
			break;
			
		case R.id.btnMensagem:			
			Intent mensagem = new Intent(this,Mensagem.class);	
			startActivity(mensagem);	
			break;
		
		
		}
		
		
	}
	

}
