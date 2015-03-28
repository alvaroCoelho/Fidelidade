package com.br.applica;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Promocoes extends Activity implements OnClickListener,OnItemClickListener{
	
	Button btnNovidades,btnProdutos,btnVoltar,btnReservas,btnCheckin,btnContato;
	
	private ListView lista;
	private Lista_Adapter lista_adapter;
	private ArrayList<Item_Lista> itens;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.promocoes);
		
		btnNovidades = (Button)findViewById(R.id.btnNovidades);
		btnProdutos = (Button)findViewById(R.id.btnProdutos);
		btnVoltar = (Button)findViewById(R.id.btnVoltar);
		btnReservas = (Button)findViewById(R.id.btnReservas);
		btnCheckin = (Button)findViewById(R.id.btnCheckIn);
		btnContato = (Button)findViewById(R.id.btnContatos);
			
		
		btnNovidades.setOnClickListener(this);
		btnProdutos.setOnClickListener(this);
		btnVoltar.setOnClickListener(this);
		btnReservas.setOnClickListener(this);
		btnCheckin.setOnClickListener(this);
		btnContato.setOnClickListener(this);
		
		
		lista = (ListView)findViewById(R.id.listViewPromocoes);
		
		lista.setOnItemClickListener(this);
		
		createListView();
	}
	
	
	private void createListView(){
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<Item_Lista>();
        Item_Lista item1 = new Item_Lista("Polo Ralph Lauren","Camisa Polo Ralph Lauren USA Preta de R$ 475,90 por R$ 219,90 em até 7x de R$ 31,41", R.drawable.promocao1,0);
        Item_Lista item2 = new Item_Lista("Lança Perfume","Saia Lança Perfume Barra Amarela de R$ 297,00 por R$ 89,10 em até 2x de R$ 44,55", R.drawable.promocao2,0);
        Item_Lista item3 = new Item_Lista("Capodarte","Scarpin Capodarte Salto Alto Bico Redondo Vermelho de R$ 249,90 por R$ 214,89 em até 7x de R$ 30,70", R.drawable.promocao3,0);
        Item_Lista item4 = new Item_Lista("Lança Perfume","Blusa Lança Perfume Simple Preta de R$ 297,00 por R$ 207,90 em até 6x de R$ 34,65", R.drawable.promocao4,0);
        Item_Lista item5 = new Item_Lista("Comfortflex","Sandália Comfortflex Anabelinha Rosa de R$ 144,90 por R$ 89,90 em até 3x de R$ 29,97", R.drawable.promocao5,0);
        Item_Lista item6 = new Item_Lista("MCQueen","Mochila MCQueen Preta de R$ 119,90 por R$ 109,99 em até 3x de R$ 36,66", R.drawable.promocao6,0);
        Item_Lista item7 = new Item_Lista("Lança Perfume","Jaqueta Lança Perfume Flores Branca de R$ 597,00 por R$ 389,99 em até 12x de R$ 32,50", R.drawable.promocao7,0);
        
        
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
 
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
    	
    	Intent detalhesPromocao = new Intent(this,Detalhe_Promocao.class);	
    	detalhesPromocao.putExtra("titulo", item.titulo.toString());
    	detalhesPromocao.putExtra("descricao", item.descricao.toString());
    	detalhesPromocao.putExtra("img1",item.id_img1); 
    	
		startActivity(detalhesPromocao);
        //Demostração
        Toast.makeText(this, "Você Clicou em: " + item.titulo, Toast.LENGTH_LONG).show();
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
			
		case R.id.btnVoltar:			
			this.finish();
			break;
			
		case R.id.btnContatos:			
			Intent contato = new Intent(this,Contato.class);	
			startActivity(contato);	
			this.finish();
			break;
		
		
		}
		
		
	}

}
