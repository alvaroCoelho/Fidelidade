package com.br.applica;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Lista_Adapter_Novidades extends BaseAdapter{

	   private LayoutInflater mInflater;
	    private ArrayList<Item_Lista_Novidades> itens;
	 
	    public Lista_Adapter_Novidades(Context context, ArrayList<Item_Lista_Novidades> itens)
	    {
	        //Itens que preencheram o listview
	        this.itens = itens;
	        //responsavel por pegar o Layout do item.
	        mInflater = LayoutInflater.from(context);
	    }
	 
	    /**
	     * Retorna a quantidade de itens
	     *
	     * @return
	     */
	    public int getCount()
	    {
	        return itens.size();
	    }
	 
	    /**
	     * Retorna o item de acordo com a posicao dele na tela.
	     *
	     * @param position
	     * @return
	     */
	    public Item_Lista_Novidades getItem(int position)
	    {
	        return itens.get(position);
	    }
	 
	    /**
	     * Sem implementação
	     *
	     * @param position
	     * @return
	     */
	    public long getItemId(int position)
	    {
	        return position;
	    }
	 
	    public View getView(int position, View view, ViewGroup parent)
	    {
	        //Pega o item de acordo com a posção.
	    	Item_Lista_Novidades item = itens.get(position);
	        //infla o layout para podermos preencher os dados
	        view = mInflater.inflate(R.layout.item_lista_novidades, null);
	 
	        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
	        //ao item e definimos as informações.
	       
	        view.findViewById(R.id.layoutImgNovidades).setBackgroundResource(item.id_img1);	
	        
	        
	        return view;
	    }

}
