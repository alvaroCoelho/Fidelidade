package com.br.applica.banco;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.br.applica.entidades.Reserva;


public class BancoReserva {

	private CriacaoBanco banco;
	
	public BancoReserva(Context context) {
		super();
		this.banco = new CriacaoBanco(context);
		
	}
	
	public void inserir(String nome_produto,int id_img, String data_retirada){
	    
		   ContentValues valores = new ContentValues();
			
			   valores.put("nome_produto", nome_produto);
			   valores.put("id_img", id_img);
			   valores.put("data_retirada", data_retirada);
		 
		    	banco.getWritableDatabase().insert("reserva",null, valores);	
		    	banco.close();
		    
		}
	
	 public ArrayList<Reserva> pesquisaReservas(){
	    	
	    	ArrayList<Reserva> lista = new ArrayList<Reserva>();
	    	
	            Cursor cursor = banco.getWritableDatabase().rawQuery("SELECT * FROM reserva",null);
	    	  
	    	 
	    	     while (cursor.moveToNext()){
	    	    	Reserva novo = new Reserva();
	    	    	novo.setNome_produto(cursor.getString(cursor.getColumnIndex("nome_produto")));
	    	    	novo.setId_img(cursor.getInt(cursor.getColumnIndex("id_img")));
	    	    	novo.setData_retirada(cursor.getString(cursor.getColumnIndex("data_retirada")));
	    	   
	    	     lista.add(novo);
	    	     	}
	    	cursor.close();
	    	banco.close();     
	    	return lista;
	    }
	
	 public void deletar(int id_img){
			
			banco.getReadableDatabase().delete("reserva", "id_img = "+id_img+"",null);
			banco.close();			
				
		}
}
