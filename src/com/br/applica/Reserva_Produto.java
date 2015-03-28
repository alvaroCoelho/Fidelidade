package com.br.applica;

import com.br.applica.banco.BancoReserva;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Reserva_Produto extends Activity implements OnClickListener{
	
	TextView txtTituloReservar,txtDataRetirada;
	EditText etNomeReserva,etRg,etEmailReservar;
	DatePicker dpDataRetirada;
	Button btnConfirmarReserva;
	int id_img;
	String nome_produto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reservar);
		
		txtTituloReservar = (TextView)findViewById(R.id.txtTituloReservar);
		txtDataRetirada = (TextView)findViewById(R.id.txtDataRetirada);
		etNomeReserva = (EditText)findViewById(R.id.etNomeReserva);
		etRg = (EditText)findViewById(R.id.etRg);
		etEmailReservar = (EditText)findViewById(R.id.etEmailReservar);
		dpDataRetirada = (DatePicker)findViewById(R.id.dpDataRetirada);
		btnConfirmarReserva = (Button)findViewById(R.id.btnConfirmarReserva);
		
		id_img = getIntent().getIntExtra("id_img",0);
		nome_produto = getIntent().getStringExtra("nome_produto");
			
		btnConfirmarReserva.setOnClickListener(this);
	}
	
	public boolean salvarReserva(){
	
		try {
			
			String data_retirada = "Data de Retirada: "+String.valueOf(dpDataRetirada.getDayOfMonth())+"/"+ String.valueOf(dpDataRetirada.getMonth()+1)+"/"+ String.valueOf(dpDataRetirada.getYear());
			
			BancoReserva bancoReserva = new BancoReserva(this);
			bancoReserva.inserir(nome_produto, id_img, data_retirada);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.btnConfirmarReserva:			
			
			if(salvarReserva()){
				
				Toast.makeText(this, "Reserva Ralizada com Sucessso ", Toast.LENGTH_LONG).show();	
				Intent reservas = new Intent(this,Reservas.class);	
				startActivity(reservas);	
				this.finish();
				
			}else{
				
				Toast.makeText(this, "Erro ao inserir a Reserva ", Toast.LENGTH_LONG).show();	
			}
			
			this.finish();
			
			break;
		
		
		}
		
		
	}

}
