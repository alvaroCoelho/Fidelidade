package com.br.applica;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CheckIn extends Activity implements OnClickListener{
	
	Button btnNovidades,btnProdutos,btnPromocoes,btnReservas,btnVoltar,btnContato,btnLocalizar;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkin);
		
		btnNovidades = (Button)findViewById(R.id.btnNovidades);
		btnProdutos = (Button)findViewById(R.id.btnProdutos);
		btnPromocoes = (Button)findViewById(R.id.btnPromocoes);
		btnReservas = (Button)findViewById(R.id.btnReservas);
		btnVoltar = (Button)findViewById(R.id.btnVoltar);
		btnContato = (Button)findViewById(R.id.btnContatos);
		btnLocalizar = (Button)findViewById(R.id.btnLocalizarLocal);
		
		
		
		btnNovidades.setOnClickListener(this);
		btnProdutos.setOnClickListener(this);
		btnPromocoes.setOnClickListener(this);
		btnReservas.setOnClickListener(this);
		btnVoltar.setOnClickListener(this);
		btnContato.setOnClickListener(this);
		btnLocalizar.setOnClickListener(this);
		
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
			
		case R.id.btnVoltar:			
			this.finish();
			break;
			
		case R.id.btnPromocoes:			
			Intent promocoes = new Intent(this,Promocoes.class);	
			startActivity(promocoes);	
			this.finish();
			break;
			
		case R.id.btnContatos:			
			Intent contato = new Intent(this,Contato.class);	
			startActivity(contato);	
			this.finish();
			break;
			
		case R.id.btnLocalizarLocal:			
			  
			 WifiManager wifiMgr = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
			   
			   List<ScanResult> scanResults=wifiMgr.getScanResults();
			    
			   String name2="IQUE";
			   String confirm = "NAO";
			   
			   
			   for (ScanResult scan : scanResults) {
				   if (scan.SSID.toString().equalsIgnoreCase(name2)){
					   confirm = "SIM";
					   					   
					   AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
					   alertDialog.setTitle("Applica Tecnologia LTDA");
					   alertDialog.setMessage("Confirmar Check In?");
					   alertDialog.setIcon(R.drawable.ic_action_place);
					  
					   alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
						   public void onClick(DialogInterface arg0, int arg1) {
						   
						   Toast.makeText(CheckIn.this, "Check In Realizado com Sucesso!", Toast.LENGTH_SHORT).show();
						   
						   }
						   
					   });
					   
					   
					   alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() { 
						   public void onClick(DialogInterface arg0, int arg1) {
							   
							   Toast.makeText(CheckIn.this, "Check In Cancelado!", Toast.LENGTH_SHORT).show(); 
							   } 
						   
					     });

					   AlertDialog alerta = alertDialog.create();
					   					  
					   alerta.show();
					   
					   return;
					   
				      }else{
				    	  
				    	  confirm = "NAO";
				    	  
				      }
			      }
			   
			   if (confirm.equalsIgnoreCase("NAO")){
				   
				   Toast.makeText(CheckIn.this, "Nada localizado!" , Toast.LENGTH_SHORT).show(); 
				   
			   }
			    
			  
			
		break;
		
		
		}
		
		
	}

}
