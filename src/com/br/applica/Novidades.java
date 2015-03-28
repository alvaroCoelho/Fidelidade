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
import android.widget.ListView;
import android.widget.Toast;

public class Novidades extends Activity implements OnClickListener,OnItemClickListener{
	
	Button btnVoltar,btnProdutos,btnPromocoes,btnReservas,btnCheckin,btnContato;
	
	private ListView lista;
	private Lista_Adapter_Novidades lista_adapter;
	private ArrayList<Item_Lista_Novidades> itens;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.novidades);
	
	btnVoltar = (Button)findViewById(R.id.btnVoltar);
	btnProdutos = (Button)findViewById(R.id.btnProdutos);
	btnPromocoes = (Button)findViewById(R.id.btnPromocoes);
	btnReservas = (Button)findViewById(R.id.btnReservas);
	btnCheckin = (Button)findViewById(R.id.btnCheckIn);
	btnContato = (Button)findViewById(R.id.btnContatos);
		
	
	btnVoltar.setOnClickListener(this);
	btnProdutos.setOnClickListener(this);
	btnPromocoes.setOnClickListener(this);
	btnReservas.setOnClickListener(this);
	btnCheckin.setOnClickListener(this);
	btnContato.setOnClickListener(this);
	
	lista = (ListView)findViewById(R.id.listViewNovidades);
	
	lista.setOnItemClickListener(this);
	
	createListView();
	
	
	}
	
	
	private void createListView(){
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<Item_Lista_Novidades>();
        Item_Lista_Novidades item1 = new Item_Lista_Novidades("Top Cropped + Saia","Nova Coleção de saias de todas as marcas. Venha conferir!", R.drawable.novidade1,0);
        Item_Lista_Novidades item2 = new Item_Lista_Novidades("Cia Marítima Verão '15","Nova Coleção moda Praia feminina. Venha conferir!", R.drawable.novidade2,0);
        Item_Lista_Novidades item3 = new Item_Lista_Novidades("Rainha do Mar","Coleção em homenagem a todas as Sereias....", R.drawable.novidade3,0);
        Item_Lista_Novidades item4 = new Item_Lista_Novidades("A festa é aqui","Coleção Masculina de Polos, calças, cintos e siders....", R.drawable.novidade4,0);
        Item_Lista_Novidades item5 = new Item_Lista_Novidades("Calçados do Verão","Coleção para calçados masculinos de verão!!!", R.drawable.novidade5,0);
        Item_Lista_Novidades item6 = new Item_Lista_Novidades("Dupla Infalível","Coleção de Camisas e Bermudas...Confiram!", R.drawable.novidade6,0);
        Item_Lista_Novidades item7 = new Item_Lista_Novidades("Top Marcas - Tropical Fevers","Coleções de verão das marcas Calvin Klein Jeans, Colcci, Coca-Cola Jeans, Sommer e Cavalera.", R.drawable.novidade7,0);
        
        
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
 
        //Cria o adapter
        lista_adapter = new Lista_Adapter_Novidades(this,itens);
 
        //Define o Adapter
        lista.setAdapter(lista_adapter);
        //Cor quando a lista é selecionada para ralagem.
        lista.setCacheColorHint(Color.TRANSPARENT);
    }
 
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
       
    	Item_Lista_Novidades item = lista_adapter.getItem(arg2);    	
        Toast.makeText(this, "Você Clicou em: " + item.titulo, Toast.LENGTH_LONG).show();
        Intent detalheNovidade = new Intent(this,Detalhe_Novidade.class);	
        detalheNovidade.putExtra("titulo", item.titulo.toString());
        detalheNovidade.putExtra("descricao", item.descricao.toString());
        detalheNovidade.putExtra("img1",item.id_img1);  
        
		startActivity(detalheNovidade);
    }
	
	
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnVoltar:			
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
			
		case R.id.btnContatos:			
			Intent contato = new Intent(this,Contato.class);	
			startActivity(contato);	
			this.finish();
			break;
		
		
		}
		
		
	}

}
