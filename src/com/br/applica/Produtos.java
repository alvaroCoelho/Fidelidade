package com.br.applica;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Produtos extends Activity implements OnClickListener,OnItemClickListener{

	Button btnNovidades,btnVoltar,btnPromocoes,btnReservas,btnCheckin,btnContato,btnProcurarProduto;
	
	EditText etProcurarProduto;
	
	private ListView lista;
	private Lista_Adapter lista_adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produtos);
		
		btnNovidades = (Button)findViewById(R.id.btnNovidades);
		btnVoltar = (Button)findViewById(R.id.btnVoltar);
		btnPromocoes = (Button)findViewById(R.id.btnPromocoes);
		btnReservas = (Button)findViewById(R.id.btnReservas);
		btnCheckin = (Button)findViewById(R.id.btnCheckIn);
		btnContato = (Button)findViewById(R.id.btnContatos);
		btnProcurarProduto = (Button)findViewById(R.id.btnProcurarProduto);
		
		etProcurarProduto = (EditText)findViewById(R.id.etProcurarProduto);
			
		
		btnNovidades.setOnClickListener(this);
		btnVoltar.setOnClickListener(this);
		btnPromocoes.setOnClickListener(this);
		btnReservas.setOnClickListener(this);
		btnCheckin.setOnClickListener(this);
		btnContato.setOnClickListener(this);
		btnProcurarProduto.setOnClickListener(this);
		
		lista = (ListView)findViewById(R.id.listView1);
		
		lista.setOnItemClickListener(this);
		
	}
	
	
	private void createListView(ArrayList<Item_Lista> itens){
        //Criamos nossa lista que preenchera o ListView
		
   
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
        //Demostração
    	Intent detalheProduto = new Intent(this,Detalhe_Produto.class);	
    	detalheProduto.putExtra("titulo", item.titulo.toString());
    	detalheProduto.putExtra("descricao", item.descricao.toString());
    	detalheProduto.putExtra("img1",item.id_img1);    	
    	detalheProduto.putExtra("img2",item.id_img2);
    	
    	
		startActivity(detalheProduto);
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
		
		case R.id.btnVoltar:			
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
			
		case R.id.btnContatos:			
			Intent contato = new Intent(this,Contato.class);	
			startActivity(contato);	
			this.finish();
			break;
			
			
		case R.id.btnProcurarProduto:	
			
			 ArrayList<Item_Lista> itens = new ArrayList<Item_Lista>();
		     ArrayList<Item_Lista> itens2 = new ArrayList<Item_Lista>();
		   
			 Item_Lista item1 = new Item_Lista("Camisa Masculina - Rusty","Tamanhos P,M,G e GG - Valor R$ 39,90", R.drawable.camisamasc,R.drawable.versocamisamasc);
		     Item_Lista item2 = new Item_Lista("Camisa Masculina - Nike","Tamanhos P,M,G e GG - Valor R$ 89,90", R.drawable.camisamasc1,R.drawable.versocamisamasc1);
		     Item_Lista item3 = new Item_Lista("Bermuda Masculina - Billabong ","Tamanhos P,M e G - Valor R$ 159,90", R.drawable.bermudamasc,R.drawable.versobermudamascverso);
		     Item_Lista item4 = new Item_Lista("Calça Jeans Masculina - Ellus","P,M,G e GG - Valor R$ 219,00", R.drawable.jeansmasc,R.drawable.versojeansmasc);
		     Item_Lista item5 = new Item_Lista("Camiseta Feminina - Forum Y Renda Preta","Tamanhos PP,P,M e G - Valor R$ 131,00", R.drawable.camisetefem,R.drawable.versocamisetafem);
		     Item_Lista item6 = new Item_Lista("Saia Longa - Anna Flynn Renda Verde","Tamanhos P,M e G - Valor R$ 99,90", R.drawable.saia,R.drawable.versosaia);
		     Item_Lista item7 = new Item_Lista("Calça Jeans Feminino - Forum Bootcut Raquel Estonado","Tamanhos PP,P,M e G - Valor R$ 211,00", R.drawable.jeansfem,R.drawable.versojeansfem);

		     itens.add(item1);
		     itens.add(item2);
		     itens.add(item3);
		     itens.add(item4);
		     itens.add(item5);
		     itens.add(item6);
		     itens.add(item7);
			
			
			 String produtoProcurado = etProcurarProduto.getText().toString().trim();
			 
			if(produtoProcurado.equalsIgnoreCase("")){
				
				createListView(itens);
				
			}else{
				 
				 // itens2.clear();
				  
				for (int i = 0; i < itens.size(); i++) {
					
					String item = itens.get(i).titulo.toLowerCase();
					
					if(item.contains(produtoProcurado)){
						itens2.add(itens.get(i));						
					}
					
				}
				
				createListView(itens2);
				
			}
			
			
			
			break;
		
		
		}
		
		
	}

}
