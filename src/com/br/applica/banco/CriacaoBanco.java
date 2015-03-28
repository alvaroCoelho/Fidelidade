package com.br.applica.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriacaoBanco extends SQLiteOpenHelper{
	private static final String NOME_DATABASE = "applica";
	private static final int VERSAO_DATABASE = 1;
	
	
	

	
	private static final String SQL_RESERVA  = "CREATE TABLE reserva ("+
			  "nome_produto TEXT,"+
			   "id_img INTEGER,"+
			  "data_retirada TEXT)";
	

	
	public CriacaoBanco(Context context) {
		super(context, NOME_DATABASE, null, VERSAO_DATABASE);
		
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(SQL_RESERVA);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		
		database.execSQL("DROP TABLE IF EXISTS reserva");
		
		onCreate(database);
		
	}
	
	
	
	
	
	
	
	
	
	

}
