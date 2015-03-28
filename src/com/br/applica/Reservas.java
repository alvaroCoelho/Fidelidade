package com.br.applica;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.br.applica.banco.BancoReserva;
import com.br.applica.entidades.Reserva;

public class Reservas extends Activity implements OnClickListener,OnItemClickListener {
	
	Button btnNovidades,btnProdutos,btnPromocoes,btnVoltar,btnCheckin,btnContato,btnReservar;
	
	private ListView lista;
	private Lista_Adapter lista_adapter;
	private ArrayList<Item_Lista> itens;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reservas);
		
		btnNovidades = (Button)findViewById(R.id.btnNovidades);
		btnProdutos = (Button)findViewById(R.id.btnProdutos);
		btnPromocoes = (Button)findViewById(R.id.btnPromocoes);
		btnVoltar = (Button)findViewById(R.id.btnVoltar);
		btnCheckin = (Button)findViewById(R.id.btnCheckIn);
		btnContato = (Button)findViewById(R.id.btnContatos);
		btnReservar = (Button)findViewById(R.id.btnReservar);
		
		btnNovidades.setOnClickListener(this);
		btnProdutos.setOnClickListener(this);
		btnPromocoes.setOnClickListener(this);
		btnVoltar.setOnClickListener(this);
		btnCheckin.setOnClickListener(this);
		btnContato.setOnClickListener(this);
		btnReservar.setOnClickListener(this);
		
		
	lista = (ListView)findViewById(R.id.listViewReservas);
		
		lista.setOnItemClickListener(this);
		
		createListView();
	}
	
	
	private void createListView(){
		
		BancoReserva bancoReserva = new BancoReserva(this);
		ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
		listaReservas = bancoReserva.pesquisaReservas();
		
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<Item_Lista>();
        
        for (int i = 0; i < listaReservas.size(); i++) {
        	
            String nome_produto = listaReservas.get(i).getNome_produto();
        	String data = listaReservas.get(i).getData_retirada();
			int id_img = listaReservas.get(i).getId_img();
			
			Item_Lista item = new Item_Lista(nome_produto,data,id_img,0);
			
			itens.add(item);
		}
        
   
        //Cria o adapter
        lista_adapter = new Lista_Adapter(this, itens);
 
        //Define o Adapter
        lista.setAdapter(lista_adapter);
        //Cor quando a lista é selecionada para ralagem.
        lista.setCacheColorHint(Color.TRANSPARENT);
    }
 
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        //Pega o item que foi selecionado.
    	Item_Lista item = lista_adapter.getItem(arg2);
    	final int id_produto = item.id_img1;
    	final BancoReserva bancoReserva = new BancoReserva(this);
    	
    	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
    	       public void onClick(DialogInterface dialog, int which) {
    	           switch (which){
    	           case DialogInterface.BUTTON_NEGATIVE:
    	        	   bancoReserva.deletar(id_produto);
    	        	   Toast.makeText(Reservas.this, "Reserva Cancelada Realizado com Sucesso!", Toast.LENGTH_SHORT).show();
    	        	   Intent reservas = new Intent(Reservas.this,Reservas.class);	
    	       		  startActivity(reservas);	
    	        	   
    	        	   Reservas.this.finish();
    	               break;

    	           case DialogInterface.BUTTON_POSITIVE:
    	        	   Toast.makeText(Reservas.this, "Reserva Não cancelada!", Toast.LENGTH_SHORT).show();
    	               break;
    	           }
    	       }
    	   };

    	   AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	   builder.setMessage("Deseja Cancelar esta Reserva?").setPositiveButton("Não", dialogClickListener)
    	       .setNegativeButton("Sim", dialogClickListener).show();
    	  
    	
       
        
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
			
		case R.id.btnVoltar:			
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
			
		case R.id.btnContatos:			
			Intent contato = new Intent(this,Contato.class);	
			startActivity(contato);	
			this.finish();
			break;
			
		case R.id.btnReservar:			
			Intent produtos2 = new Intent(this,Produtos.class);	
			startActivity(produtos2);
			this.finish();
			break;
		
		
		}
	
		
	}

}
